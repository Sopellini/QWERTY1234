package com.insurance.InsuranceApp.service;

import com.insurance.InsuranceApp.model.Client;
import com.insurance.InsuranceApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Created by Sopel on 2017-09-03.
 */
@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientDetails(int id){
        return clientRepository.findOne(id);
    }

    public Client updateClient(int id, Client newClientData){
        Client currentClient = clientRepository.findOne(id);

        currentClient.setName(newClientData.getName());
        currentClient.setName2(newClientData.getName2());
        currentClient.setSurname(newClientData.getSurname());
        currentClient.setDob(newClientData.getDob());
        currentClient.setPesel(newClientData.getPesel());

        currentClient.setContact(newClientData.getContact());

        return clientRepository.save(currentClient);
    }

    public Client createClient(Client client){
        Client newClient = new Client();

        newClient.setName(client.getName());
        newClient.setName2(client.getName2());
        newClient.setSurname(client.getSurname());
        newClient.setDob(client.getDob());
        newClient.setPesel(client.getPesel());
        newClient.setContact(client.getContact());

        return clientRepository.save(newClient);
    }

    public void deleteClient(int id){
        clientRepository.delete(id);
    }

    public boolean isClientExist(Client client){
        if(clientRepository.findByPesel(client.getPesel()) != null) {
            return true;
        }
        return false;
    }

    public List<Client> getIncomingClientBirthdays(){
        Iterable<Client> clients = getAllClients();
        List<Client> clientsWithIncomingBirthday = new ArrayList<>();
        LocalDate birthday, currentDate;
        currentDate = LocalDate.now();

        for (Client client : clients) {
            try {
                birthday = client.getDob().toLocalDate().withYear(currentDate.getYear());
                long period = ChronoUnit.DAYS.between(currentDate, birthday);
                if (period <= 7 && period > 0) {
                    clientsWithIncomingBirthday.add(client);
                }
            }catch(NullPointerException npe){
                System.out.println("Klient " + client.name + " " + client.surname + " nie ma wprowadzonej daty urodzenia.");
            }
        }

        return clientsWithIncomingBirthday;
    }
}
