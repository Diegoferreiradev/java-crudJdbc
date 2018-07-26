package br.com.projeto.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.jdbc.ConnectionFactory;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão Aberta!");
		
		connection.close();
	}

}
