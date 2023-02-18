package com.bridgelabz.employee_payroll_app.converter;

import com.bridgelabz.employee_payroll_app.dto.EmployeeDto;
import com.bridgelabz.employee_payroll_app.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {

    // Here we are create a method modelToDto to convert model to dto :-
    public EmployeeDto modelToDto(EmployeeModel employeeModel) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeModel.getId());
        employeeDto.setName(employeeModel.getName());
        employeeDto.setEmailId(employeeModel.getEmailId());
        return employeeDto;
    }

    public List<EmployeeDto> modelToDtoList(List<EmployeeModel> employeeModel) {
        return employeeModel.stream().map(x -> modelToDto(x)).collect(Collectors.toList());
    }

    // Here we are create a method dtoToModel to convert dto to model :-
    public EmployeeModel dtoToModel(EmployeeDto employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employeeDto.getId());
        employeeModel.setName(employeeDto.getName());
        employeeModel.setEmailId(employeeDto.getEmailId());
        return employeeModel;
    }

    public List<EmployeeModel> dtoToModelList(List<EmployeeDto> employeeDto) {
        return employeeDto.stream().map(this::dtoToModel).collect(Collectors.toList());
    }
}
