package com.softart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softart.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
