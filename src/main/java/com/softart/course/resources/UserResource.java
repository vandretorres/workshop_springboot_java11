package com.softart.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softart.course.entities.User;

@RestController   // Anotation indica que esta classe é controladora da entidade Users
@RequestMapping(value = "/users") // Mapeia qual entidade será controlada
public class UserResource {
	
	@GetMapping // anotation indica que este método retornara dados do objeto user
	public ResponseEntity<User>	 findAll(){
		
		User u = new User(1L, "maria", "maria@email", "9999999", "1234");		
		return ResponseEntity.ok().body(u);
		
				
		
	}
	

}
