package com.example.taskjpa.demotaskjpa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskjpa.demotaskjpa.Entity.Employee;
import com.example.taskjpa.demotaskjpa.Repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee>getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public void deleteEmployeeById(Long id)
    {
        employeeRepository.deleteById(id);
    }
    //TYPE :1

    // public double calculateSalary(Long id,int leaveDays)
    // {
    //     Optional<Employee> employeeOptional = employeeRepository.findById(id);
    //     if(employeeOptional.isPresent())
    //     {
    //         Employee employee=employeeOptional.get();
    //         double dailyDeduction = employee.getSalary() / 30.0;
    //         return employee.getSalary()-(leaveDays*dailyDeduction);
    //     }
    //     else {
    //         throw new RuntimeException("Employee not found");
    //     }
    // }
//TYPE :2
    // public double calculateSalary(Long id) {
    //     Optional<Employee> employeeOptional = employeeRepository.findById(id);
    //     if (employeeOptional.isPresent()) {
    //         Employee employee = employeeOptional.get();
    //         double dailyDeduction = employee.getSalary() / 30.0;
    //         int leaveDays = employee.getleaveDays();
    //         return employee.getSalary() - (leaveDays * dailyDeduction);
    //     } else {
    //         throw new RuntimeException("Employee not found");
    //     }

//TYPE :3
        public double calculateSalary(Long id) {
            Optional<Employee> employeeOptional = employeeRepository.findById(id);
            if (employeeOptional.isPresent()) {
                Employee employee = employeeOptional.get();
                double dailyDeduction = employee.getSalary() / 30.0;
                int leaveDays = employee.getleaveDays();
                double calculatedSalary = employee.getSalary() - (leaveDays * dailyDeduction);
                employee.setCalculatedSalary(calculatedSalary); // Update the calculated salary
                employeeRepository.save(employee); // Save the updated employee
                return calculatedSalary;
            } else {
                throw new RuntimeException("Employee not found");
            }
        }
    }

