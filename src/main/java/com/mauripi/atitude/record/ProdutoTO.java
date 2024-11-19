package com.mauripi.atitude.record;

import com.mauripi.atitude.model.Produto;

public record ProdutoTO(
			Integer id,
			String nome,
			int tipoProduto,
			double precoCompra,
			double precoVenda,
			Integer qtd,
			boolean removido
		) {
	public ProdutoTO(Produto produto) {		
		this(produto.getId(), produto.getNome(), 
				produto.getTipoProduto(), 
				produto.getPrecoCompra(), 
				produto.getPrecoVenda(), produto.getQtd(),
				produto.isRemovido());
	}
}
