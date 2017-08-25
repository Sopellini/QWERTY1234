package com.insurance.InsuranceApp.model;

import javax.persistence.*;

/**
 * Created by Sopel on 2017-08-25.
 */
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int contact_id;

    @Column(name = "house_number")
    public String houseNumber;

    @Column(name = "flat_number")
    public String flatNumber;

    public String street;
    public String postcode;
    public String city;
    public String phone;
    public String phone2;
    public String email;

    @OneToOne(mappedBy = "contact")
    private Client client;

    public Contact(){}

    public Contact(String houseNumber, String flatNumber, String street, String postcode, String city, String phone, String phone2, String email) {
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
        this.phone2 = phone2;
        this.email = email;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
