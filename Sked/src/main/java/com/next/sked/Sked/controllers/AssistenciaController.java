package com.next.sked.Sked.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.next.sked.Sked.model.entities.Assistencia;
import com.next.sked.Sked.services.AssistenciaService;

@RestController
@RequestMapping("/assistencia")
public class AssistenciaController {

    final AssistenciaService assistenciaService;

    public AssistenciaController(AssistenciaService assistenciaService) {
        this.assistenciaService = assistenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Assistencia>> getAllAgendamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(assistenciaService.findAll());
    }
    
}
