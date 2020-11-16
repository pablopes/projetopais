package br.com.pablopes.searchpais.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import br.com.pablopes.searchpais.model.Pais;

public class PaisSpec {
	private static final long serialVersionUID = 1L;
	
	public static Specification<Pais> porNome(String nome){
		return (root, query, builder) -> builder.like(root.get("nome"), "%" + nome + "%");
	}
}
