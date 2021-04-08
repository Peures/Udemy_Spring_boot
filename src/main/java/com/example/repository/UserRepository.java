package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.entity.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
	@Query("{'email' : ?0}")
	User findByEmailQualquerCoisa(String name);
	
	User findByNameIgnoreCaseLike(String name);
}

