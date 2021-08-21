package com.dsw.TrabalhoDSW;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dsw.TrabalhoDSW.entities.Contato;
import com.dsw.TrabalhoDSW.repositories.ContatoDAO;
import com.dsw.TrabalhoDSW.services.ContatoService;

@ExtendWith(SpringExtension.class)
public class ContatoServiceTest {
	
	
	@TestConfiguration
	static class ContatoServiceTestConfiguration{
		@Bean
		public ContatoService contatoService() {
			return new ContatoService();
		}
	}
	
	@Autowired
	ContatoService contatoService;
	
	@MockBean
	ContatoDAO cd;
	
	@Test
	public void contatoTestServiceFindById() {
		int id = 1;
		Contato c1 = new Contato("Lucas","123","lucas@gmail.com", 1);
		c1.setId(1);
		Contato contatos = contatoService.findById(id);
		
		Assertions.assertEquals(contatos, c1 );
	}
	
	@BeforeEach
	public void setup() {
		Contato c1 = new Contato("Lucas","123","lucas@gmail.com", 1);
		c1.setId(1);
		
		Mockito.when(cd.findById(c1.getId())).thenReturn(java.util.Optional.of(c1));
		
	}

}
