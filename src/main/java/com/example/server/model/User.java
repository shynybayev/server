package com.example.server.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String email;
	
	private String userpic;
	private boolean status;	
	
	public User() {
	}

	public User(int id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}	
	
	public User(int id, String username, String email, String userpic, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.userpic = userpic;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserpic() {
		return userpic;
	}
	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}	
}
