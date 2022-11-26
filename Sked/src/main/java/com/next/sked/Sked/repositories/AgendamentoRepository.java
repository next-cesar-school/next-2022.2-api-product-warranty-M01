package com.next.sked.Sked.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.next.sked.Sked.model.entities.Agendamento;

@Repository
public interface AgendamentoRepository extends PagingAndSortingRepository<Agendamento, Integer> {
    
}
