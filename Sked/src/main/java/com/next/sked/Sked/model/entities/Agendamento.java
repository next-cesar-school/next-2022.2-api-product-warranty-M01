package com.next.sked.Sked.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomeDoCliente;
	private String dataHora;
	private String aparelho;

	@ManyToOne
	private Assistencia assistencias;
	
}
