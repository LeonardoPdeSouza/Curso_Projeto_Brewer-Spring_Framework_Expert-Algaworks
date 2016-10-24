package com.algaworks.brewer.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Cliente {

	private String sku;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
}