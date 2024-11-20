package com.mauripi.atitude.record;

import java.util.Date;

public record OrdemServicoUpdateTO(
			Integer id,
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

}
