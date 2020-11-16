package br.com.pablopes.searchpais.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pais")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_PAIS", sequenceName = "SEQ_PAIS", initialValue = 1, allocationSize = 1)

public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAIS")
	@EqualsAndHashCode.Include
	private int id;
	private String nome;
	private String sigla;
	private String gentilico;
}
