package com.pakrikorn.Employee.Information.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pakrikorn.Employee.Information.Management.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
