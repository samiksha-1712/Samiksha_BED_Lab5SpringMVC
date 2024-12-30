package com.greatlearning.EmployeeManagementSystem.controller;

import com.greatlearning.EmployeeManagementSystem.entity.Employee;
import com.greatlearning.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees() );
        return "employees";
    }

    @GetMapping("/employees/new")
    private String createEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "createEmployee";
    }

    @PostMapping("/employees")
    private String saveEmployee(@ModelAttribute("employee") Employee employee) {
    	employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "editEmployee";
    }
    
    @PostMapping("/employees/{id}")
    private String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {
    	employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    private String deleteEmployee(@PathVariable int id) {
    	employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
