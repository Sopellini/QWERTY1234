package com.insurance.InsuranceApp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Created by Sopel on 2017-05-31.
 */
@Entity
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientSequence")
    @SequenceGenerator(name="clientSequence", sequenceName = "client_seq")
    @Column(name = "client_id")
    private int clientId;
    private String name;
    private String name2;
    private String surname;
    private Date dob;
    private Long pesel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Client(){}

    public Client(int clientId, String name, String name2, String surname, Date dob, Long pesel, Contact contact){
        this.clientId = clientId;
        this.name = name;
        this.name2 = name2;
        this.surname = surname;
        this.dob = dob;
        this.pesel = pesel;
        this.contact = contact;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("clientId=").append(clientId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", name2='").append(name2).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", dob=").append(dob);
        sb.append(", pesel=").append(pesel);
        sb.append(", contact=").append(contact);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getClientId() == client.getClientId() &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getName2(), client.getName2()) &&
                Objects.equals(getSurname(), client.getSurname()) &&
                Objects.equals(getDob(), client.getDob()) &&
                Objects.equals(getPesel(), client.getPesel()) &&
                Objects.equals(getContact(), client.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getName(), getName2(), getSurname(), getDob(), getPesel(), getContact());
    }
}
