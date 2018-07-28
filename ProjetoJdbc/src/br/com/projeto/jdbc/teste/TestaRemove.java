package br.com.projeto.jdbc.teste;

import br.com.projeto.jdbc.dao.ContatoDao;
import br.com.projeto.jdbc.modelo.Contato;

public class TestaRemove {
	
	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setId((long) 5);
		
		ContatoDao dao = new ContatoDao();
		
		dao.remove(contato);
		
		System.out.println("Contato Removido! ");
	}

}
