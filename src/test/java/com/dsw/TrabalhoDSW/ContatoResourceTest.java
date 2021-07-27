package com.dsw.TrabalhoDSW;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.dsw.TrabalhoDSW.entities.Contato;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ContatoResourceTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void contatoTestGetContato() throws Exception {
		mockMvc.perform(get("/contatos")).andExpect(status().isOk());
	}
	
	@Test
	public void contatoTestInsert() throws Exception {
		Contato c1 = new Contato("Jessik","123","jessik@gmail.com", null);
		
		mockMvc.perform(post("/contatos")
			   .contentType("application/json")
			   .content(mapper.writeValueAsString(c1)))
			   .andExpect(status().isCreated());
		
	}
}

