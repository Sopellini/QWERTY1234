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
    @ResponseBody
    public ResponseEntity allClients(){
        Iterable<Client> all = clientRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/clientDetails/{client_id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getClientById(@PathVariable int client_id){
        Client client = clientRepository.findOne(client_id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
