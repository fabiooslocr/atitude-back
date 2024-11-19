package com.mauripi.atitude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauripi.atitude.record.VendaTO;
import com.mauripi.atitude.repository.VendaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vendas")
@AllArgsConstructor
public class VendaController {

	@Autowired
	private VendaRepository repository;
	
	@GetMapping
	public ResponseEntity<Page<VendaTO>> findAll(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
		var page = repository.findAllVendas(pageable).map(venda -> {
								var tot = venda.getListaItem().size();
								System.out.println(tot);
								return new VendaTO(venda);
							});
		return ResponseEntity.ok(page);
	}
}
