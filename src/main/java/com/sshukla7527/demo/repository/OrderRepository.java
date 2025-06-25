package com.sshukla7527.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sshukla7527.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	
}
