package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Client;
import com.stan.parcel.Percistance.Entities.Parcel;
import com.stan.parcel.Percistance.Model.ChangeStatus;
import com.stan.parcel.Percistance.Model.Notification;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.Repositories.ClientRepo;
import com.stan.parcel.Repositories.ConfigurationRepo;
import com.stan.parcel.Repositories.ParcelRepo;
import com.stan.parcel.Repositories.StationRepo;
import com.stan.parcel.ServiceImplementation.MessageService;
import com.stan.parcel.ServiceImplementation.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {
    public final ParcelRepo parcelRepo;
    public final ClientRepo clientRepo;
    public final StationRepo stationRepo;
    private final MessageService messageService;
    private final ConfigurationRepo configurationRepo;

    public ParcelServiceImpl(ParcelRepo parcelRepo, ClientRepo clientRepo, StationRepo stationRepo, MessageService messageService, ConfigurationRepo configurationRepo) {
        this.parcelRepo = parcelRepo;
        this.clientRepo = clientRepo;
        this.stationRepo = stationRepo;
        this.messageService = messageService;
        this.configurationRepo = configurationRepo;
    }

    public ResponseModel createParcel(Parcel parcel){
        ResponseModel response=new ResponseModel();
        parcel.setStatus("NEW");
        parcel.setSenderId(parcel.getSender().getId());
        parcel.setRecipientId(parcel.getRecipient().getId());
        parcel.setOriginationId(parcel.getOriginatingStation().getId());
        parcel.setDestinationId(parcel.getDestinationStation().getId());
        Parcel parcel1=parcelRepo.save(parcel);
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Parcel created, notification sent");
        ChangeStatus status=new ChangeStatus();
        status.setParcelId(parcel1.getParcelId());
        status.setStatus("NEW");
        this.changeParcelStatus(status);
        return response;
    }

    public List<Parcel> getAllParcels(){
        return (List<Parcel>) parcelRepo.findAll();
    }

    public Parcel getParcelById(Long id){
        
        return parcelRepo.findById(id).get();
    }
    public List<Parcel> findBySenderId(Long id){
        Client sender=clientRepo.findById(id).get();
        return parcelRepo.findParcelsBySender(sender).get();
    }

    public ResponseModel changeParcelStatus(ChangeStatus status){
        ResponseModel response=new ResponseModel();
        Parcel parcel=parcelRepo.findById(status.getParcelId()).get();
        Notification notification=new Notification();
        String[] recipient1;
        String[] recipient2;
        String notificationType=configurationRepo.findById(1L).get().getValue();
        notification.setNotificationType(notificationType);
        notification.setItem("Parcel Received");
        notification.setSchedule(Boolean.FALSE);
        notification.setScheduleTime(LocalDateTime.now());
        Client sender=parcel.getSender();
        Client recipient=parcel.getRecipient();
        if (notificationType=="SMS" || notificationType=="TEXT"){
               recipient1= new String[]{sender.getPhone()};
               recipient2= new String[]{recipient.getPhone()};
        }else {
            recipient1= new String[]{sender.getEmail()};
            recipient2= new String[]{recipient.getEmail()};
        }

        notification.setTo(recipient2);
        notification.setMessage(sender.getName()+" Have sent a parcel containing "+parcel.getParcelName()+" You will receive a notification when the Parcel Arrives");
        messageService.createMessage(notification);
        notification.setTo(recipient1);
        notification.setMessage("Thank You We have Received your parcel sent to "+recipient.getName()+" at "+parcel.getCreatedAt());
        messageService.createMessage(notification);














        return response;
    }
}
