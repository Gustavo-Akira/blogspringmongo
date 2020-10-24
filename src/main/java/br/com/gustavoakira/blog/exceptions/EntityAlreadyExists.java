package br.com.gustavoakira.blog.exceptions;

public class EntityAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityAlreadyExists(String error) {
		super(error);
	}
}
