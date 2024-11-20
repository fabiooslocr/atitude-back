package com.mauripi.atitude.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venda{

	@Id
    @GeneratedValue
    private Integer id;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "venda_itemvenda", 
	  joinColumns = @JoinColumn(name = "venda_id"), 
	  inverseJoinColumns = @JoinColumn(name = "listaItem_id"))
	@Fetch(FetchMode.JOIN)
	private List<ItemVenda> listaItem;

	@OneToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @Column(name = "valorTotal", nullable=false)
    private double valorTotal;

    @Column(nullable=false)
    private int tipo;//1-Orcamento 2-Venda

    @Column(name = "dataAtual" )
    @Temporal(TemporalType.DATE)
    private Date dataAtual;

    @Column(name = "ordemServico" )
    private Integer ordemServico;

}