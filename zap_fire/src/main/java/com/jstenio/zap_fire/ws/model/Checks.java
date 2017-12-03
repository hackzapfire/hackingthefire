package com.jstenio.zap_fire.ws.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Checks {
	
	@Id @GeneratedValue
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar begin;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar chekin;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar checkout;
	@ManyToOne
	private Recurso recurso;
	@OneToOne
	private Ocorrencia ocorrencia;
	private String fileCheking;
	private String fileChout;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Calendar getBegin() {
		return begin;
	}
	public void setBegin(Calendar begin) {
		this.begin = begin;
	}
	public Calendar getChekin() {
		return chekin;
	}
	public void setChekin(Calendar chekin) {
		this.chekin = chekin;
	}
	public Calendar getCheckout() {
		return checkout;
	}
	public void setCheckout(Calendar checkout) {
		this.checkout = checkout;
	}
	@JsonIgnore
	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}
	@JsonProperty
	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public String getFileCheking() {
		return fileCheking;
	}
	public void setFileCheking(String fileCheking) {
		this.fileCheking = fileCheking;
	}

	public String getFileChout() {
		return fileChout;
	}
	public void setFileChout(String fileChout) {
		this.fileChout = fileChout;
	}
	@JsonIgnore
	public Recurso getRecurso() {
		return recurso;
	}
	@JsonProperty
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
		
	
}
