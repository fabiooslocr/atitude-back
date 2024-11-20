package com.mauripi.atitude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauripi.atitude.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{


}
