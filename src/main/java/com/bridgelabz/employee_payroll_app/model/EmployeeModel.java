package com.bridgelabz.employee_payroll_app.model;

import jakarta.persistence.*;

@Entity
@Table(name="Employee_Table")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empid;
    private String name;
    private String emailId;
    private String location;
    private long salary;

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
