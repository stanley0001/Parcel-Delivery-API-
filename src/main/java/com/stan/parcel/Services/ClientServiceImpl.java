package com.stan.parcel.Services;

import com.stan.parcel.Percistance.Entities.Client;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.Repositories.ClientRepo;
import com.stan.parcel.Repositories.ParcelRepo;
import com.stan.parcel.ServiceImplementation.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final ParcelRepo parcelRepo;

    public ClientServiceImpl(ClientRepo clientRepo, ParcelRepo parcelRepo) {
        this.clientRepo = clientRepo;
        this.parcelRepo = parcelRepo;
    }

    public ResponseModel createClient(Client client){
        ResponseModel response=new ResponseModel();
        String Message;
        Optional<Client> queryData=clientRepo.findBydocumentNumber(client.getDocumentNumber());
        if (queryData.isPresent()){
            Message="Client already exist ";
            response.setStatus(HttpStatus.OK);
            response.setMessage(Message);

            response.setReason(queryData.get().getName());
        }else{
            Client client1=clientCreation(client);
            Message="Client created successfully ";
            response.setStatus(HttpStatus.CREATED);
            response.setMessage(Message);
            response.setReason(client1.getName());
        }

        return response;
    }
    public Client clientCreation(Client client){
        return clientRepo.save(client);
    }
     public Optional<Client> getClientByPhone(String phone){
        return clientRepo.findClientByPhone(phone);
     }
    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }
     public Client getClientById(Long id){

        Client client= clientRepo.findById(id).get();
        client.setSentParcels(parcelRepo.findBySenderId(client.getId()));
        client.setReceivedParcels(parcelRepo.findParcelsByRecipientId(client.getId()));
        return client;
     }
}
