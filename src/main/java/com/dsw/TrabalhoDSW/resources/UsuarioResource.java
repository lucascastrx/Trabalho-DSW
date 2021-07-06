package com.dsw.TrabalhoDSW.resources;

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

import com.dsw.TrabalhoDSW.entities.Usuario;
import com.dsw.TrabalhoDSW.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService us;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	public List<Usuario> getUsuario(){
		return us.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Usuario findById(@PathVariable Integer id) {
		return us.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario insert(@RequestBody Usuario u) {
		return us.insert(u);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		us.delete(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario update(@PathVariable Integer id, @RequestBody Usuario u) {
		return u = us.update(id, u);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
