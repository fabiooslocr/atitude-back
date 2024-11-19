package com.mauripi.atitude.record;

import com.mauripi.atitude.model.ItemVenda;

public record ItemVendaTO(
			Integer id,
			ProdutoTO produto,
			double precoVenda,
			double subTotal,
			int qtdVenda
		) {

	public ItemVendaTO(ItemVenda item) {		
		this(
				item.getId(), 
				item.getProduto().toTO(),
				item.getPrecoVenda(),
				item.getSubTotal(),
				item.getQtdVenda()
			);
	}
}
