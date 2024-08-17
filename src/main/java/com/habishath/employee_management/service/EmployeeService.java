package com.habishath.employee_management.service;

import com.habishath.employee_management.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee findEmployeeById(int id);
    List<Employee> findAllEmployee();
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
