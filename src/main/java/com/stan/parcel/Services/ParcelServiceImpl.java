package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Client;
import com.stan.parcel.Percistance.Entities.Parcel;
import com.stan.parcel.Percistance.Model.Notification;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.Repositories.ClientRepo;
import com.stan.parcel.Repositories.ParcelRepo;
import com.stan.parcel.Repositories.StationRepo;
import com.stan.parcel.ServiceImplementation.MessageService;
import com.stan.parcel.ServiceImplementation.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {
    public final ParcelRepo parcelRepo;
    public final ClientRepo clientRepo;
    public final StationRepo stationRepo;
    private final MessageService messageService;

    public ParcelServiceImpl(ParcelRepo parcelRepo, ClientRepo clientRepo, StationRepo stationRepo, MessageService messageService) {
        this.parcelRepo = parcelRepo;
        this.clientRepo = clientRepo;
        this.stationRepo = stationRepo;
        this.messageService = messageService;
    }

    public ResponseModel createParcel(Parcel parcel){
        ResponseModel response=new ResponseModel();
        parcel.setStatus("NEW");
        parcel.setSenderId(parcel.getSender().getId());
        parcel.setRecipientId(parcel.getRecipient().getId());
        parcel.setOriginationId(parcel.getOriginatingStation().getId());
        parcel.setDestinationId(parcel.getDestinationStation().getId());
        Parcel parcel1=parcelRepo.save(parcel);
        if (parcel1.getStatus()=="NEW"){
            Notification notification=new Notification();
            notification.setNotificationType("SMS");
            notification.setItem("Parcel Received");
            notification.setSchedule(Boolean.FALSE);
            notification.setScheduleTime(LocalDateTime.now());
            Optional<Client> sender =clientRepo.findById(parcel1.getSenderId());
            Optional<Client> recipient =clientRepo.findById(parcel1.getRecipientId());
            String[] recipient1;
            //notification push to sender
            if (sender.isPresent()){
                recipient1= new String[]{sender.get().getPhone()};
                notification.setTo(recipient1);
                notification.setMessage("Thank You be have Received your parcel sent to "+recipient.get().getName()+" at "+parcel.getCreatedAt());
               ResponseModel response1= messageService.createMessage(notification);

            }
            //notification push to recipient
            if (recipient.isPresent()){
                recipient1= new String[]{recipient.get().getPhone()};
                notification.setTo(recipient1);
                notification.setMessage(sender.get().getName()+" Have sent a parcel containing "+parcel.getParcelName()+" You will receive a notification when the Parcel Arrives");
                ResponseModel response1= messageService.createMessage(notification);

            }

            response.setStatus(HttpStatus.CREATED);
            response.setMessage("Parcel created, notification sent");
        }


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
}
