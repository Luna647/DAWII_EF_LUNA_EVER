package com.cibertec.DAWII_EF_LUNA_EVER.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.DAWII_EF_LUNA_EVER.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}