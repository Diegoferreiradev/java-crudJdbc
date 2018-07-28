package br.com.projeto.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;


import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) VALUES (?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
			
		}catch(SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Contato> getLista(){
		
		try {
			
			List<Contato> contatos = new ArrayList<Contato>();	
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Contato contato = new Contato();
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
				
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		}catch(SQLException e) {
			
			throw new RuntimeException();
		}
	}
	
	
	public void altera(Contato contato)  {
		
		String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			
			throw new RuntimeException(e);
		}		
		
	}
	
	public void remove(Contato contato) {
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM contatos WHERE id=?");
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
	

}
