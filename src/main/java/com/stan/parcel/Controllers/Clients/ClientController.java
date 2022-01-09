package com.stan.parcel.Controllers.Clients;

import com.stan.parcel.Percistance.Entities.Client;
import com.stan.parcel.Percistance.Model.ResponseModel;
import com.stan.parcel.ServiceImplementation.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseModel> createClient(@RequestBody Client client){
        ResponseModel response=clientService.createClient(client);
        return new ResponseEntity<>(response, response.getStatus());
    }
    @GetMapping("getAll")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients= clientService.getAllClients();
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @GetMapping("getClient{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Client client=clientService.getClientById(id);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }
}
