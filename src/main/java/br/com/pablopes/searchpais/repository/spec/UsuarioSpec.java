package br.com.pablopes.searchpais.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import br.com.pablopes.searchpais.model.Usuario;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioSpec{
	private static final long serialVersionUID = 1L;

	public static Specification<Usuario> porLogin(String login){
		return (root, query, builder) -> builder.equal(builder.upper(root.get("login")), login.toUpperCase());
	}
	public static Specification<Usuario> porSenha(String senha){
		return (root, query, builder) -> builder.like(builder.upper(root.get("senha")), senha.toUpperCase());
	}
}
