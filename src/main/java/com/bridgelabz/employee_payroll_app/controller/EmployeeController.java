package com.bridgelabz.employee_payroll_app.controller;

import com.bridgelabz.employee_payroll_app.model.EmployeeModel;
import com.bridgelabz.employee_payroll_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/post")
    public EmployeeModel add(@RequestBody EmployeeModel employeeModel) {
        return employeeService.addEmployee(employeeModel);
    }

    @GetMapping("/get")
    public List<EmployeeModel> view() {
        return employeeService.viewEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeeModel viewById(@PathVariable long id) {
        return employeeService.viewEmployeeById(id);
    }

    @PutMapping("/put/{id}")
    public EmployeeModel editById(@PathVariable long id,@RequestBody EmployeeModel employeeModel) {
        return employeeService.editEmployeeById(id,employeeModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
         employeeService.deleteEmployeeById(id);
    }
}
