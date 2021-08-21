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

import com.dsw.TrabalhoDSW.entities.Contato;
import com.dsw.TrabalhoDSW.services.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService cs;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Contato> getContato(){
		return cs.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Contato findById(@PathVariable Integer id) {
		return cs.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public List<Contato> findByName(@PathVariable String nome){
		return cs.findByName(nome);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato insert(@RequestBody Contato c) {

		return cs.inserir(c);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete (@PathVariable Integer id) {
		cs.delete(id);
	}
	
	@PutMapping( "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Contato update(@PathVariable Integer id, @RequestBody Contato c) {
		return c = cs.update(id, c);
		
	}
	
	
}
