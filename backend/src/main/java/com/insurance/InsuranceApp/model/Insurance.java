package com.insurance.InsuranceApp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Sopel on 2017-08-13.
 */
@Entity
public class Insurance implements Serializable{

    @Id
    @Column(name = "insurance_id")
    private int id;

    @Column(name = "datestart")
    private Date startDate;

    @Column(name = "dateend")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "ins_type_id")
    private InsuranceType insuranceType;


    public Insurance(){}

    public Insurance(int id, Date startDate, Date endDate, InsuranceType insuranceType) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuranceType = insuranceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public InsuranceType getInsuranceType(){
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType){
        this.insuranceType = insuranceType;
    }
}
