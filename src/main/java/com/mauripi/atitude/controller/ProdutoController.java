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

import com.mauripi.atitude.record.ProdutoNewTO;
import com.mauripi.atitude.record.ProdutoTO;
import com.mauripi.atitude.record.ProdutoUpdateTO;
import com.mauripi.atitude.repository.ProdutoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;


	@GetMapping
	public ResponseEntity<Page<ProdutoTO>> findAll(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
		var page = repository.findAll(pageable).map(ProdutoTO::new);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoTO> findById(@PathVariable Integer id) {
		var produto = repository.getReferenceById(id);
		return ResponseEntity.ok(new ProdutoTO(produto));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoTO> create(@RequestBody @Valid ProdutoNewTO dados, UriComponentsBuilder uriBuilder) {
		
		var produto = dados.toProduto();
		produto.setRemovido(false);
		produto = repository.save(produto);
		var uri = uriBuilder.path("produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoTO(produto));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<ProdutoTO> update(@RequestBody @Valid ProdutoUpdateTO dados) {
		var produto = repository.getReferenceById(dados.id());
		produto.atualizarDados(dados);
		return ResponseEntity.ok(new ProdutoTO(produto));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Integer id) {
		var produto = repository.getReferenceById(id);
		produto.delete(produto);
		return ResponseEntity.noContent().build();
	}


}
