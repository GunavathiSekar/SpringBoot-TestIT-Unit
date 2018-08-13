package com.kg.springboot1.service;

import java.io.Serializable;
import java.util.List;

import com.kg.springboot1.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeService {
    public void add(Employee employee);
	public Employee update(Employee employee,Long pId);
	public List<Employee> getAll();
	public void delete(Long id);


}