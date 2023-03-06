package com.app.saksoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.saksoft.entiy.Employee;
import com.app.saksoft.exception.EmployeeNotFoundException;
import com.app.saksoft.repository.EmployeeRepository;
import com.app.saksoft.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee emp) {
	Employee employee	=Employee
			.build(emp.getEmpId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getAge());
	return repo.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repo.findAll();
	}

	@Override
	public Employee getEmployee(int id) throws EmployeeNotFoundException{
		Employee employee=repo.findByEmpId(id);
		if(employee != null)
		{
			return employee;
		}
		else
		{
			throw new EmployeeNotFoundException("Employee not found with id: "+id);
		}
		
	}

	@Override
	public void deleteByEmployeeId(int id)  {
		repo.deleteById(id);
		
	}

	
}
