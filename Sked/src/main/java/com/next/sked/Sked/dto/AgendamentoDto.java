package com.next.sked.Sked.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.next.sked.Sked.model.entities.Agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDto{

    private int id;
	private String nomeDoCliente;
	private String dataHora;
	private String aparelho;
	
	public AgendamentoDto(Agendamento agendamento) {
		super();
		this.id = agendamento.getId();
		this.nomeDoCliente = agendamento.getNomeDoCliente();
		this.dataHora = agendamento.getDataHora();
		this.aparelho = agendamento.getAparelho();
		
	}
	
	public static List<AgendamentoDto> convert(List<Agendamento> agendamento){
		return agendamento.stream().map(AgendamentoDto::new).collect(Collectors.toList());
	}
    
}
