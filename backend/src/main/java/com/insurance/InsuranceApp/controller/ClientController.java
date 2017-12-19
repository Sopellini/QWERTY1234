package com.insurance.InsuranceApp.controller;

import com.insurance.InsuranceApp.model.Client;
import com.insurance.InsuranceApp.model.Contact;
import com.insurance.InsuranceApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Sopel on 2017-05-31.
 */
@RestController
@RequestMapping("/api")
public class ClientController {

   @Autowired
    ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity getAllClients(){
        List<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientDetails/{clientId}", method = RequestMethod.GET)
    public ResponseEntity getClientById(@PathVariable int clientId){
        Client client = clientService.getClientDetails(clientId);

        if(client == null){
            return new ResponseEntity<>("Nie znaleziono klienta o ID = " + clientId, HttpStatus.NOT_FOUND);
        }

        if(client.getContact() == null){
            Contact contact = new Contact();
            client.setContact(contact);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientDetails/{clientId}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable int clientId, @RequestBody Client client){
        Client updatedClient = clientService.updateClient(clientId, client);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @RequestMapping(value="/clients", method = RequestMethod.POST)
    public ResponseEntity createClient(@RequestBody Client client) {

        if(clientService.isClientExist(client)){
            return new ResponseEntity<>("Klient już istnieje.", HttpStatus.CONFLICT);
        }

        if(client.getPesel() == null){
            return new ResponseEntity<>("Proszę podać pesel.", HttpStatus.NOT_FOUND);
        }

        Client newClient = clientService.createClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/clientDetails/{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClient(@PathVariable int clientId){
        clientService.deleteClient(clientId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/clientBirthdays", method = RequestMethod.GET)
    public ResponseEntity getIncomingClientBirthdays(){
        List<Client> clientsWithIncomingBirthday = clientService.getIncomingClientBirthdays();
        return new ResponseEntity<>(clientsWithIncomingBirthday, HttpStatus.OK);
    }

}
