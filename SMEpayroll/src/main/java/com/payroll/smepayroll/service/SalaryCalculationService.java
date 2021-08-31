package com.payroll.smepayroll.service;

import org.springframework.stereotype.Service;

@Service
public interface SalaryCalculationService {

    public void calculatePFAmount();

    public void calculateNetAmount();
}
