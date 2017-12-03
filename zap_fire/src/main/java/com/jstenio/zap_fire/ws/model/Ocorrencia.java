package com.jstenio.zap_fire.ws.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.jstenio.zap_fire.util.Sexo;

@Entity
@XmlRootElement
public class Ocorrencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue
	private Integer id;
	@Column(nullable=false)
	private String nome;
	private String telefone;
	private String municipio;
	@Column
	private String endereco;
	private Integer numero;
	private String bairro;
	private String referencia;
	private String paciente_nome;
	private Integer paciente_idade;
	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;
	private String queixa;
	private String obervacoes;
	private boolean chamadaMedica;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar inicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fim;
	private char status;
	@OneToOne
	private Checks checks;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getPaciente_nome() {
		return paciente_nome;
	}
	public void setPaciente_nome(String paciente_nome) {
		this.paciente_nome = paciente_nome;
	}
	public Integer getPaciente_idade() {
		return paciente_idade;
	}
	public void setPaciente_idade(Integer paciente_idade) {
		this.paciente_idade = paciente_idade;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getQueixa() {
		return queixa;
	}
	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}
	public String getObervacoes() {
		return obervacoes;
	}
	public void setObervacoes(String obervacoes) {
		this.obervacoes = obervacoes;
	}
	public boolean isChamadaMedica() {
		return chamadaMedica;
	}
	public void setChamadaMedica(boolean chamadaMedica) {
		this.chamadaMedica = chamadaMedica;
	}
	public Calendar getInicio() {
		return inicio;
	}
	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}
	public Calendar getFim() {
		return fim;
	}
	public void setFim(Calendar fim) {
		this.fim = fim;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Checks getChecks() {
		return checks;
	}
	public void setChecks(Checks checks) {
		this.checks = checks;
	}
	
	
}
