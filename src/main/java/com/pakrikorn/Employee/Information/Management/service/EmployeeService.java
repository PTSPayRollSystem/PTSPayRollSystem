package com.pakrikorn.Employee.Information.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pakrikorn.Employee.Information.Management.employee.Employee;
import com.pakrikorn.Employee.Information.Management.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	@Autowired
	private final EmployeeRepository employeeRepository;

	
	public void addEmployee(Employee employee) {
		    employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees(Employee employee){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeByID(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public void updateEmployee(Long id,Employee updateEmployee) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(null);
		
		if (existingEmployee != null) {
			
			existingEmployee.setFirstName(updateEmployee.getFirstName());
			existingEmployee.setLastName(updateEmployee.getLastName());
			existingEmployee.setAddress(updateEmployee.getAddress());
			existingEmployee.setContactNumber(updateEmployee.getAccountNumber());
			existingEmployee.setEmailAddress(updateEmployee.getEmailAddress());
			existingEmployee.setDateOfBirth(updateEmployee.getDateOfBirth());
			existingEmployee.setEmploymentStartDate(updateEmployee.getEmploymentStartDate());
			existingEmployee.setTaxIdentificationNumber(updateEmployee.getTaxIdentificationNumber());
			existingEmployee.setBankName(updateEmployee.getBankName());
			existingEmployee.setAccountNumber(updateEmployee.getAccountNumber());
			existingEmployee.setRoutingNumber(updateEmployee.getRoutingNumber());
			existingEmployee.setBankBranch(updateEmployee.getBankBranch());
			existingEmployee.setEmployeeOfferLetterReleaseDate(updateEmployee.getEmployeeOfferLetterReleaseDate());
			existingEmployee.setEmployeeDesignation(updateEmployee.getEmployeeDesignation());
			existingEmployee.setJoiningDate(updateEmployee.getJoiningDate());
			existingEmployee.setJoiningCtc(updateEmployee.getJoiningCtc());
			existingEmployee.setHikeLetterDate(updateEmployee.getHikeLetterDate());
			existingEmployee.setHikeCtc(updateEmployee.getHikeCtc());
			existingEmployee.setHikeDesignation(updateEmployee.getHikeDesignation());
			existingEmployee.setHikeLetterEffectiveDate(updateEmployee.getHikeLetterEffectiveDate());
			
			
			
			employeeRepository.save(existingEmployee);
		}
		else {
			throw new EmployeeNotFoundException("EmployeeNotFoundWithID" + id);
		}
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	
}
