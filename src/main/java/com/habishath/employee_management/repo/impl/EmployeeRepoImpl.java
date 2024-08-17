package com.habishath.employee_management.repo.impl;

import com.habishath.employee_management.model.Employee;
import com.habishath.employee_management.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Row Mapper for Employee
    public static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setPosition(rs.getString("position"));
            return employee;
        }
    }

    //Save an Employee
    @Override
    public Employee save(Employee employee) {
        String sql = "INSERT INTO employee(name, email, position) VALUES(?,?,?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getPosition());
        return employee;
    }

    //Find an Employee By ID
    @Override
    public Optional<Employee> findByEmployeeId(int employeeId) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        try {
            Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), employeeId);
            return Optional.ofNullable(employee);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    //Retrieve All Employees
    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    //Update an Employee by ID
    @Override
    public Employee update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, email = ?, position = ? WHERE employee_id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getPosition(), employee.getEmployeeId());
        return employee;
    }

    //Delete an Employee By ID
    @Override
    public void delete(Employee employee) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(sql, employee.getEmployeeId());
    }

}