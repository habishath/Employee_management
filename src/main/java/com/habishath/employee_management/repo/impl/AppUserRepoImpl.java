package com.habishath.employee_management.repo.impl;

import com.habishath.employee_management.model.ApplicationUser;
import com.habishath.employee_management.model.Role;
import com.habishath.employee_management.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class AppUserRepoImpl implements AppUserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Row Mapper for User
    public static class AppUserRowMapper implements RowMapper<ApplicationUser> {
        @Override
        public ApplicationUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            ApplicationUser user = new ApplicationUser();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUserPassword(rs.getString("password"));
            user.setRole(Role.valueOf(rs.getString("role")));
            return user;
        }
    }

    //Save a User
    @Override
    public ApplicationUser save(ApplicationUser user) {
        String sql = "INSERT INTO app_user(first_name, last_name, email, password, role) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserPassword(),
                user.getRole().name()
        );
        return user;
    }
    

    //Find User by Email
    @Override
    public Optional<ApplicationUser> findByEmail(String email) {
        try {
            String sql = "SELECT * FROM app_user WHERE email = ?";
            ApplicationUser user = jdbcTemplate.queryForObject(sql, new AppUserRowMapper(), email);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ApplicationUser> findByUserId(int userId) {
        try {
            String sql = "SELECT * FROM app_user WHERE user_id = ?";
            ApplicationUser user = jdbcTemplate.queryForObject(sql, new AppUserRowMapper(), userId);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
