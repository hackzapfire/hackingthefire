package com.jstenio.zap_fire.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="zp_user")
public class User {
	
	@Id @GeneratedValue
	@JsonIgnore
	private Integer id;
	
	@Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message="Digite um email valido")
	@Column(name="zp_email", nullable=false,unique=true)
	@NotNull(message="Email obrigatorio")
	private String email;
	
	@Size(min=6,message="A senha deve ter no minimo 6 caracteres")
	@NotNull
	@Column(name="zp_pass", nullable=false)
	@JsonIgnore
	private String password;
	
	@Column(name="zp_name", nullable=false)
	@Size(min=3, message="Nome deve ter no minimo 3 caracteres")
	private String name;
	
	public User() {
		
	}
	
	public User(String name, String email, String password) {
		this.email = email;
		this.password = password;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
