package com.payroll.smepayroll.model;

import javax.persistence.*;

@Entity
@Table(name="payslip")
public class PaySlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Empid")
    private int id;
    @Column(name="Empname")
    private String empname;
    @Column(name="Monthandyear")
    private String monthAndYear;
    @Column(name="Totaldaysinmonth")
    private int totalDaysInMonth;
    @Column(name="Totalpayabledays")
    private int totalPayableDays;
    @Column(name="Basic")
    private double basic;
    @Column(name="Hra")
    private double hra;
    @Column(name="Allowances")
    private double allowances;

    //private List<Allowance> allowances;

    public PaySlip() {
    }

    public PaySlip(int id, String empname, String monthAndYear, int totalDaysInMonth, int totalPayableDays,
                   double basic, double hra, double allowances) {
        this.id = id;
        this.empname = empname;
        this.monthAndYear = monthAndYear;
        this.totalDaysInMonth = totalDaysInMonth;
        this.totalPayableDays = totalPayableDays;
        this.basic = basic;
        this.hra = hra;
        this.allowances = allowances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public int getTotalDaysInMonth() {
        return totalDaysInMonth;
    }

    public void setTotalDaysInMonth(int totalDaysInMonth) {
        this.totalDaysInMonth = totalDaysInMonth;
    }

    public int getTotalPayableDays() {
        return totalPayableDays;
    }

    public void setTotalPayableDays(int totalPayableDays) {
        this.totalPayableDays = totalPayableDays;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getAllowances() {
        return allowances;
    }

    public void setAllowances(double allowances) {
        this.allowances = allowances;
    }

    //    public List<Allowance> getAllowances() {
//        return allowances;
//    }
//
//    public void setAllowances(List<Allowance> allowances) {
//        this.allowances = allowances;
//    }
}
