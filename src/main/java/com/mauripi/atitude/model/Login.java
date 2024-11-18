package com.mauripi.atitude.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
//@NamedQueries({
//	@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p"),
//	@NamedQuery(name="Produto.findByNome", query="SELECT p FROM Produto p WHERE p.nome > :nome")
//})
@Data
public class Login{

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable=false,length=15)
	private String user;

	@Column(nullable=false,length=15)
	private String senha;

	@Column(nullable=false)
	private boolean ativo;

	private boolean removido;


}
