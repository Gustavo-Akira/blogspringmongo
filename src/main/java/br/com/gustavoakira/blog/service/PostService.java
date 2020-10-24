package br.com.gustavoakira.blog.service;

import java.util.List;

import br.com.gustavoakira.blog.models.Post;

public interface PostService {
	public Post createPost(Post post) throws Exception;
	public List<Post> getPosts();
	public String removePost(String id);
	public Post getOne(String id);
	public Post update(String id, Post post);
}
