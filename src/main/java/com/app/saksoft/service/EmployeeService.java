package com.app.saksoft.service;

import java.util.List;

import com.app.saksoft.entiy.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int id);

	public void deleteByEmployeeId(int id);



}
