package com.bridgelabz.employeepayroll.controller;

/**
 * @author : Ashvini Kanojia
 * @since : 02-06-2022
 */

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller Class
 * Base URL: localhost:8080/employee
 */
@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    /**
     * Method to get the employee data.
     * @return - ResponseEntity consisting response DTO and Status code.
     */
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Ashvini", 30000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * method to get employee data by id.
     * URL - /get/{empId}
     * Creating responseDTO object with message and implementation of getEmployeePayrollData method.
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Ashvini", 30000));
        ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * PostMapping method to create employee in database.
     * URL - /create
     * Creating Employee object using EmployeePayrollDTO object.
     * Creating responseDTO object with message and implementation of adding employee.
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created employee Payroll data successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * PutMapping method to update existing employee.
     * URL- /update
     * Creating responseDTO with message and implementation of updating employee.
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated employee Payroll data successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * DeleteMapping method to delete the employee.
     * Creating responseDTO with message and implementation of deleting employee.
     *URL- /delete
     * @param empId - Id of existing employee that needs to be deleted in path variable.
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted successfully","Deleted id: "+empId);
        return new  ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

}
