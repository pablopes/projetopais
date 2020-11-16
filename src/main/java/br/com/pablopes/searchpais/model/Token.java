package br.com.pablopes.searchpais.model;

import java.time.ZonedDateTime;

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
@Table(name="token")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(name = "SEQ_TOKEN", sequenceName = "SEQ_TOKEN", initialValue = 1, allocationSize = 1)
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TOKEN")
	@EqualsAndHashCode.Include
	private int id;
	private String token;
	private String login;
	private ZonedDateTime expiracao;
	private boolean administrador;
}