package com.mauripi.atitude.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class OrdemServico{

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length=50)
	private String equipamento;

	@Column(length=50)
	private String marca;

	@Column(length=50)
	private String modelo;

	@Column(length=255)
	private String serie;

	@Column(length=255)
	private String acessorio;

	@Column(length=255)
	private String defeito;

	@Column(length=255)
	private String observacao;

	@OneToOne
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private Date dataAtual;

	private boolean removido;

}
