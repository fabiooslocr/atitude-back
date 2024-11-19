package com.mauripi.atitude.record;

import com.mauripi.atitude.model.Produto;

public record ProdutoNewTO(
			String nome,
			int tipoProduto,
			double precoCompra,
			double precoVenda,
			Integer qtd		
		) {

	public Produto toProduto() {
		return Produto.builder()
				.nome(nome)
				.tipoProduto(tipoProduto)
				.precoCompra(precoCompra)
				.precoVenda(precoVenda)
				.qtd(qtd)
				.build();
	}

}
