package com.payroll.smepayroll.model;

public enum PayslipFields {

    EMPNAME(0),
    EMPID(1),
    MONTHANDYEAR(2),
    TOTALDAYSINMONTH(3),
    TOTALPAYABLEDAYS(4),
    BASIC(5),
    HRA(6),
    ALLOWANCES(7);

    private final int value;

    PayslipFields(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
