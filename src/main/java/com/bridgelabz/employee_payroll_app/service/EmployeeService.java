package com.bridgelabz.employee_payroll_app.service;

import com.bridgelabz.employee_payroll_app.model.EmployeeModel;
import com.bridgelabz.employee_payroll_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> viewEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel viewEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeeModel editEmployeeById(long id,EmployeeModel employeeModel) {
        employeeModel.setEmpid(id);
        return employeeRepository.save(employeeModel);
    }

    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }
}
