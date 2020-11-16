package br.com.pablopes.searchpais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.pablopes.searchpais.model.Token;

public interface TokenRepository  extends JpaRepository<Token, Integer>, JpaSpecificationExecutor<Token>{}
