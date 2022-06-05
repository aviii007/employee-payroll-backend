package com.bridgelabz.employeepayroll.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {

    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")

    @NotEmpty(message = "Employee name can not be null")
    public String name;
    @Min(value = 500, message = "Minimum salary should be more tha 500")
    public long salary;

    public EmployeePayrollDTO(String name, long salary){

        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "name="+name+":salary="+salary;
    }
}