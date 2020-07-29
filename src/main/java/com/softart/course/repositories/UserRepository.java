package com.softart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softart.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
