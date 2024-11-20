package com.mauripi.atitude.record;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mauripi.atitude.model.Venda;

public record VendaTO(
			Integer id,
			List<ItemVendaTO> itens,
			ClienteTO cliente,
			double valorTotal,
			int tipo,
			Date dataAtual,
			Integer ordemServico
		) {
	
	public VendaTO(Venda venda) {		
		this(
				venda.getId(), 
				venda.getListaItem().stream().map(ItemVendaTO::new).collect(Collectors.toList()), 
				venda.getCliente().toTO(), 
				venda.getValorTotal(), 
				venda.getTipo(), 
				venda.getDataAtual(),
				venda.getOrdemServico()
			);
	}
}
