package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Client;
import com.stan.parcel.Percistance.Entities.Parcel;
import com.stan.parcel.Percistance.Entities.PickupStation;
import com.stan.parcel.Percistance.Model.ParcelForm;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashboardServiceImpl implements DashboardService {
    private final ParcelServiceImpl parcelService;
    private final ClientServiceImpl clientService;
    private final StationServiceImpl stationService;

    public DashboardServiceImpl(ParcelServiceImpl parcelService, ClientServiceImpl clientService, StationServiceImpl stationService) {
        this.parcelService = parcelService;
        this.clientService = clientService;
        this.stationService = stationService;
    }

    public ResponseModel sendParcel(ParcelForm parcelForm){
        ResponseModel response=new ResponseModel();
        Client sender=new Client();
        sender.setEmail(parcelForm.getSenderEmail());
        sender.setDocumentNumber(parcelForm.getSenderDocumentNumber());
        sender.setName(parcelForm.getSenderName());
        sender.setPhone(parcelForm.getSenderPhone());
        Optional<Client> sender1=clientService.getClientByPhone(parcelForm.getSenderPhone());
        Client recipient=new Client();
        recipient.setEmail(parcelForm.getRecipientEmail());
        recipient.setDocumentNumber(parcelForm.getRecipientDocumentNumber());
        recipient.setName(parcelForm.getRecipientName());
        recipient.setPhone(parcelForm.getRecipientPhone());
        Optional<Client> recipient1=clientService.getClientByPhone(parcelForm.getRecipientPhone());
        if (sender1.isPresent()){
            sender=sender1.get();
           // log.info("Sender exists in the system");
        }else {
           // log.info("Creating sender in the system");
            sender=clientService.clientCreation(sender);
        }
        if (recipient1.isPresent()){
           // log.info("Recipient exists in the system");
            recipient=recipient1.get();
        }else {
            //log.info("Creating recipient in the system");
            recipient=clientService.clientCreation(recipient);
        }
        Optional<PickupStation> destination=stationService.findById(parcelForm.getDestinationId());
        Optional<PickupStation> origin=stationService.findById(parcelForm.getOriginatingId());
        Parcel parcel=new Parcel();
        parcel.setStatus("NEW");
        parcel.setDestinationId(parcelForm.getDestinationId());
        parcel.setOriginationId(parcelForm.getOriginatingId());
        parcel.setRecipient(recipient);
        parcel.setSenderId(sender.getId());
        parcel.setSender(sender);
        parcel.setRecipientId(recipient.getId());
        parcel.setCharges(parcelForm.getCharges());
        parcel.setDestinationStation(destination.get());
        parcel.setWeight(parcelForm.getWeight());
        parcel.setParcelName(parcelForm.getParcelContent());
        parcel.setDescription(parcelForm.getParcelDescription());
        parcel.setAddedBy(parcelForm.getAddedBy());
        parcel.setOriginatingStation(origin.get());

        if (destination.isPresent()){
            if (origin.isPresent()){
                //log.info("All checks passed creating parcel");
                parcelService.createParcel(parcel);
                //log.info("Parcel Created");
                response.setMessage("Parcel Created");
                response.setStatus(HttpStatus.CREATED);
            }
        }

        return response;
    }

}
