package com.kg.springboot1;

public class EmployeeBuilder {
    
       private Long employeeId;
       private String firstName;
       private String lastName;
       private Long salary;
       private String department;
       /**
        * @param employeeId the employeeId to set
        *
        */
       Employee employee=new Employee();
    
       public EmployeeBuilder EmployeeId(Long employeeId) {
           employee.setEmployeeId(employeeId);
           return this;
       }
       /**
        * @param firstName the firstName to set
        */
       public EmployeeBuilder FirstName(String firstName) {
           employee.setFirstName(firstName);
           return this;
       }
    /**
    * @param lastName the lastName to set
    */
    public EmployeeBuilder LastName(String lastName) {
       employee.setLastName (lastName);
       return this;
    }
    /**
    * @param department the department to set
    */
    public EmployeeBuilder Department(String department) {
       employee.setDepartment (department);
       return this;
    }
    /**
    * @param salary the salary to set
    */
    public EmployeeBuilder Salary(Long salary) {
       employee.setSalary ( salary);
       return this;
    }
    public Employee Build()
    {
       return employee;
    }
    
    }