package com.insurance.InsuranceApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    /* Foreign keys - to define properly
    Integer contact_id;
    Integer insurance_id;*/

    public Client(){}

    public Client(int client_id, String name, String name2, String surname, Date dob, Long pesel){
        this.client_id = client_id;
        this.name = name;
        this.name2 = name2;
        this.surname = surname;
        this.dob = dob;
        this.pesel = pesel;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
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
}
