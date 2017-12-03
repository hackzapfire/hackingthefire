package com.jstenio.zap_fire.ws.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recurso {
	
	@Id @GeneratedValue
	private Integer id;
	private String userId;
	private String nome;
	private String tipo;
	private String latitude;
	private String longitude;
	@JsonIgnore
	@OneToMany(mappedBy="recurso")
	private List<Checks> checks;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public List<Checks> getChecks() {
		return checks;
	}
	public void setChecks(List<Checks> checks) {
		this.checks = checks;
	}
	
	
	
	
}
