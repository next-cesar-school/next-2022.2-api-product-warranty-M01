package com.next.sked.Sked.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.next.sked.Sked.model.entities.Agendamento;
import com.next.sked.Sked.repositories.AgendamentoRepository;
import com.next.sked.Sked.services.SolicitacaoAgendametnoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    
  private SolicitacaoAgendametnoService solicitacaoAgendametnoService;
  private AgendamentoRepository agendamentoRepository;
  	
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Agendamento solicitar(@RequestBody Agendamento agendamento) {
	  return solicitacaoAgendametnoService.solicitar(agendamento);
  }
  	
  @DeleteMapping("/{agendamentoId}")
  public ResponseEntity<Void> desmarcar(@PathVariable Integer agendamentoId){
	  if (!agendamentoRepository.existsById(agendamentoId)) {
		  return ResponseEntity.notFound().build();	
	  }
	  
	  agendamentoRepository.deleteById(agendamentoId);
	  
	  return ResponseEntity.noContent().build();
	  
  }
  
}
