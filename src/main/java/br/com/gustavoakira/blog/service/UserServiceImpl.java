package br.com.gustavoakira.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoakira.blog.exceptions.EntityAlreadyExists;
import br.com.gustavoakira.blog.models.User;
import br.com.gustavoakira.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) throws EntityAlreadyExists {
		getUsers().stream().forEach(x->{
			if(x.getEmail() == user.getEmail()) {
				throw new EntityAlreadyExists("User already exitys");
			}
		});
		return repository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public User getOne(String id) {
		Optional<User> op = repository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}

	@Override
	public User update(String id, User user) {
		user.setId(id);
		return repository.save(user);
	}

}
