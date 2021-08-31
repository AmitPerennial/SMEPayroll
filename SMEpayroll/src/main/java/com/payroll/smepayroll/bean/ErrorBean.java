package com.payroll.smepayroll.bean;

import java.util.List;

public class ErrorBean {

    private List<String> errorRow;
    private String rowNumber;
    private String comment;

    public ErrorBean() {
    }

    public ErrorBean(List<String> errorRow, String rowNumber, String comment) {
        this.errorRow = errorRow;
        this.rowNumber = rowNumber;
        this.comment = comment;
    }

    public List<String> getErrorRow() {
        return errorRow;
    }

    public void setErrorRow(List<String> errorRow) {
        this.errorRow = errorRow;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void addComment(String comment){
        this.comment+=comment;
    }
}
