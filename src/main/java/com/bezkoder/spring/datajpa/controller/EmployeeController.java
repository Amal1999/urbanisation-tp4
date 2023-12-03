package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.Employee;
import com.bezkoder.spring.datajpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {

        try {
            Employee employee = employeeRepository.findById(id).get();
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee e) {
        try {
            Employee employee = employeeRepository
                    .save(e);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        try {
            Employee existingEmployee = employeeRepository.findById(id).get();

            if(employee.getFirstName()!=null){
                existingEmployee.setFirstName(employee.getFirstName());
            }
            if(employee.getLastName()!=null){
                existingEmployee.setLastName(employee.getLastName());
            }
            if(employee.getCin()!=null){
                existingEmployee.setCin(employee.getCin());
            }
            if(employee.getPosition()!=null){
                existingEmployee.setPosition(employee.getPosition());
            }
            if(employee.getDateOfBirth()!=null){
                existingEmployee.setDateOfBirth(employee.getDateOfBirth());
            }
            if(employee.getRemainingDaysOff() != null){
                existingEmployee.setRemainingDaysOff(employee.getRemainingDaysOff());
            }

            return new ResponseEntity<>(employeeRepository.save(existingEmployee), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
