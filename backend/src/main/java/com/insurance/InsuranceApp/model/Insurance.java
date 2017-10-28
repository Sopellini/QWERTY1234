package com.insurance.InsuranceApp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Insurance{");
        sb.append("id=").append(id);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", insuranceType=").append(insuranceType);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurance)) return false;
        Insurance insurance = (Insurance) o;
        return getId() == insurance.getId() &&
                Objects.equals(getStartDate(), insurance.getStartDate()) &&
                Objects.equals(getEndDate(), insurance.getEndDate()) &&
                Objects.equals(getInsuranceType(), insurance.getInsuranceType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDate(), getEndDate(), getInsuranceType());
    }
}
