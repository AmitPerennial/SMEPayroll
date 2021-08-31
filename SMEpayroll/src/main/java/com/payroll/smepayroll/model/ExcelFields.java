package com.payroll.smepayroll.model;

public enum ExcelFields {

    EMPNAME(0),
    DESIGNATION(1),
    DEPARTMENT(2),
    DATEOFBIRTH(3),
    PHONENO(4),
    ADDRESS(5),
    CITY(6),
    STATE(7),
    PINCODE(8),
    DATEOFJOINING(9);

    private final int value;

    ExcelFields(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
