package com.sshukla7527.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sshukla7527.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}


