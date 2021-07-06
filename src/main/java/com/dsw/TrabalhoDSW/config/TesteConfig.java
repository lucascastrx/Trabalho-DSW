package com.dsw.TrabalhoDSW.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dsw.TrabalhoDSW.entities.Compromisso;
import com.dsw.TrabalhoDSW.entities.Contato;
import com.dsw.TrabalhoDSW.entities.Usuario;
import com.dsw.TrabalhoDSW.repositories.CompromissoDAO;
import com.dsw.TrabalhoDSW.repositories.ContatoDAO;
import com.dsw.TrabalhoDSW.repositories.UsuarioDAO;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private ContatoDAO cd;
	
	@Autowired
	private CompromissoDAO compd;
	
	@Autowired
	private UsuarioDAO ud;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Contato c1 = new Contato("Lucas","123","lucas@gmail.com", null);
        Contato c2 = new Contato("Ju","123","juliana@gmail.com", null);

        Usuario u1 = new Usuario("Lucas","lvcvx","senhateste");

        Compromisso cp1 = new Compromisso("Festa às 19h","Casa da Ju",
                "10-06-2021",c2,u1);

        //"2019-06-20T19:53:07Z"
        cd.save(c1);
        cd.save(c2);
        ud.save(u1);
        compd.save(cp1);
		
	}

}
