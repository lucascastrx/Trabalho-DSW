package com.dsw.TrabalhoDSW.services;
/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dsw.TrabalhoDSW.entities.Compromisso;
import com.dsw.TrabalhoDSW.exceptions.serviceException.DatabaseException;
import com.dsw.TrabalhoDSW.exceptions.serviceException.ResourceNotFoundException;
import com.dsw.TrabalhoDSW.repositories.CompromissoDAO;

@Service
public class CompromissoService {

	@Autowired
	private CompromissoDAO cd;
	
	public List<Compromisso> findAll(){
		return cd.findAll();
	}
	
	public Compromisso findById(int id) {
		Optional<Compromisso> o = cd.findById(id);
		return o.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public List<Compromisso> findByContatoId(int id){
		List<Compromisso> list = new ArrayList<>();
		List<Optional<Compromisso>> listO = cd.findByContatoId(id);
		listO.forEach(o ->{
			list.add(o.get());
		});
		return list;
	}
	
	public List<Compromisso> findByDateInterval(String d1, String d2){
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		Date o1 = null;
		Date o2 = null;
		try {
			o1 = DATE_FORMAT.parse(d1);
			o2 = DATE_FORMAT.parse(d2);
		} catch (ParseException e) {
			
		}
		return cd.findByDataBetween(o1, o2);
		
	}
	
	public Compromisso insert(Compromisso c) {
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
	
	public Compromisso update(int id, Compromisso c) {
		try {
			Compromisso o = cd.getById(id);
			updateData(o,c);
			return cd.save(o);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
		
	}

	private void updateData(Compromisso o, Compromisso c) {
		o.setDescricao(c.getDescricao());
		o.setLocal(c.getLocal());
		o.setData(c.getData());
	}
}
