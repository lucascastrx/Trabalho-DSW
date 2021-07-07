package com.dsw.TrabalhoDSW.resources;
/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dsw.TrabalhoDSW.entities.Compromisso;
import com.dsw.TrabalhoDSW.services.CompromissoService;

@RestController
@RequestMapping("/compromissos")
public class CompromissoResource {

	@Autowired
	private CompromissoService cs;
	
	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	public List<Compromisso> getCompromisso(){
		return cs.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Compromisso findById(@PathVariable Integer id) {
		return cs.findById(id);
	}
	
	@GetMapping("/contato/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Compromisso> findByContatoId(@PathVariable Integer id){
		return cs.findByContatoId(id);
	}
	
	@GetMapping("/d1/{d1}/d2/{d2}")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Compromisso> findByDateInterval(@PathVariable String d1, @PathVariable String d2){
		return cs.findByDateInterval(d1, d2);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Compromisso insert(@RequestBody Compromisso c) {
		return cs.insert(c);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		cs.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Compromisso update(@PathVariable Integer id, @RequestBody Compromisso c) {
		return cs.update(id, c);
	}
}
