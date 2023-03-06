package com.app.saksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.saksoft.entiy.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmpId(int id);
}
