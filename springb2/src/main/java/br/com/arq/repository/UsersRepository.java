package br.com.arq.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.arq.model.Users;

public interface UsersRepository extends MongoRepository<Users, String>{

}
