package com.bridgelabz.employeepayroll.controller;

/**
 * @author : Ashvini Kanojia
 * @since : 02-06-2022
 */

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller Class
 * Base URL: localhost:8080/employee
 */
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * Method to get the specific employee data by id.
     * Creating responseDTO object with message and implementation of getEmployeePayrollData method.
     *
     * @return - ResponseEntity consisting response DTO and Status code.
     */
    @RequestMapping("/getEmpInfo")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * method to get employee data by id.
     * URL - /get/{empId}
     * Creating responseDTO object with message and implementation of getEmployeePayrollData method.
     *
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable (value = "empId") int empId) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(1);
        ResponseDTO respDTO = new ResponseDTO("Get Call for ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable String department){
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call For Department Successful",employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /**
     * method to create employee in database.
     * URL - /create
     * Creating Employee object using EmployeePayrollDTO object taken from request body.
     * Creating responseDTO object with message and implementation of adding employee.
     *
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        log.debug("Employee DTO: "+empPayrollDTO.toString());
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created employee Payroll data successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.CREATED);
    }

    /**
     * method to update existing employee.
     * URL- /update
     * Creating responseDTO with message and implementation of updating employee by id.
     *
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @PutMapping("/update/{empId")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable("EmpId") int empId,  @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated employee Payroll data successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * method to delete the employee.
     * Creating responseDTO with message and implementation of deleting employee.
     * URL- /delete
     *
     * @param empId - Id of existing employee that needs to be deleted in path variable.
     * @return - ResponseEntity consisting response DTO and Status Code.
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted successfully", "Deleted id: " + empId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

}
