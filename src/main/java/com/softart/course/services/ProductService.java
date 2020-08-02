package com.softart.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softart.course.entities.Product;
import com.softart.course.repositories.ProductRepository;


//Annotation @Component faz o registro da classe no Framework para 
//permitir que outras classes façam inejção de depencencia automatica atarvés do @autowired
// Pode ser utilizado @Repository e @Service podem ser utilizado para registrar repositorios ou Serviços
@Component 
public class ProductService {
	
	
	@Autowired // injeção de dpendencia automática
	private ProductRepository repository;
	
	public List<Product>findAll(){
		
		return repository.findAll();
		
	}
	
	
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		
		return obj.get();
	}
	
	 
	

}
