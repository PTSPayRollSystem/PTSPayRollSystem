package com.pakrikorn.Employee.Information.Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pakrikorn.Employee.Information.Management.employee.Employee;
import com.pakrikorn.Employee.Information.Management.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {
	
	@Autowired
	private final EmployeeService employeeService;
	

	
	@GetMapping("/list")
	public List<Employee> listEmployees(Employee employee){
		return employeeService.getAllEmployees(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee > getEmployeeById(@PathVariable Long id) {
	     Employee employee = employeeService.getEmployeeByID(id);
	     if(employee != null) {
	    	 return ResponseEntity.ok(employee);
	     }
	     else {
	    	 return ResponseEntity.notFound().build();
	     }
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	  @PutMapping("/update/{id}")
	    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	        employeeService.updateEmployee(id, employee);
	        return ResponseEntity.noContent().build();
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
	    }
	
	    

}
