package com.greatlearning.EmployeeManagementSystem.service;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;
import com.greatlearning.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee employee2 = getEmployeeById(id);
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmail(employee.getEmail());
		return saveEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}
  
}
