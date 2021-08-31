package com.payroll.smepayroll.util;

import com.payroll.smepayroll.bean.ErrorBean;

import java.text.ParseException;
import java.util.List;

public interface FileValidator {

    List<ErrorBean> validateAndSaveExcelDataToDb(List<List<String>> employeeEntityList);

    List<ErrorBean> validateAndSavePayslipDataToDb(List<List<String>> payslipEntityList);
}
