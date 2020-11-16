package br.com.pablopes.searchpais.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioAutenticado {
	private String login;
	private String nome;
	private String token;
	private boolean administrador;
	private boolean autenticado;
}
