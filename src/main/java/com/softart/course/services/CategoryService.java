package com.softart.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softart.course.entities.Category;
import com.softart.course.repositories.CategoryRepository;


//Annotation @Component faz o registro da classe no Framework para 
//permitir que outras classes façam inejção de depencencia automatica atarvés do @autowired
// Pode ser utilizado @Repository e @Service podem ser utilizado para registrar repositorios ou Serviços
@Component 
public class CategoryService {
	
	
	@Autowired // injeção de dpendencia automática
	private CategoryRepository repository;
	
	public List<Category>findAll(){
		
		return repository.findAll();
		
	}
	
	
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		
		return obj.get();
	}
	
	 
	

}
