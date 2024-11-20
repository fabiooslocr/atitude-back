package com.mauripi.atitude.record;

import com.mauripi.atitude.model.Cliente;

public record ClienteTO(
			Integer id,
			String nome,
			String cfpCnpj,
			EnderecoTO enderecoTO,
			String endNum,
			String telRes,
			String telCel,
			String email
		) {
	
	public ClienteTO(Cliente cliente) {		
		this(cliente.getId(), cliente.getNome(), 
				cliente.getCfpCnpj(), 
				cliente.getEnderecoTO(), 
				cliente.getEndNum(), cliente.getTelRes(),
				cliente.getTelCel(), cliente.getEmail());
	}

	public Cliente toCliente() {
		return Cliente.builder()
				.id(id)
				.nome(nome)
				.cfpCnpj(cfpCnpj)
				.endereco(enderecoTO.toEndereco())
				.endNum(endNum)
				.telRes(telRes)
				.telCel(telCel)
				.email(email)
				.build();
	}
}
