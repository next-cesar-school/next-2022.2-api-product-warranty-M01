package com.next.sked.Sked.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

	@Id
	private int id;
	private String nomeDoCliente;
	private String dataHora;
	private String aparelho;
	
}
