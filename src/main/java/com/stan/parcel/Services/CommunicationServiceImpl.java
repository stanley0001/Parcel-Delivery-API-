package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.Services.Communication.InfoBidApiService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CommunicationServiceImpl {


    private  final EmailServiceImpl mailService;
    private final InfoBidApiService sms;

    public CommunicationServiceImpl(EmailServiceImpl mailService, InfoBidApiService sms) {
        this.mailService = mailService;
        this.sms = sms;
    }

    public ResponseModel receiveNotification(Message message){
        String messageType=message.getMessageType();
        ResponseModel responseModel=new ResponseModel();
        if (messageType.equals("SMS") || messageType.equals("TEXT")){
            //phone validation

            return  this.sendSMS(message);
        }else{
            //email validation
            String regex = "^(.+)@(.+)$";
            if (compileVal(message, responseModel, regex)) return responseModel;
            return  this.sendEmail(message);
        }

    }

    private boolean compileVal(Message message, ResponseModel responseModel, String phoneVal) {
        Pattern pattern = Pattern.compile(phoneVal);
        Matcher matcher = pattern.matcher(message.getRecipient());
        if (!matcher.matches()){
            responseModel.setStatus(HttpStatus.BAD_REQUEST);
            responseModel.setMessage(message.getRecipient()+" is not a valid "+message.getMessageType());
            responseModel.setError("Invalid Address");
           // log.info(responseModel);
            return true;
        }
        return false;
    }


    public ResponseModel sendEmail(Message message){
        ResponseModel response;
        //Email and recipient Validation

       // log.info("Sending Email ....");
        response=mailService.sendEmail(message);
       // log.info(response);
        return response;
    }

    public ResponseModel sendSMS(Message message){
        ResponseModel response;
        //SMS and recipient Validation

       // log.info("Sending SMS ....");
        response=sms.send(message);
        return response;
    }

}
