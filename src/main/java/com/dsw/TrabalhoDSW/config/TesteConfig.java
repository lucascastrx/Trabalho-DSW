package com.dsw.TrabalhoDSW.config;

/**
 * @author Lucas Teixeira
 * @author Eduardo Buzzi
 */
import com.dsw.TrabalhoDSW.services.CompromissoService;
import com.dsw.TrabalhoDSW.services.ContatoService;
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
	private ContatoService cd;

	@Autowired
	private CompromissoService cs;
	
	@Autowired
	private CompromissoDAO compd;
	
	@Autowired
	private UsuarioDAO ud;
	
	
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario("Lucas","lvcvx","senhateste");

		Contato c1 = new Contato("Lucas","123","lucas@gmail.com", 1);
        Contato c2 = new Contato("Ju","123","juliana@gmail.com", 1);



        Compromisso cp1 = new Compromisso("Festa às 19h","Casa da Ju",
                "10-06-2021",2,1);
        Compromisso cp2 = new Compromisso("Festa às 21h","Casa da Maria",
                "10-06-2021",3,1);

        //"2019-06-20T19:53:07Z"
		ud.save(u1);
        cd.inserir(c1);
        cd.inserir(c2);


        cs.insert(cp1);
        cs.insert(cp2);
		
	}

}
