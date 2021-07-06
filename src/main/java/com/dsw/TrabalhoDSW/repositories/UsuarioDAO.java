package com.dsw.TrabalhoDSW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsw.TrabalhoDSW.entities.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

}
