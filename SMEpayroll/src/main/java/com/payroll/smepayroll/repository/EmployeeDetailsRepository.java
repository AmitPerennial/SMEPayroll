package com.payroll.smepayroll.repository;

import com.payroll.smepayroll.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "Select * from employeeDetails where EmpName=?1 and Designation=?2 and Department=?3", nativeQuery = true)
    Employee findByEmpNameAndDesignationAndDepartment(String empname, String designation, String department);
}
