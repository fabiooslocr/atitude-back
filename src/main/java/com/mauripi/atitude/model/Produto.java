package com.mauripi.atitude.model;

import com.mauripi.atitude.record.ProdutoTO;
import com.mauripi.atitude.record.ProdutoUpdateTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;;


//@NamedQueries({
//	@NamedQuery(name="findAllProduto", query=" FROM Produto p WHERE p.removido= :removido ORDER BY p.id"),
//	@NamedQuery(name="findNome", query=" FROM Produto p WHERE p.nome LIKE :nomeProd"),
//	@NamedQuery(name="findCodigo", query=" FROM Produto p WHERE p.id LIKE :codProd"),
//})
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto{

	@Id
	@GeneratedValue
	private Integer id;

	@Basic(fetch=FetchType.EAGER)
	@Column(nullable=false,length=255)
	private String nome;

	@Column(nullable=false,length=2)
	private int tipoProduto;
	private double precoCompra;
	private double precoVenda;

	@Column(nullable=false,length=6)
	private Integer qtd;

	private boolean removido;

	public void atualizarDados(@Valid ProdutoUpdateTO dados) {
		this.nome = dados.nome();
		this.tipoProduto = dados.tipoProduto();
		this.precoCompra = dados.precoCompra();
		this.precoVenda = dados.precoVenda();
		this.qtd = dados.qtd();
		this.removido = dados.removido();
	}

	public void delete(Produto produto) {
		this.removido = produto.isRemovido();
	}

	public ProdutoTO toTO() {
		return new ProdutoTO(id, nome, tipoProduto, precoCompra, precoVenda, qtd, removido);
	}

}
