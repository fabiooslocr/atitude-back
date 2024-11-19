package com.mauripi.atitude.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mauripi.atitude.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

	@Query("SELECT v FROM Venda v")
    Page<Venda> findAllVendas(Pageable pageable);
}
