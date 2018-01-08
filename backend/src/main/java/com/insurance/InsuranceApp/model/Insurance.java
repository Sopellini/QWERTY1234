package com.insurance.InsuranceApp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Sopel on 2017-08-13.
 */
@Entity
@Data
public class Insurance implements Serializable{

    @Id
    @Column(name = "insurance_id")
    private int id;

    @Column(name = "datestart")
    private Date startDate;

    @Column(name = "dateend")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "ins_type_id")
    private InsuranceType insuranceType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
