package com.next.sked.Sked.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.next.sked.Sked.model.entities.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {
	
	public List<Cliente> findByNomeContainingIgnoreCase(String nome);
	public Cliente findById(int id);

}
