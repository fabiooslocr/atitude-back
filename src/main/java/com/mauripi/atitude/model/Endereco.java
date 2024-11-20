package com.mauripi.atitude.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco{

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length=250,nullable=false)
	private String rua;

	@Column(length=150,nullable=false)
	private String bairro;

	@Column(length=9,nullable=false)
	private String cep;

	@Column(length=150,nullable=false)
	private String cidade;

	@Column(length=2,nullable=false)
	private String uf;

}
