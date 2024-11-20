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

import com.mauripi.atitude.record.ClienteNewTO;
import com.mauripi.atitude.record.ClienteTO;
import com.mauripi.atitude.record.ClienteUpdateTO;
import com.mauripi.atitude.repository.ClienteRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;


	@GetMapping
	public ResponseEntity<Page<ClienteTO>> findAll(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
		var page = repository.findAll(pageable).map(ClienteTO::new);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteTO> findById(@PathVariable Integer id) {
		var cliente = repository.getReferenceById(id);
		return ResponseEntity.ok(new ClienteTO(cliente));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteTO> create(@RequestBody @Valid ClienteNewTO dados, UriComponentsBuilder uriBuilder) {
		var cliente = repository.save(dados.toCliente());
		var uri = uriBuilder.path("clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteTO(cliente));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<ClienteTO> update(@RequestBody @Valid ClienteUpdateTO dados) {
		var cliente = repository.getReferenceById(dados.id());
		cliente.atualizarDados(dados);
		return ResponseEntity.ok(new ClienteTO(cliente));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		var cliente = repository.getReferenceById(id);
		repository.delete(cliente);
		return ResponseEntity.noContent().build();
	}


}
