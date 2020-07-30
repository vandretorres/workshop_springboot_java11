package com.softart.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softart.course.entities.Order;
import com.softart.course.services.OrderService;

@RestController   // Anotation indica que esta classe é controladora da entidade Users
@RequestMapping(value = "/orders") // Mapeia qual entidade será controlada 
public class OrderResource {
	
	@Autowired // injeta dependencia automaticamente
	private OrderService service;
	
	
	@GetMapping // anotation indica que este método retornara dados do objeto user
	public ResponseEntity<List<Order>> findAll(){
		
		
		List<Order> list = service.findAll();

		
		return ResponseEntity.ok().body(list);
				
	}
	
	
	
	@GetMapping(value = "/{id}")  // este annotation vai informar que o id será fornecido  via URL e passado para como parametro para o metodo
	// Annotation @PathVariable linka parametro com o valor do annotation
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	

}
