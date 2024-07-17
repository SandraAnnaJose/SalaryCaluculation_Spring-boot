package com.example.taskjpa.demotaskjpa.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String name;
    private int age;
    private LocalDate doj;
    private double salary;
    private int leaveDays;
    private double calculatedSalary;
    public Employee() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public LocalDate getDoj() {
        return doj;
    }
    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getleaveDays() {
        return leaveDays;
    }
    public void setLeave(int leaveDays) {
        this.leaveDays = leaveDays;
    }
    public double getCalculatedSalary() {
        return calculatedSalary;
    }
    public void setCalculatedSalary(double calculatedSalary) {
        this.calculatedSalary = calculatedSalary;
    }
    
}
