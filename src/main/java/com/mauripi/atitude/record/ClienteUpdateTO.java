package com.mauripi.atitude.record;

public record ClienteUpdateTO(		
		Integer id,
		String nome,
		String cfpCnpj,
		//EnderecoTO endereco,
		String endNum,
		String telRes,
		String telCel,
		String email
	) {


}
