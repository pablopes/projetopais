package br.com.pablopes.searchpais.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import br.com.pablopes.searchpais.model.Token;

public class TokenSpec {
private static final long serialVersionUID = 1L;
		
	public static Specification<Token> porToken(String token){
		return (root, query, builder) -> builder.equal(root.get("token"), token);
	}
	
}
