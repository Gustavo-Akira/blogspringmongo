package br.com.gustavoakira.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavoakira.blog.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
