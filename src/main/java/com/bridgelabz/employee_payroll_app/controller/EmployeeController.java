package com.bridgelabz.employee_payroll_app.controller;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDto;
import com.bridgelabz.employee_payroll_app.exception.ResourceNotFoundException;
import com.bridgelabz.employee_payroll_app.model.EmployeeModel;
import com.bridgelabz.employee_payroll_app.response.EmployeeResponse;
import com.bridgelabz.employee_payroll_app.service.EmployeeService;
import com.bridgelabz.employee_payroll_app.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/post")
    public ResponseEntity<EmployeeDto> add(@Valid @RequestBody EmployeeModel employeeModel) {
        EmployeeDto employeeDto = employeeService.addEmployee(employeeModel);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> view() {
        return ResponseEntity.ok(employeeService.viewEmployees());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> viewById(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.viewEmployeeById(id));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<EmployeeDto> editById(@PathVariable long id, @Valid @RequestBody EmployeeModel employeeModel) {
        return ResponseEntity.ok(employeeService.editEmployeeById(id, employeeModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(new EmployeeResponse("Employee Deleted Successfully!!!"),HttpStatus.OK);
    }
}
