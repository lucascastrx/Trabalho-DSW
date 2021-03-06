package com.dsw.TrabalhoDSW.repositories;
/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsw.TrabalhoDSW.entities.Contato;

@Repository
public interface ContatoDAO extends JpaRepository<Contato, Integer> {
	 List<Contato> findByNomeIgnoreCase(String nome);
}
