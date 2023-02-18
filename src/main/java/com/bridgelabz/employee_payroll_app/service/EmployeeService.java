package com.bridgelabz.employee_payroll_app.service;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDto;
import com.bridgelabz.employee_payroll_app.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeModel employeeModel);

    List<EmployeeDto> viewEmployees();

    EmployeeDto viewEmployeeById(long id);

    EmployeeDto editEmployeeById(long id, EmployeeModel employeeModel);

    void deleteEmployeeById(long id);
}
