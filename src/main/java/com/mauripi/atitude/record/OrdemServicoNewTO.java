package com.mauripi.atitude.record;

import java.util.Date;

import com.mauripi.atitude.model.OrdemServico;

public record OrdemServicoNewTO(
			String equipamento,
			String marca,
			String modelo,
			String serie,
			String acessorio,
			String defeito,
			String observacao,
			ClienteTO clienteTO,
			Date dataAtual,
			boolean removido
		) {

	public OrdemServico toOrdemServico() {
		return OrdemServico.builder()
				.equipamento(equipamento)
				.marca(marca)
				.modelo(modelo)
				.serie(serie)
				.acessorio(acessorio)
				.defeito(defeito)
				.observacao(observacao)
				.cliente(clienteTO.toCliente())
				.build();
	}

}
