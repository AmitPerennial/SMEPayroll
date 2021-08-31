package com.payroll.smepayroll.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employeedetails")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Empid")
    private int empid;
    @Column(name="Empname")
    private String empname;
    @Column(name="Designation")
    private String designation;
    @Column(name="Department")
    private String department;
    @Column(name="Dateofbirth")
    private String dateofbirth;
    @Column(name="Phoneno")
    private long phoneno;
    @Column(name="Address")
    private String address;
    @Column(name="City")
    private String city;
    @Column(name="State")
    private String state;
    @Column(name="Pincode")
    private long pincode;
    @Column(name="Dateofjoining")
    private String dateofjoining;

    public Employee() {
    }

    public Employee(int empid, String empname, String designation, String department, String dateofbirth,
                    long phoneno, String address, String city, String state, long pincode, String dateofjoining) {
        this.empid = empid;
        this.empname = empname;
        this.designation = designation;
        this.department = department;
        this.dateofbirth = dateofbirth;
        this.phoneno = phoneno;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.dateofjoining = dateofjoining;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDateofjoining() {
        return dateofjoining;
    }

    public void setDateofjoining(String dateofjoining) {
        this.dateofjoining = dateofjoining;
    }
}
