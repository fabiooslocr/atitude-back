package com.mauripi.atitude.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;;

@Entity
//@NamedQueries({
//	@NamedQuery(name="findAllProduto", query=" FROM Produto p WHERE p.removido= :removido ORDER BY p.id"),
//	@NamedQuery(name="findNome", query=" FROM Produto p WHERE p.nome LIKE :nomeProd"),
//	@NamedQuery(name="findCodigo", query=" FROM Produto p WHERE p.id LIKE :codProd"),
//})
@Data
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

}
