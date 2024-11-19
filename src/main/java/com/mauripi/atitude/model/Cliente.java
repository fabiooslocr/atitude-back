package com.mauripi.atitude.model;

import com.mauripi.atitude.record.ClienteTO;
import com.mauripi.atitude.record.ClienteUpdateTO;
import com.mauripi.atitude.record.EnderecoTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente{

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable=false,length=55)
	private String nome;

	@Column(name = "cfp_cnpj", nullable=true,length=18,unique=true)
	private String cfpCnpj;

	@OneToOne
	private Endereco endereco;

	@Column(length=10)
	private String endNum;

	@Column(length=30)
	private String telRes;

	@Column(length=30)
	private String telCel;

	@Column(length=50)
	private String email;

	public void atualizarDados(@Valid ClienteUpdateTO dados) {
		this.nome = dados.nome();
		this.cfpCnpj = dados.cfpCnpj();
		this.endNum = dados.endNum();
		this.telRes = dados.telRes();
		this.telCel = dados.telCel();
		this.email = dados.email();
	}

	public EnderecoTO getEnderecoTO() {
		if(this.endereco != null)
			return new EnderecoTO(this.endereco);
		return null;
	}

	public ClienteTO toTO() {
		return new ClienteTO(id, nome, cfpCnpj, getEnderecoTO(), endNum, telRes, telCel, email);
	}

}
