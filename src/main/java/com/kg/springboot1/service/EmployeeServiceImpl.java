package com.kg.springboot1.service;

import java.util.List;
import com.kg.springboot1.model.Employee;
import com.kg.springboot1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        System.out.println("********GETALL*******");
        return employeeRepository.findAll();
    }

  	@Override
	public void add(Employee employee) {
        employeeRepository.saveAndFlush(employee);
        System.out.println("***************ADD****************");
		
	}


	@Override
	public Employee update(Employee employee,Long pId) {
        System.out.println("***************UPDATE****************");
        employee.setEmployeeId(employee.getEmployeeId());
        return  employeeRepository.saveAndFlush(employee);
       
		
	}






    @Override
    public void delete(Long pId) {
        System.out.println("******delete in service***********");
        employeeRepository.deleteById(pId);
    }

}