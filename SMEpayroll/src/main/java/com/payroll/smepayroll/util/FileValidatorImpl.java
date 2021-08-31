package com.payroll.smepayroll.util;

import com.payroll.smepayroll.bean.ErrorBean;
import com.payroll.smepayroll.model.Employee;
import com.payroll.smepayroll.model.ExcelFields;
import com.payroll.smepayroll.repository.EmployeeDetailsRepository;
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

    public List<ErrorBean> validateAndSaveExcelDataToDb(List<List<String>> employeeList) throws ParseException {

        Employee employeeDetails;
        List<ErrorBean> errors=new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

        for (List list: employeeList) {
            employeeDetails=new Employee();
            ErrorBean errorBean=new ErrorBean();
            boolean hasError=false;

            String empname=list.get(ExcelFields.EMPNAME.getValue()).toString();
            String designation=list.get(ExcelFields.DESIGNATION.getValue()).toString();
            String department=list.get(ExcelFields.DEPARTMENT.getValue()).toString();
//            date= formatter.parse();
//            formatter.format(date);
            String dateofbirth=list.get(ExcelFields.DATEOFBIRTH.getValue()).toString();
            String phoneno=list.get(ExcelFields.PHONENO.getValue()).toString();
            String address=list.get(ExcelFields.ADDRESS.getValue()).toString();
            String city=list.get(ExcelFields.CITY.getValue()).toString();
            String state=list.get(ExcelFields.STATE.getValue()).toString();
            String pincode=list.get(ExcelFields.PINCODE.getValue()).toString();
//            date=formatter.parse();
//            formatter.format(date);
            String dateofjoining=list.get(ExcelFields.DATEOFJOINING.getValue()).toString();
            errorBean.setComment("Columns which Are Null:- ");
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
}
