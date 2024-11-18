package com.mauripi.atitude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauripi.atitude.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

//	@NamedQueries({
//		@NamedQuery(name="findAllEndereco", query=" FROM Endereco e ORDER BY e.id"),
//		@NamedQuery(name="findRua", query=" FROM Endereco e WHERE e.rua LIKE :rua"),
//		@NamedQuery(name="findCep", query=" FROM Endereco e WHERE e.cep LIKE :cep"),
//	})
}
