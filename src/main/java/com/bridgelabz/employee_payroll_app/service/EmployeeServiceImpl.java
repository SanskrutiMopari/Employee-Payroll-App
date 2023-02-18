package com.bridgelabz.employee_payroll_app.service;

import com.bridgelabz.employee_payroll_app.converter.EmployeeConverter;
import com.bridgelabz.employee_payroll_app.dto.EmployeeDto;
import com.bridgelabz.employee_payroll_app.exception.ResourceNotFoundException;
import com.bridgelabz.employee_payroll_app.model.EmployeeModel;
import com.bridgelabz.employee_payroll_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeConverter employeeConverter;

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDto addEmployee(EmployeeModel employeeModel) {
        EmployeeModel employee = employeeRepository.save(employeeModel);
        return employeeConverter.modelToDto(employee);
    }

    public List<EmployeeDto> viewEmployees() {
        List<EmployeeModel> employeeModel = employeeRepository.findAll();
        return employeeConverter.modelToDtoList(employeeModel);
    }

    public EmployeeDto viewEmployeeById(long id) {
        EmployeeModel employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        return employeeConverter.modelToDto(employee);
    }

    public EmployeeDto editEmployeeById(long id, EmployeeModel employeeModel) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeModel.setId(id);
        EmployeeModel employee = employeeRepository.save(employeeModel);
        return employeeConverter.modelToDto(employee);
    }

    public void deleteEmployeeById(long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.delete(employeeModel);
    }
}
