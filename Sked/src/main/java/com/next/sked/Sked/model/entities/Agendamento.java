package com.next.sked.Sked.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty(message = "Informe o nome do cliente")
	private String nomeDoCliente;
	@NotEmpty(message = "Informe a data para o agendamento")
	private String data;
	@NotEmpty(message = "Informe a hora para o agendamento")
	private String hora;
	@NotEmpty(message = "Informe o aparelho que precisa de assistencia")
	private String aparelho;

	@ManyToOne
	private Assistencia assistencias;
	
}
