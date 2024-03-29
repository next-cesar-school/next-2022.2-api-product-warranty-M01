package com.next.sked.Sked.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.next.sked.Sked.model.entities.Assistencia;
import com.next.sked.Sked.repositories.AssistenciaRepository;
import com.next.sked.Sked.services.AssistenciaService;

@RestController
@RequestMapping("/assistencia")
public class AssistenciaController {

    final AssistenciaService assistenciaService;
    @Autowired
    private AssistenciaRepository assistenciaRepository;

    public AssistenciaController(AssistenciaService assistenciaService) {
        this.assistenciaService = assistenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Assistencia>> getAllAssistencias(){
        return ResponseEntity.status(HttpStatus.OK).body(assistenciaService.findAll());
    }
    
    @PostMapping("/cadastro")
    public @ResponseBody Assistencia cadastrarAssistencia(@RequestBody @Valid Assistencia assistencia) {
    	assistenciaRepository.save(assistencia);
    	return assistencia;
    }

    @DeleteMapping("/{assistenciaId}")
  public ResponseEntity<Void> desmarcar(@PathVariable Integer assistenciaId){
	  if (!assistenciaRepository.existsById(assistenciaId)) {
		  return ResponseEntity.notFound().build();	
	  }
	  
	  assistenciaRepository.deleteById(assistenciaId);
	  
	  return ResponseEntity.noContent().build();
	  
  }
    
}
