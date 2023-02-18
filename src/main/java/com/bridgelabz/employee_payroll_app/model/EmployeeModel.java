package com.bridgelabz.employee_payroll_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Employee_Table")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 2, max = 20, message = "Username must be min of 2 characters !!!")
    @Pattern(regexp = "^[A-Z][a-z]{2,}$")
    private String name;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]+[.+-]?[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+[.]?[a-zA-Z]+$",message = "E.g.-> abc123@gmail.com")
    private String emailId;

    @NotEmpty
    private String location;

    private long salary;

    @NotEmpty
    @Pattern(regexp = "^[0-9]{0,2} [0-9]{10}$",message = "E.g.-> 91 7894561230")
    private String phoneNumber;
}
