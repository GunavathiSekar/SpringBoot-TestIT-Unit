package com.kg.springboot1.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.kg.springboot1.model.Employee;
import com.kg.springboot1.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

import org.springframework.http.HttpStatus;

/**
 * EmployeeController
 */
@RestController

@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // @RequestMapping(value = "/")
    // public Iterable<Employee> sample() {
    // return employeeRepository.findByDepartmentAndSalaryLessThan("DEPARTMENT6",
    // 5000L);

    // }
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Employee> read() {
        return employeeRepository.findAll();
    }

    // @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    // public Optional<Employee> readOne(@PathVariable Long employeeId) {
    //     System.out.println(employeeRepository.findById(employeeId));
    //     return employeeRepository.findById(employeeId);
    // }

    @RequestMapping(method = RequestMethod.POST)
    public Employee add(@RequestBody Employee employee) {
        employee.setEmployeeId(null);
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "{employeeId}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        // Optional<Employee> employee = employeeRepository.findById(employeeId);
        updatedEmployee.setEmployeeId(employeeId);
        return employeeRepository.saveAndFlush(updatedEmployee);
    }

    @RequestMapping(value = "{employeeId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("employeeId") Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @RequestMapping(value = "date", method = RequestMethod.GET)
    public Long difference(@RequestParam Date d1,@RequestParam Date d2) throws ParseException
    {  
        long datediff=(d2.getTime()-d1.getTime())/(24*60*60*1000);
        
       System.out.println("Days between "+d1+"and" +d2+ " = " + (d2.getTime()-d1.getTime())/(24*60*60*1000));
       return datediff;
    }

	
}
