package com.insurance.InsuranceApp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Sopel on 2017-05-31.
 */
@Entity
@Data
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
}
