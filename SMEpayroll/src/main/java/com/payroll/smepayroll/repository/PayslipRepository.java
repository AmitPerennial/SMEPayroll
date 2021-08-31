package com.payroll.smepayroll.repository;

import com.payroll.smepayroll.model.PaySlip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayslipRepository extends CrudRepository<PaySlip, Integer> {

    @Query(value = "select * from payslip where Empname=?1 and Empid=?2" , nativeQuery = true)
    PaySlip findByNameAndId(String empname, String empid);
}
