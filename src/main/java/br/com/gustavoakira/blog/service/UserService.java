package br.com.gustavoakira.blog.service;

import java.util.List;

import br.com.gustavoakira.blog.exceptions.EntityAlreadyExists;
import br.com.gustavoakira.blog.models.User;

public interface UserService{
	public User save(User user) throws EntityAlreadyExists;
	public List<User> getUsers();
	public User getOne(String id);
	public User update(String id, User user);
}
