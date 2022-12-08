package com.next.sked.Sked.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.next.sked.Sked.model.entities.Agendamento;
import com.next.sked.Sked.model.entities.Assistencia;
import com.next.sked.Sked.model.entities.Cliente;
import com.next.sked.Sked.repositories.AgendamentoRepository;
import com.next.sked.Sked.repositories.AssistenciaRepository;
import com.next.sked.Sked.repositories.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoAgendametnoService {
	
	private AgendamentoRepository agendamentoRepository;
	private AssistenciaRepository assistenciaRepository;
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Agendamento solicitar(Agendamento agendamento) {
		Assistencia assistencia = (Assistencia) assistenciaRepository.findAllById(agendamento.getAssistencias().getId());
		Cliente cliente = (Cliente) clienteRepository.findById(agendamento.getCliente().getId());
		agendamento.setCliente(cliente);
		agendamento.setAssistencias(assistencia);
		return agendamentoRepository.save(agendamento);
	}

}
