package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Entities.Message;
import com.stan.parcel.Percistance.Model.ResponseModel;

public interface MailService {
    public ResponseModel sendEmail(Message message);
}
