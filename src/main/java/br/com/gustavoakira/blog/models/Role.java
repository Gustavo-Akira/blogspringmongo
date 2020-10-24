package br.com.gustavoakira.blog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.gustavoakira.blog.models.enums.RoleEnum;
import lombok.Data;

@Data
@Document(collection = "roles")
public class Role {
	@Id
	private String id;
	
	private RoleEnum name;
}
