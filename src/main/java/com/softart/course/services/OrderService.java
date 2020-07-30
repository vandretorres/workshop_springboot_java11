package com.softart.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softart.course.entities.Order;
import com.softart.course.entities.User;
import com.softart.course.repositories.OrderRepository;


//Annotation @Component faz o registro da classe no Framework para 
//permitir que outras classes façam inejção de depencencia automatica atarvés do @autowired
// Pode ser utilizado @Repository e @Service podem ser utilizado para registrar repositorios ou Serviços
@Component 
public class OrderService {
	
	
	@Autowired // injeção de dpendencia automática
	private OrderRepository repository;
	
	public List<Order>findAll(){
		
		return repository.findAll();
		
	}
	
	
	
	public Order  findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		
		return obj.get();
	}
	
	 
	

}
