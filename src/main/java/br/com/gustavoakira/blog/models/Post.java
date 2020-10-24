package br.com.gustavoakira.blog.models;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "posts")
public class Post {
	
	@Id
	private String id;
	
	@NotBlank
	@Indexed(unique = true)
	private String endpoint;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date date = new Date();
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String subtitle;
	
	@NotBlank
	private String text;
	
}
