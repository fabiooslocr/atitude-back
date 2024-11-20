package com.mauripi.atitude.record;

import com.mauripi.atitude.model.Endereco;

public record EnderecoTO(
			Integer id,
			String rua,
			String bairro,
			String cep,
			String cidade,
			String uf
		) {

	public EnderecoTO(Endereco endereco) {
		this(endereco.getId(),
				endereco.getRua(),
				endereco.getBairro(),
				endereco.getCep(),
				endereco.getCidade(),
				endereco.getUf());
	}

	public Endereco toEndereco() {
		return Endereco.builder()
				.id(id)
				.rua(rua)
				.bairro(bairro)
				.cep(cep)
				.cidade(cidade)
				.uf(uf)
				.build();
	}

}
