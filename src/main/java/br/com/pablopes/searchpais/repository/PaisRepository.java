package br.com.pablopes.searchpais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.pablopes.searchpais.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> , JpaSpecificationExecutor<Pais>{}