package com.stan.parcel.ServiceImplementation;

import com.stan.parcel.Percistance.Entities.Client;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.Repositories.ClientRepo;

import java.util.List;

public interface ClientService {

    ResponseModel createClient(Client client);

    List<Client> getAllClients();

    Client getClientById(Long id);
}
