package com.mauripi.atitude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mauripi.atitude.record.OrdemServicoNewTO;
import com.mauripi.atitude.record.OrdemServicoTO;
import com.mauripi.atitude.record.OrdemServicoUpdateTO;
import com.mauripi.atitude.repository.OrdemServicoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ordens")
@AllArgsConstructor
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoRepository repository;

	@GetMapping
	public ResponseEntity<Page<OrdemServicoTO>> findAll(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
		var page = repository.findAll(pageable).map(OrdemServicoTO::new);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoTO> findById(@PathVariable Integer id) {
		var ordem = repository.getReferenceById(id);
		return ResponseEntity.ok(new OrdemServicoTO(ordem));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<OrdemServicoTO> create(@RequestBody @Valid OrdemServicoNewTO dados, UriComponentsBuilder uriBuilder) {
		
		var ordem = dados.toOrdemServico();
		ordem.setRemovido(false);
		ordem = repository.save(ordem);
		var uri = uriBuilder.path("ordems/{id}").buildAndExpand(ordem.getId()).toUri();
		return ResponseEntity.created(uri).body(new OrdemServicoTO(ordem));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<OrdemServicoTO> update(@RequestBody @Valid OrdemServicoUpdateTO dados) {
		var ordem = repository.getReferenceById(dados.id());
		ordem.atualizarDados(dados);
		return ResponseEntity.ok(new OrdemServicoTO(ordem));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		var ordem = repository.getReferenceById(id);
		ordem.delete(ordem);
		return ResponseEntity.noContent().build();
	}


}
