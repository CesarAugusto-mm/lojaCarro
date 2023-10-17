package com.loja.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity //comente aqui
@Table(name = "tb_loja") //comente aqui
public class Loja {
	
	@Id //comente aqui
	@GeneratedValue(strategy = GenerationType.IDENTITY) //comente aqui
	private Integer id;
	
	@NotBlank(message = "O valor não pode ser branco ou nulo") //comente aqui
	private String descricao;
	
	@NotBlank(message = "O valor não pode ser branco ou nulo") //comente aqui
	@NotNull
	private String endereco;
	
	@Min(value = 1, message = "O numero não pode ser menor que 1")
	private int numero;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "loja")
	@JsonIgnoreProperties("loja")
	private	List<Carro> carro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Carro> getCarro() {
		return carro;
	}

	public void setCarro(List<Carro> carro) {
		this.carro = carro;
	}
	
	
	
	
}
