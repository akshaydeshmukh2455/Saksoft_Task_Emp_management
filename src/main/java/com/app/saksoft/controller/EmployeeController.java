package com.app.saksoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.saksoft.entiy.Employee;
import com.app.saksoft.exception.EmployeeNotFoundException;
import com.app.saksoft.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid Employee emp)
	{
		 Employee employee=service.saveEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
			List<Employee> employee=service.getAllEmployees();
			return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getEmpById/{id}") 
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
			Employee employee=service.getEmployee(id);
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteByEmployeeId(@PathVariable  int id) 
	{
			service.deleteByEmployeeId(id);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		 Employee employee=service.saveEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

}
