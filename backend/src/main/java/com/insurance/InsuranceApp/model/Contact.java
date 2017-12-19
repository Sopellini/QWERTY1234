package com.insurance.InsuranceApp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Sopel on 2017-08-25.
 */
@Entity
public class Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactSequence")
    @SequenceGenerator(name="contactSequence", sequenceName = "contact_seq")
    @Column(nullable = false)
    private int contact_id;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "flat_number")
    private String flatNumber;

    private String street;
    private String postcode;
    private String city;
    private String phone;
    private String phone2;
    private String email;


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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contact{");
        sb.append("contact_id=").append(contact_id);
        sb.append(", houseNumber='").append(houseNumber).append('\'');
        sb.append(", flatNumber='").append(flatNumber).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", postcode='").append(postcode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", phone2='").append(phone2).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getContact_id() == contact.getContact_id() &&
                Objects.equals(getHouseNumber(), contact.getHouseNumber()) &&
                Objects.equals(getFlatNumber(), contact.getFlatNumber()) &&
                Objects.equals(getStreet(), contact.getStreet()) &&
                Objects.equals(getPostcode(), contact.getPostcode()) &&
                Objects.equals(getCity(), contact.getCity()) &&
                Objects.equals(getPhone(), contact.getPhone()) &&
                Objects.equals(getPhone2(), contact.getPhone2()) &&
                Objects.equals(getEmail(), contact.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContact_id(), getHouseNumber(), getFlatNumber(), getStreet(), getPostcode(), getCity(), getPhone(), getPhone2(), getEmail());
    }
}
