package com.habishath.employee_management.repo;

import com.habishath.employee_management.model.ApplicationUser;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AppUserRepo {
    ApplicationUser save(ApplicationUser user);
    Optional<ApplicationUser> findByEmail(String email);
    Optional<ApplicationUser> findByUserId(int userId);
}




