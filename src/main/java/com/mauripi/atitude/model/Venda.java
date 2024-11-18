package com.mauripi.atitude.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Venda{

	@Id
    @GeneratedValue
    private Integer id;

	@OneToMany
	@JoinTable(name = "venda_itemvenda", joinColumns = @JoinColumn(name = "venda_id"), inverseJoinColumns = @JoinColumn(name = "listaItem_id"))
    private List<ItemVenda> listaItem;

	@OneToOne
    private Cliente cliente;

    @Column(nullable=false)
    private double valorTotal;

    @Column(nullable=false)
    private int tipo;//1-Orcamento 2-Venda

    @Temporal(TemporalType.DATE)
    private Date dataAtual;

    private Integer ordemServico;

}