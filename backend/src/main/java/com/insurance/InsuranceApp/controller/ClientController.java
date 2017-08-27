package com.insurance.InsuranceApp.controller;

import com.insurance.InsuranceApp.model.Client;
import com.insurance.InsuranceApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sopel on 2017-05-31.
 */
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity getAllClients(){
        Iterable<Client> all = clientRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientDetails/{client_id}", method = RequestMethod.GET)
    public ResponseEntity getClientById(@PathVariable int client_id){
        Client client = clientRepository.findOne(client_id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientDetails/{client_id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable int client_id, @RequestBody Client client){
        System.out.println("Updating client " + client_id);

        Client currentClient = clientRepository.findOne(client_id);

        if(currentClient == null){
            System.out.println("Client with id " + client_id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }

        currentClient.setName(client.getName());
        currentClient.setName2(client.getName2());
        currentClient.setSurname(client.getSurname());
        currentClient.setDob(client.getDob());
        currentClient.setPesel(client.getPesel());

        currentClient.getContact().setStreet(client.getContact().getStreet());
        currentClient.getContact().setHouseNumber(client.getContact().getHouseNumber());
        currentClient.getContact().setFlatNumber(client.getContact().getFlatNumber());
        currentClient.getContact().setPostcode(client.getContact().getPostcode());
        currentClient.getContact().setCity(client.getContact().getCity());
        currentClient.getContact().setPhone(client.getContact().getPhone());
        currentClient.getContact().setPhone2(client.getContact().getPhone2());
        currentClient.getContact().setEmail(client.getContact().getEmail());

        clientRepository.save(currentClient);
        return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
    }

}
