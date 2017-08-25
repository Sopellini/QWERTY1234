package com.insurance.InsuranceApp.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Sopel on 2017-05-31.
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int client_id;
    public String name;
    public String name2;
    public String surname;
    public Date dob;
    public Long pesel;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Client(){}

    public Client(int client_id, String name, String name2, String surname, Date dob, Long pesel, Contact contact){
        this.client_id = client_id;
        this.name = name;
        this.name2 = name2;
        this.surname = surname;
        this.dob = dob;
        this.pesel = pesel;
        this.contact = contact;
    }

    public int getClientId() {
        return client_id;
    }

    public void setClientId(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
