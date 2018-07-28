package br.com.projeto.jdbc.teste;

import java.util.Calendar;

import br.com.projeto.jdbc.dao.ContatoDao;
import br.com.projeto.jdbc.modelo.Contato;

public class TestaAtualiza {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setId((long) 3);
		contato.setNome("Batman");
		contato.setEmail("batman@gotham.com");
		contato.setEndereco("Gotham City");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.altera(contato);
		
		System.out.println("Contato Atualizado! ");
	}
}
