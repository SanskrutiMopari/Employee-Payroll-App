package com.bridgelabz.employee_payroll_app.exception;

import com.bridgelabz.employee_payroll_app.response.EmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice                          //Class Path Scanning
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)             //Exception Handle
    public ResponseEntity<?> UserNotFoundExceptionHandler(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        EmployeeResponse employeeResponse = new EmployeeResponse(message);
        return new ResponseEntity<>(employeeResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)      //validation
    public ResponseEntity<Map<String, String>> handlerMethodArgsNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}
