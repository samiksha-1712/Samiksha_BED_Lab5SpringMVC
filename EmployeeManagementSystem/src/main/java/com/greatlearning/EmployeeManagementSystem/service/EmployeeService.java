package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;
import com.greatlearning.EmployeeManagementSystem.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(int id);
	
	Employee updateEmployee(int id, Employee employee);
	
	void deleteEmployeeById(int id);
}
