package com.next.sked.Sked.repositories;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.next.sked.Sked.model.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends PagingAndSortingRepository<Agendamento, Integer> {
	
	public List<Agendamento> findByDataContainingIgnoreCase(String data);
	public List<Agendamento> findByHoraContainingIgnoreCase(String hora);
	public List<Agendamento> findByNomeDoClienteContainingIgnoreCase(String nome);
}