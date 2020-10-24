package br.com.gustavoakira.blog.models;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Document(collection = "users")
public class User {
	@Id
	private String id;
	
	@Email
	@NotBlank
	private String email;
	
	@JsonIgnore
	@NotBlank
	private String password;

	@DBRef
	private Set<Role> role;
}
