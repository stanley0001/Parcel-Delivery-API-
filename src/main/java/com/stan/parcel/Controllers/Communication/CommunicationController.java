package com.stan.parcel.Controllers.Communication;

import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.Notification;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.MessageService;
import org.hibernate.mapping.Any;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Communication")
public class CommunicationController {
    private final MessageService messageService;
    private final MessageService communicationService;

    public CommunicationController(MessageService messageService, MessageService communicationService) {
        this.messageService = messageService;
        this.communicationService = communicationService;
    }

    @GetMapping("/Outbox")
    public ResponseEntity<List<Message>> getOutBox(){
        List<Message> outbox=messageService.getOutbox();
      return new ResponseEntity<>(outbox, HttpStatus.OK);
    }
    @PostMapping("sendNotification")
    public ResponseEntity<ResponseModel> sendNotification(@RequestBody Notification notification){
        ResponseModel response=communicationService.createMessage(notification);

        return new ResponseEntity<>(response,response.getStatus());
    }
    @PostMapping("receiveCallBack")
    public ResponseEntity<Any> sendNotification( Any notification){


        return new ResponseEntity<>(notification, HttpStatus.OK);
    }
}

