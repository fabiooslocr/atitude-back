package com.mauripi.atitude.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "itemvenda")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda{

	@Id
    @GeneratedValue
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    private Produto produto;

    @Column(name="precoVenda", nullable=true)
    private double precoVenda;

    @Column(name = "subTotal", nullable=true)
    private double subTotal;

    @Column(name = "qtdVenda", nullable=true)
    private int qtdVenda;


}
