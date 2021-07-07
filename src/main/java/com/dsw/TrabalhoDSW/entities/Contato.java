package com.dsw.TrabalhoDSW.entities;
/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	private String fone;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;


	public Contato() {
	}


	public Contato(String nome, String fone, String email, Usuario usuario) {
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getFone() {
		return fone;
	}


	public void setFone(String fone) {
		this.fone = fone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return id == other.id;
	}
	
	
	
	

}
