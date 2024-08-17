package com.habishath.employee_management.repo;

import com.habishath.employee_management.model.ApplicationUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo {
    ApplicationUser save(ApplicationUser user);
    Optional<ApplicationUser> findByEmail(String email);
    Optional<ApplicationUser> findByUserId(int userId);
}




