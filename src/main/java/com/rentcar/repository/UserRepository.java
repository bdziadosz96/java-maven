package com.rentcar.repository;

import com.rentcar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User userToSave);
}
