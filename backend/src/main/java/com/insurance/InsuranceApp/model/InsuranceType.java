package com.insurance.InsuranceApp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sopel on 2017-08-13.
 */
@Entity
@Data
@Table(name = "insurance_type")
public class InsuranceType implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ins_type_id")
    private int insuranceTypeId;

    @Column(name = "ins_type")
    private String insuranceType;

    @Column(name = "insurance_amount")
    private double insuranceAmount;

    private double cost;

    @Column(name = "payment_type")
    private String paymentType;
}
