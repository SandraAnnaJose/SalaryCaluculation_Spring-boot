package com.example.taskjpa.demotaskjpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskjpa.demotaskjpa.Entity.Employee;
import com.example.taskjpa.demotaskjpa.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    // @GetMapping("/{id}/salary/{leaveDays}")
    // public double getEmployeeSalary(@PathVariable Long id, @PathVariable int leaveDays) {
    //     return employeeService.calculateSalary(id, leaveDays);
    // }

    @GetMapping("/{id}/salary")
    public double getEmployeeSalary(@PathVariable Long id) {
        return employeeService.calculateSalary(id);
    }
}
