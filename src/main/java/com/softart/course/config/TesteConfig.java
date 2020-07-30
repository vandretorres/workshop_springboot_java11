package com.softart.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.softart.course.entities.User;
import com.softart.course.repositories.UserRepository;

//Classe de configuraçao irá popular o banco de dados H2 quando o programa for inciado



@Configuration // Classe de configuração
@Profile("test") // nome do profile configurado no arquivo application.properties
//CommandLineRunner faz com que o metodo seja instanciado quando o programa iniciar
public class TesteConfig implements CommandLineRunner { 
	
	@Autowired // Spring faz a injeçao de dependencia automaticamente	
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
	}
	
}