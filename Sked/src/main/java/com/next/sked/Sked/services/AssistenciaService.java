package com.next.sked.Sked.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.next.sked.Sked.repositories.AssistenciaRepository;
import com.next.sked.Sked.model.entities.Assistencia;

@Service
public class AssistenciaService {

    final AssistenciaRepository assistenciaRepository;

    public AssistenciaService(AssistenciaRepository assistenciaRepository) {
        this.assistenciaRepository = assistenciaRepository;
    }

    //GetAll
    public List<Assistencia> findAll() {
        return assistenciaRepository.findAll();
    }
    
}
