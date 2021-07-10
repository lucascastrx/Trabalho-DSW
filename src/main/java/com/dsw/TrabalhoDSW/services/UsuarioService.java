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

import com.dsw.TrabalhoDSW.entities.Usuario;
import com.dsw.TrabalhoDSW.exceptions.serviceException.DatabaseException;
import com.dsw.TrabalhoDSW.exceptions.serviceException.ResourceNotFoundException;
import com.dsw.TrabalhoDSW.repositories.UsuarioDAO;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO ud;
	
	public List<Usuario> findAll(){
		return ud.findAll();
	}
	
	public Usuario findById(int id) {
		Optional<Usuario> o = ud.findById(id);
		return o.orElseThrow(()-> new ResourceNotFoundException(id)); 
	}
	
	public Usuario insert(Usuario u) {
		return ud.save(u);
	}
	
	public void delete(int id) {
		try {
			ud.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario update(int id, Usuario u) {
		try {
			Usuario o = ud.getById(id);
			updateData(o,u);
			return ud.save(o);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario o, Usuario u) {
		o.setNome(u.getNome());
		o.setUsername(u.getUsername());
		o.setSenha(u.getSenha());
		
	}

	public Usuario getLogin(String user, String pw) {
		
		return ud.findByUsernameAndSenha(user, pw);
	}
}
