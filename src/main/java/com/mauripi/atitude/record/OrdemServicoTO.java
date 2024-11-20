package com.mauripi.atitude.record;

import java.util.Date;

import com.mauripi.atitude.model.OrdemServico;

public record OrdemServicoTO(
			Integer id,
			String equipamento,
			String marca,
			String modelo,
			String serie,
			String acessorio,
			String defeito,
			String observacao,
			ClienteTO cliente,
			Date dataAtual,
			boolean removido
		) {
	public OrdemServicoTO(OrdemServico ordem) {
		this(
				ordem.getId(), 
				ordem.getSerie(), 
				ordem.getObservacao(), 
				ordem.getModelo(), 
				ordem.getMarca(), 
				ordem.getEquipamento(), 
				ordem.getDefeito(), 
				ordem.getAcessorio(), 
				ordem.getCliente().toTO(), 
				ordem.getDataAtual(), 
				ordem.isRemovido());
	}
}
