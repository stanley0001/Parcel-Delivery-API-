package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Model.Notification;
import com.stan.parcel.Percistance.Model.ResponseModel;

public interface MessageService {
    ResponseModel createMessage(Notification notification);
}
