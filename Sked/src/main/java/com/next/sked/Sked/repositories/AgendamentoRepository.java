package com.next.sked.Sked.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.next.sked.Sked.model.entities.Agendamento;

public interface AgendamentoRepository extends PagingAndSortingRepository<Agendamento, Integer> {
    
}
