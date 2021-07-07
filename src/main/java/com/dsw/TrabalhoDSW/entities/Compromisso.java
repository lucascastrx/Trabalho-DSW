package com.dsw.TrabalhoDSW.entities;
/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
public class Compromisso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String descricao;
	private String local;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Transient
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	
	@ManyToOne
	@JoinColumn( name = "contato_id")
	private Contato contato;
	
	@ManyToOne
	@JoinColumn( name = "usuario_id")
	private Usuario usuario;


	public Compromisso() {
	}


	public Compromisso(String descricao, String local, String data, Contato contato, Usuario usuario) throws ParseException {
		this.descricao = descricao;
		this.local = local;
		this.data = DATE_FORMAT.parse(data);
		this.contato = contato;
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Contato getContato() {
		return contato;
	}


	public void setContato(Contato contato) {
		this.contato = contato;
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
		Compromisso other = (Compromisso) obj;
		return id == other.id;
	}
	
	
	

}
