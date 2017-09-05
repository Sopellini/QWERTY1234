package com.insurance.InsuranceApp.controller;

import com.insurance.InsuranceApp.model.Client;
import com.insurance.InsuranceApp.model.Contact;
import com.insurance.InsuranceApp.repository.ClientRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

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
    @Transactional
    public ResponseEntity<Client> updateClient(@PathVariable int client_id, @RequestBody Client client){
        System.out.println("Updating client " + client_id);

        Client currentClient = clientRepository.findOne(client_id);
        Contact currentContact = currentClient.getContact();

        if(currentContact == null){
            currentContact = new Contact();
            currentClient.setContact(currentContact);
            clientRepository.save(currentClient);
        }

        currentClient.setName(client.getName());
        currentClient.setName2(client.getName2());
        currentClient.setSurname(client.getSurname());
        currentClient.setDob(client.getDob());
        currentClient.setPesel(client.getPesel());

        currentClient.setContact(client.getContact());

        clientRepository.save(currentClient);
        return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
    }

}
