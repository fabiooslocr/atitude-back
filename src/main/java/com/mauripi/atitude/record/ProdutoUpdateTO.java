package com.mauripi.atitude.record;

public record ProdutoUpdateTO(			
		Integer id,
		String nome,
		int tipoProduto,
		double precoCompra,
		double precoVenda,
		Integer qtd,
		boolean removido
	) {

}
