package com.next.sked.Sked.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.sked.Sked.model.entities.Agendamento;
import com.next.sked.Sked.model.entities.Assistencia;
import com.next.sked.Sked.repositories.AgendamentoRepository;
import com.next.sked.Sked.repositories.AssistenciaRepository;


@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private AssistenciaRepository assistenciaRepository;

	@PostMapping
	public Agendamento cadastrar(@RequestBody Agendamento obj) {
		return agendamentoRepository.save(obj);
	}
	
	@PostMapping("/{nome}/{idAgendamento}")
	public ResponseEntity<?> adicionarPrato(@PathVariable  String nome,@PathVariable Integer idAgendamento) {
		var assistencias = assistenciaRepository.findByNomeContainingIgnoreCase(nome);
		if(((String) assistencias).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		var agendamento = agendamentoRepository.findById(idAgendamento).get();
		agendamento.getAssistencias().addAll((Collection<? extends Assistencia>) assistencias);
		var result = agendamentoRepository.save(agendamento);
		return ResponseEntity.ok(result);
	}
	
	
    
    
}
