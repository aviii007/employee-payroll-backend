package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")

    @NotEmpty(message = "Employee name can not be null")
    public String name;
    @Min(value = 500, message = "Minimum salary should be more tha 500")
    public long salary;
    @Pattern(regexp = "male|female",message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "start should not be empty")
    @PastOrPresent(message = "start date should be past or todays")
    public LocalDate startDate;

    @NotBlank(message = "note should not be empty")
    public String note;

    @NotBlank(message = "profile pic should not be empty")
    public String profilePic;

    @NotNull(message = "department should not be empty")
    public List<String> departments;
}