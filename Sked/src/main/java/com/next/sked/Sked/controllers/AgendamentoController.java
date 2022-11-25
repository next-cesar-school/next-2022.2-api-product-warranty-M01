package com.next.sked.Sked.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.next.sked.Sked.dto.AgendamentoDto;
import com.next.sked.Sked.model.entities.Agendamento;
import com.next.sked.Sked.repositories.AgendamentoRepository;

@RestController
public class AgendamentoController {

    @Autowired
	private AgendamentoRepository agendamentoRepository;
    
    @PostMapping("/agendamento")
    public @ResponseBody Agendamento cadastrarAgendamento(@Valid Agendamento agendamento){
        agendamentoRepository.save(agendamento);
        return agendamento;
    }

    @GetMapping
	public Iterable<AgendamentoDto> getAgendamento(){
		Iterable<Agendamento> agendamento = agendamentoRepository.findAll();
		return AgendamentoDto.convert((List<Agendamento>) agendamento);
	}


}
