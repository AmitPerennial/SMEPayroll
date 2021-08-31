package com.payroll.smepayroll.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Allowance {

    @Id
    private int allowanceId;
    private String allowanceName;
    private double Amount;
    private Boolean is_Percentage;
    private Boolean is_Deduction;

    public Allowance() {
    }

    public Allowance(int allowanceId, String allowanceName, double amount, Boolean is_Percentage, Boolean is_Deduction) {
        this.allowanceId = allowanceId;
        this.allowanceName = allowanceName;
        Amount = amount;
        this.is_Percentage = is_Percentage;
        this.is_Deduction = is_Deduction;
    }

    public int getAllowanceId() {
        return allowanceId;
    }

    public void setAllowanceId(int allowanceId) {
        this.allowanceId = allowanceId;
    }

    public String getAllowanceName() {
        return allowanceName;
    }

    public void setAllowanceName(String allowanceName) {
        this.allowanceName = allowanceName;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public Boolean getIs_Percentage() {
        return is_Percentage;
    }

    public void setIs_Percentage(Boolean is_Percentage) {
        this.is_Percentage = is_Percentage;
    }

    public Boolean getIs_Deduction() {
        return is_Deduction;
    }

    public void setIs_Deduction(Boolean is_Deduction) {
        this.is_Deduction = is_Deduction;
    }
}
