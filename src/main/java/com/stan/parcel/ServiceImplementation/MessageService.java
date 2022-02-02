package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.Notification;
import com.stan.parcel.Percistance.Model.ResponseModel;

import java.util.List;

public interface MessageService {
    ResponseModel createMessage(Notification notification);

    List<Message> getOutbox();

    ResponseModel multipleMessages(Notification[] notifications);
}
