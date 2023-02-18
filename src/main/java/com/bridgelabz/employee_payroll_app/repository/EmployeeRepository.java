package com.bridgelabz.employee_payroll_app.repository;

import com.bridgelabz.employee_payroll_app.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}
