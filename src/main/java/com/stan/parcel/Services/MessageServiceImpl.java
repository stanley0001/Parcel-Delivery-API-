package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.Notification;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.Repositories.MessageRepo;
import com.stan.parcel.ServiceImplementation.MessageService;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

@Service
@Log4j
@EnableScheduling
public class MessageServiceImpl implements MessageService {
     private final MessageRepo messageRepo;
     private final CommunicationServiceImpl communicationService;


    public MessageServiceImpl(MessageRepo messageRepo, CommunicationServiceImpl communicationService) {
        this.messageRepo = messageRepo;
        this.communicationService = communicationService;
    }
public ResponseModel multipleMessages(Notification[] notifications){
        ResponseModel response=new ResponseModel();
        Integer count=0;
    for (Notification notification:
         notifications) {

        this.createMessage(notification);
        count=+1;
    }
    response.setStatus(HttpStatus.OK);
    response.setMessage(count+" Notification(s) sent");
    return response;
}
    String bulkId;
    String batchRef;
    public ResponseModel createMessage(Notification notification){
        ResponseModel response=new ResponseModel();
        Stack<String> sentMessageData = new Stack<String>();

        Integer sentMessageCount=0;
        bulkId= String.valueOf(System.currentTimeMillis());
        log.info("Received Notification(s) received with ref: "+bulkId);
        if (notification.getTo().length>0){
            for (String recipient:
                    notification.getTo()) {
                batchRef= String.valueOf(System.currentTimeMillis());
                Message message=new Message();
                message.setBulkId(bulkId);
                message.setBatchId(batchRef);
                message.setStatus("NEW");
                message.setMessage(notification.getMessage());
                message.setMessageType(notification.getNotificationType());
                message.setCreatedAt(LocalDateTime.now());
                message.setScheduled(notification.getSchedule());
                message.setScheduledTime(notification.getScheduleTime());
                message.setSubject(notification.getItem());
                message.setRecipient(recipient);
                     if (message.getScheduled()==null){
                         message.setScheduled(false);
                     }
                     log.info("Notification received with ref: "+message.getBatchId());
                sentMessageData.push(messageRepo.save(message).toString());
                log.info("Notification saved with ref: "+message.getBatchId());
                     response.setReason(sentMessageData.toString());
                     sentMessageCount+=1;
            }
            response.setStatus(HttpStatus.OK);
            response.setMessage("Message Count: "+sentMessageCount);
        }

        return response;
    }
    public List<Message> getOutbox(){

        log.info("Getting all messages");
        return messageRepo.findAll();
    }

    //Sending of Notifications
    @Scheduled(fixedRate = 100L)
    public void notificationTrigger(){
        List<Message> messages=messageRepo.findByStatus("NEW");
        for (Message message:
             messages) {
            if (message.getRetries()==null){
                message.setRetries(0L);
            }
            message.setRetries(message.getRetries()+1);
            message.setStatus("PROCESSING");

            if (message.getScheduled()==Boolean.FALSE){
                message.setUpdatedAt(LocalDateTime.now());
                messageRepo.save(message);
                log.info("Sending notification ref: "+message.getBatchId());
                this.SendToNextInstance(message);

            }else
            {
                //Send scheduled sms
                if (message.getScheduledTime().isBefore(LocalDateTime.now())){
                    message.setUpdatedAt(LocalDateTime.now());
                    messageRepo.save(message);
                    log.info("Sending notification ref: "+message.getBatchId());
                    this.SendToNextInstance(message);

                }
            }

        }

    }

    @Scheduled(fixedRate = 100L)
    public void resend() {
        List<Message> messages = messageRepo.findByStatus("PROCESSING");
        for (Message message:
             messages) {
            //checking retry attempts
            if (message.getRetries()<3) {
                //Retry after 2 minutes
                if (message.getUpdatedAt().isBefore(LocalDateTime.now().minusMinutes(2))) {
                    message.setRetries(message.getRetries() + 1);
                    message.setUpdatedAt(LocalDateTime.now());
                    messageRepo.save(message);
                    log.info("Rending notification ref: "+message.getBatchId());
                    this.SendToNextInstance(message);
                }
            }else{
                //maximum attempt check
                message.setStatus("FAILED-MAX-ATTEMPT");
                log.info("notification sending failed with error FAILED-MAX-ATTEMPT notification ref: "+message.getBatchId());
                messageRepo.save(message);
            }
        }
    }

public ResponseModel SendToNextInstance(Message message){
    //code to send to communication service
    log.info("passing to communication service notification ref: "+message.getBatchId());
    ResponseModel response=communicationService.receiveNotification(message);
    log.info("communication service response "+response);
    if(response.getStatus()!=HttpStatus.OK){
        //Failing all status
        message.setStatus("FAILED");
        if (response.getStatus()!=HttpStatus.BAD_GATEWAY){
            //setting room for retries
            message.setStatus("PROCESSING");
            if (response.getError()=="Invalid Address"){
                message.setStatus("Invalid Address "+message.getRecipient());
            }
        }
    }else {
        //updating success status
        message.setStatus("PROCESSED");
    }
    messageRepo.save(message);
  return response;
}

}
