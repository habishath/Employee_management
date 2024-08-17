package com.habishath.employee_management.service.impl;

import com.habishath.employee_management.model.Employee;
import com.habishath.employee_management.repo.impl.EmployeeRepoImpl;
import com.habishath.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepoImpl employeeDao;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> employee = employeeDao.findByEmployeeId(id);
        return employee.orElseThrow(() -> new RuntimeException("Employee Not Found for id: " + id));
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDao.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employeeDao.findByEmployeeId(employee.getEmployeeId()).isEmpty()) {
            throw new RuntimeException("Employee not found");
        }
        return employeeDao.update(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = employeeDao.findByEmployeeId(id).orElseThrow(() -> new RuntimeException("Employee Not Found for id: " + id));
        employeeDao.delete(employee);
    }
}
