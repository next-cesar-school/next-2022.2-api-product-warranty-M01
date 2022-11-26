package com.next.sked.Sked.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.sked.Sked.model.entities.Agendamento;
import com.next.sked.Sked.repositories.AgendamentoRepository;
import com.next.sked.Sked.repositories.AssistenciaRepository;


@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @PostMapping("/cadastrar/{idAssistencia}")
    public ResponseEntity<?> cadastrarAgendamento(@RequestBody Agendamento agendamento, @PathVariable Integer idAssistencia){
        var assistenciaLista = assistenciaRepository.findById(idAssistencia).get();
        var agendamentoLista = agendamentoRepository.save(agendamento);
        agendamentoLista.getAssistencias().add(assistenciaLista);
        var resultado = agendamentoRepository.save(agendamentoLista);
        return ResponseEntity.ok(resultado);
    }

    
}
