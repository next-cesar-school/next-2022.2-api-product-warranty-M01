package com.next.sked.Sked.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgendamentoController {
    
    @PostMapping("/agendamento")
    public @Responsebody Agendamento cadastrarAgendamento(@Requestbody Agendamento agendamento){
        agendamentoRepository.save(agendamento);
        return agendementos;
    }


}
