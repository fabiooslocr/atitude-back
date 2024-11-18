package com.mauripi.atitude.record;

import com.mauripi.atitude.model.Cliente;

public record ClienteNewTO(
		String nome,
		String cfpCnpj,
		//EnderecoTO endereco,
		String endNum,
		String telRes,
		String telCel,
		String email
	) {

	public Cliente toCliente() {
		return Cliente.builder()
				.nome(nome)
				.cfpCnpj(cfpCnpj)
				.endNum(endNum)
				.telRes(telRes)
				.telCel(telCel)
				.email(email)
				.build();
	} 

}
