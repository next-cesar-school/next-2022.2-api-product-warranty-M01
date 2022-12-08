package com.next.sked.Sked.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.next.sked.Sked.model.entities.Cliente;
import com.next.sked.Sked.repositories.ClienteRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
		
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> listarClientes(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
	}
	
	
	@PostMapping
	public @ResponseBody Cliente cadastrarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
		
	}
	
	
	
}
