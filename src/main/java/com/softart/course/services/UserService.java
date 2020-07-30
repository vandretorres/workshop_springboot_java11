package com.softart.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softart.course.entities.User;
import com.softart.course.repositories.UserRepository;


//Annotation @Component faz o registro da classe no Framework para 
//permitir que outras classes façam inejção de depencencia automatica atarvés do @autowired
// Pode ser utilizado @Repository e @Service podem ser utilizado para registrar repositorios ou Serviços
@Component 
public class UserService {
	
	
	@Autowired // injeção de dpendencia automática
	private UserRepository repository;
	
	public List<User>findAll(){
		
		return repository.findAll();
		
	}
	
	
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);		
		return obj.get();
	}
	
	 
	

}
