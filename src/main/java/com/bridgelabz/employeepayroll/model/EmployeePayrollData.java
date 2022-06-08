package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EmployeePayroll")
@Data
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    @Column(name = "start_date")
    private LocalDate startDate;
    private String note;
    @Column(name = "profile_pic")
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",
            joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;


    public EmployeePayrollData(){}

    public EmployeePayrollData( EmployeePayrollDTO employeePayrollDTO){
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
        this.gender=employeePayrollDTO.gender;
        this.startDate=employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.departments=employeePayrollDTO.departments;
    }
}