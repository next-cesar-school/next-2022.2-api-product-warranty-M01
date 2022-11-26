package com.next.sked.Sked.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.next.sked.Sked.model.entities.Assistencia;

@Repository
public interface AssistenciaRepository extends JpaRepository<Assistencia, Integer> {

	Object findByNomeContainingIgnoreCase(String nome);

}
