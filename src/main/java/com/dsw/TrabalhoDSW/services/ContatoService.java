package com.dsw.TrabalhoDSW.services;

/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dsw.TrabalhoDSW.entities.Contato;
import com.dsw.TrabalhoDSW.exceptions.serviceException.DatabaseException;
import com.dsw.TrabalhoDSW.exceptions.serviceException.ResourceNotFoundException;
import com.dsw.TrabalhoDSW.repositories.ContatoDAO;


@Service
public class ContatoService {

	@Autowired
	private ContatoDAO cd;

	@Autowired
	UsuarioService us;
	
	public List<Contato> findAll(){
		return cd.findAll();
	}
	
	public Contato findById(int id) {
		Optional<Contato> o = cd.findById(id);
		return o.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public List<Contato> findByName(String nome){
		
		return cd.findByNomeIgnoreCase(nome);
	}
	
	public Contato inserir(Contato c) {
		System.out.println("USUARIO: " + us.findById(c.getIdUsuario()));
		c.setUsuario(us.findById(c.getIdUsuario()));
		return cd.save(c);
	}
	
	public void delete(int id) {
		try {
			cd.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Contato update(int id, Contato c) {
		try {
			Contato o = cd.getById(id);
			updateData(o,c);
			return cd.save(o);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} 
	}

	private void updateData(Contato o, Contato c) {
		o.setNome(c.getNome());
		o.setFone(c.getFone());
		o.setEmail(c.getEmail());
	}
}
