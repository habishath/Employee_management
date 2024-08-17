package com.habishath.employee_management.repo;

import com.habishath.employee_management.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo {
    Employee save(Employee employee);
    Optional<Employee> findByEmployeeId(int employeeId);
    List<Employee> findAll();
    Employee update(Employee employee);
    void delete(Employee employee);
}
