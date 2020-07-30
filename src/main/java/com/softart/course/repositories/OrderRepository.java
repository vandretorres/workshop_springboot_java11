package com.softart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softart.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
