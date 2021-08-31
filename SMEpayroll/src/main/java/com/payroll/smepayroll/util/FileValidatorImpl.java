package com.payroll.smepayroll.util;

import com.payroll.smepayroll.bean.ErrorBean;
import com.payroll.smepayroll.model.Employee;
import com.payroll.smepayroll.model.ExcelFields;
import com.payroll.smepayroll.model.PaySlip;
import com.payroll.smepayroll.model.PayslipFields;
import com.payroll.smepayroll.repository.EmployeeDetailsRepository;
import com.payroll.smepayroll.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileValidatorImpl implements FileValidator{

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    private PayslipRepository payslipRepository;

    public List<ErrorBean> validateAndSaveExcelDataToDb(List<List<String>> employeeList){

        Employee employeeDetails;
        List<ErrorBean> errors=new ArrayList<>();
        //Date date = new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

        for (List list: employeeList) {
            employeeDetails=new Employee();
            ErrorBean errorBean=new ErrorBean();
            boolean hasError=false;

//            date=formatter.parse();
//            formatter.format(date);

            String empname=list.get(ExcelFields.EMPNAME.getValue()).toString();
            String designation=list.get(ExcelFields.DESIGNATION.getValue()).toString();
            String department=list.get(ExcelFields.DEPARTMENT.getValue()).toString();
            String dateofbirth=list.get(ExcelFields.DATEOFBIRTH.getValue()).toString();
            String phoneno=list.get(ExcelFields.PHONENO.getValue()).toString();
            String address=list.get(ExcelFields.ADDRESS.getValue()).toString();
            String city=list.get(ExcelFields.CITY.getValue()).toString();
            String state=list.get(ExcelFields.STATE.getValue()).toString();
            String pincode=list.get(ExcelFields.PINCODE.getValue()).toString();
            String dateofjoining=list.get(ExcelFields.DATEOFJOINING.getValue()).toString();
            errorBean.setComment("Columns which Are Null in Employee Details File:- ");
            if(empname.isEmpty()){
                hasError=true;
                errorBean.addComment("Employee Name"+", ");
            }
            if(designation.isEmpty()){
                hasError=true;
                errorBean.addComment("Designation"+", ");
            }
            if(department.isEmpty()){
                hasError=true;
                errorBean.addComment("Department"+", ");
            }
            if(dateofbirth.isEmpty()){
                hasError=true;
                errorBean.addComment("Dateofbirth"+", ");
            }
            if(phoneno.isEmpty()){
                hasError=true;
                errorBean.addComment("Phoneno"+", ");
            }
            if(address.isEmpty()){
                hasError=true;
                errorBean.addComment("Address"+", ");
            }
            if(city.isEmpty()){
                hasError=true;
                errorBean.addComment("City"+", ");
            }
            if(state.isEmpty()){
                hasError=true;
                errorBean.addComment("State"+", ");
            }
            if(pincode.isEmpty()){
                hasError=true;
                errorBean.addComment("Pincode"+", ");
            }
            if(dateofjoining.isEmpty()){
                hasError=true;
                errorBean.addComment("Dateofjoining"+", ");
            }
            if(hasError==true){
                errorBean.setErrorRow(list);
                errorBean.setRowNumber("Excel Sheet Row Number: "+String.valueOf(employeeList.indexOf(list)+2));
                errors.add(errorBean);
            }
            Employee existingData=employeeDetailsRepository.findByEmpNameAndDesignationAndDepartment(empname,designation,department);
            if(existingData==null){
                employeeDetails.setEmpname(empname);
                employeeDetails.setDesignation(designation);
                employeeDetails.setDepartment(department);
                employeeDetails.setDateofbirth(dateofbirth);
                employeeDetails.setPhoneno(Long.valueOf(phoneno));
                employeeDetails.setAddress(address);
                employeeDetails.setCity(city);
                employeeDetails.setState(state);
                employeeDetails.setPincode(Long.valueOf(pincode));
                employeeDetails.setDateofjoining(dateofjoining);
                employeeDetailsRepository.save(employeeDetails);
            }
        }
        return errors;
    }

    @Override
    public List<ErrorBean> validateAndSavePayslipDataToDb(List<List<String>> payslipEntityList) {

        PaySlip paySlip;
        List<ErrorBean> errors=new ArrayList<>();

        for (List list :payslipEntityList) {
            paySlip=new PaySlip();
            ErrorBean error=new ErrorBean();
            boolean hasError=false;

            String empname=list.get(PayslipFields.EMPNAME.getValue()).toString();
            String empid=list.get(PayslipFields.EMPID.getValue()).toString();
            String monthAndYear=list.get(PayslipFields.MONTHANDYEAR.getValue()).toString();
            String totalDaysInMonth=list.get(PayslipFields.TOTALDAYSINMONTH.getValue()).toString();
            String totalPayableDays=list.get(PayslipFields.TOTALPAYABLEDAYS.getValue()).toString();
            String basic=list.get(PayslipFields.BASIC.getValue()).toString();
            String hra=list.get(PayslipFields.HRA.getValue()).toString();
            String allowances=list.get(PayslipFields.ALLOWANCES.getValue()).toString();
            error.setComment("Columns which Are Null in Payslip Excel file:- ");
            if(empname.isEmpty()){
                hasError=true;
                error.addComment("Employee Name"+", ");
            }
            if(empid.isEmpty()){
                hasError=true;
                error.addComment("Employee Id"+", ");
            }
            if(monthAndYear.isEmpty()){
                hasError=true;
                error.addComment("Monthandyear"+", ");
            }
            if(totalDaysInMonth.isEmpty()){
                hasError=true;
                error.addComment("Totaldaysinmonth"+", ");
            }
            if(totalPayableDays.isEmpty()){
                hasError=true;
                error.addComment("Totalpayabledays"+", ");
            }
            if(basic.isEmpty()){
                hasError=true;
                error.addComment("Basic"+", ");
            }
            if(hra.isEmpty()){
                hasError=true;
                error.addComment("Hra"+", ");
            }
            if(allowances.isEmpty()){
                hasError=true;
                error.addComment("Allowances"+", ");
            }
            if(hasError==true){
                error.setErrorRow(list);
                error.setRowNumber("Excel Sheet Row Number: "+String.valueOf(payslipEntityList.indexOf(list)+2));
                errors.add(error);
            }
            PaySlip existingData=payslipRepository.findByNameAndId(empname,empid);
            if(existingData==null){
                paySlip.setEmpname(empname);
                paySlip.setEmpid(Integer.valueOf(empid));
                paySlip.setMonthAndYear(monthAndYear);
                paySlip.setTotalDaysInMonth(Integer.valueOf(totalDaysInMonth));
                paySlip.setTotalPayableDays(Integer.valueOf(totalPayableDays));
                paySlip.setBasic(Long.valueOf(basic));
                paySlip.setHra(Long.valueOf(hra));
                paySlip.setAllowances(Long.valueOf(allowances));
                payslipRepository.save(paySlip);
            }
        }
        return errors;
    }
}
