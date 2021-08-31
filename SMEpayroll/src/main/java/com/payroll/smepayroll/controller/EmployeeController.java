package com.payroll.smepayroll.controller;

import com.payroll.smepayroll.bean.ErrorBean;
import com.payroll.smepayroll.model.Employee;
import com.payroll.smepayroll.service.EmployeeService;
import com.payroll.smepayroll.service.FileUploadService;
import com.payroll.smepayroll.ui.response.ResponseModel;
import com.payroll.smepayroll.util.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping(value ="/save" , method = RequestMethod.POST)
    public Employee saveEmployee(){
        return employeeService.saveEmployee();
    }

    @RequestMapping(value = "/empdetail",method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<?>> uploadEmployeeDetailsFileToDb(@RequestParam("File") MultipartFile multipartFile) throws IOException, ParseException {

        List<List<String>> employeeEntityList = fileUploadService.parseExcelFile(multipartFile);
        List<ErrorBean> resultBean = fileValidator.validateAndSaveExcelDataToDb(employeeEntityList);
        final ResponseModel<?> responseModel = new ResponseModel<>(HttpStatus.OK.value(),
                "File is Successfully Uploaded and Result is: ", resultBean);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/payslipdata" ,method = RequestMethod.POST)
    public ResponseEntity<ResponseModel<?>> uploadPayslipDetailsFileToDb(@RequestParam("File") MultipartFile multipartFile) throws IOException, ParseException {

        List<List<String>> payslipEntityList = fileUploadService.parseExcelFile(multipartFile);
        List<ErrorBean> resultBean = fileValidator.validateAndSavePayslipDataToDb(payslipEntityList);
        final ResponseModel<?> responseModel = new ResponseModel<>(HttpStatus.OK.value(),
                "File is Successfully Uploaded and Result is: ", resultBean);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}


