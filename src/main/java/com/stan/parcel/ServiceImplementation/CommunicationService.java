package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public interface CommunicationService {
    ResponseModel receiveNotification(Message message);
}
