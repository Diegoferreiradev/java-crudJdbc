package br.com.projeto.jdbc.teste;

import java.util.Calendar;

import br.com.projeto.jdbc.dao.ContatoDao;
import br.com.projeto.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setNome("Gilson");
		contato.setEmail("gilson@gmail.com");
		contato.setEndereco("R.aonde o vento faz a curva");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contatoDao = new ContatoDao();
		
		contatoDao.adiciona(contato);
		
		System.out.println("Contato Salvo!");
	}
}
