package com.insurance.InsuranceApp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sopel on 2017-08-25.
 */
@Entity
@Data
public class Contact implements Serializable{
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

}
