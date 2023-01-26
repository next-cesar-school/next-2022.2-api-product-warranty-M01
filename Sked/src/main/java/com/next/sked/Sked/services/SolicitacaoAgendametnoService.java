package com.next.sked.Sked.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.next.sked.Sked.model.entities.Agendamento;
import com.next.sked.Sked.model.entities.Assistencia;
import com.next.sked.Sked.repositories.AgendamentoRepository;
import com.next.sked.Sked.repositories.AssistenciaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoAgendametnoService {
	
	private AgendamentoRepository agendamentoRepository;
	private AssistenciaRepository assistenciaRepository;
	
	@Transactional
	public Agendamento solicitar(Agendamento agendamento) {
		Assistencia assistencia = (Assistencia) assistenciaRepository.findAllById(agendamento.getAssistencia().getId());
		agendamento.setAssistencia(assistencia);
		return agendamentoRepository.save(agendamento);
	}

}
