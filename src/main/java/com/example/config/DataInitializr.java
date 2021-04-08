package com.example.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Pedro", "pedromamona@hotmail.com");
			createUser("João", "emailexemplo@hotmail.com");
			createUser("Maria", "sddsdaquelaraba@hotmail.com");
		}

		User user = userRepository.findByEmailQualquerCoisa("pedromamona@hotmail.com");
		
		
		System.out.println(user.getName());

	}
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRepository.save(user);
	}

}