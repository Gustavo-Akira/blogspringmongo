package br.com.gustavoakira.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoakira.blog.exceptions.EntityAlreadyExists;
import br.com.gustavoakira.blog.models.Post;
import br.com.gustavoakira.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;
	
	@Override
	public Post createPost(Post post) throws Exception{
		getPosts().stream().forEach(x->{
			if(x.getEndpoint().equals(post.getEndpoint()) || x.getTitle().equals(post.getTitle())) {
				throw new EntityAlreadyExists("Error post already exists");
			}
		});
		return repository.save(post);
	}

	@Override
	public List<Post> getPosts() {
		return repository.findAll();
	}

	@Override
	public String removePost(String id) {
		if(getOne(id) != null) {
			repository.deleteById(id);
		}
		return "ok";
	}

	@Override
	public Post getOne(String id) {
		Optional<Post> op = repository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}

	@Override
	public Post update(String id, Post post) {
		post.setId(id);
		return repository.save(post);
	}
	
	
}
