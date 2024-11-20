package com.mauripi.atitude.model;

import java.util.Date;

import com.mauripi.atitude.record.OrdemServicoUpdateTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordem_servico")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "data_atual")
    private Date dataAtual;

	private boolean removido;

	public void atualizarDados(@Valid OrdemServicoUpdateTO dados) {
		equipamento = dados.equipamento();
		marca = dados.marca();
		modelo = dados.modelo();
		serie = dados.serie();
		acessorio = dados.acessorio();
		defeito = dados.defeito();
		observacao = dados.observacao();
		cliente = dados.clienteTO().toCliente();
		dataAtual = dados.dataAtual();
		removido = dados.removido();
		
	}

	public void delete(OrdemServico ordem) {
		removido = Boolean.TRUE;
	}

}
