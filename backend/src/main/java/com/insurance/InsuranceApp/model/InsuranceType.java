package com.insurance.InsuranceApp.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Sopel on 2017-08-13.
 */
@Entity
@Table(name = "insurance_type")
public class InsuranceType {

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

    @OneToOne(mappedBy = "insuranceType")
    private Insurance insurance;

    public InsuranceType(){}

/*    public InsuranceType(String insuranceType, double insuranceAmount, double cost, String paymentType) {
        this.insuranceType = insuranceType;
        this.insuranceAmount = insuranceAmount;
        this.cost = cost;
        this.paymentType = paymentType;
    }*/

    public int getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(int insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("InsuranceType{");
        sb.append("insuranceTypeId=").append(insuranceTypeId);
        sb.append(", insuranceType='").append(insuranceType).append('\'');
        sb.append(", insuranceAmount=").append(insuranceAmount);
        sb.append(", cost=").append(cost);
        sb.append(", paymentType='").append(paymentType).append('\'');
        sb.append(", insurance=").append(insurance);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsuranceType)) return false;
        InsuranceType that = (InsuranceType) o;
        return getInsuranceTypeId() == that.getInsuranceTypeId() &&
                Double.compare(that.getInsuranceAmount(), getInsuranceAmount()) == 0 &&
                Double.compare(that.getCost(), getCost()) == 0 &&
                Objects.equals(getInsuranceType(), that.getInsuranceType()) &&
                Objects.equals(getPaymentType(), that.getPaymentType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInsuranceTypeId(), getInsuranceType(), getInsuranceAmount(), getCost(), getPaymentType());
    }
}
