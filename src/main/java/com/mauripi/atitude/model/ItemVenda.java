package com.mauripi.atitude.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ItemVenda{

	@Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Produto produto;

    @Column(nullable=true)
    private double precoVenda;

    @Column(nullable=true)
    private double subTotal;

    @Column(nullable=true)
    private int qtdVenda;


}
