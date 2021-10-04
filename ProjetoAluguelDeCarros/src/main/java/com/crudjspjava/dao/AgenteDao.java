package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Agente;
import com.mysql.jdbc.PreparedStatement;

public class AgenteDao {
	
	public static Connection getConnection() {
		Connection con = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjavacarros", "root", "");
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return con;
	
	}
	
	public static int deletarAgente(Agente u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM agente WHERE id=?");
			ps.setInt(1,  u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static int salvarAgente(Agente u) {
		
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO agente (nome, password, email, endereco, cpf, rg, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
            ps.setString(4,  u.getEndereco());
            ps.setString(5,  u.getCpf());
            ps.setString(6,  u.getRg());
            ps.setString(7, u.getTipo());
            status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
	public static Agente getRegistroById(int id) {
		Agente agente = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM agente WHERE id=?");
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				agente = new Agente();
				agente.setId(rs.getInt("id"));
				agente.setNome(rs.getString("nome"));
				agente.setPassword(rs.getString("password"));
				agente.setEmail(rs.getString("email"));
				agente.setEndereco(rs.getString("endereco"));
				agente.setCpf(rs.getString("cpf"));
				agente.setRg(rs.getString("rg"));
				agente.setTipo(rs.getString("tipo"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return agente;
	}
	
	public static int updateAgente(Agente u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE agente SET nome=?, " + "password=?, email=?, endereco=?, cpf=?, rg=?, tipo=? WHERE id=?");
			
			ps.setString(1,  u.getNome());
			ps.setString(2,  u.getPassword());
			ps.setString(3,  u.getEmail());
			ps.setString(4, u.getEndereco());
			ps.setString(5,  u.getCpf());
			ps.setString(6,  u.getRg());
			ps.setString(7, u.getTipo());
			ps.setInt(8,  u.getId());
			status = ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static List<Agente> getAllUsuarios() {
		List<Agente> list = new ArrayList<Agente>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM agente");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Agente agente = new Agente();
				agente.setId(rs.getInt("id"));
				agente.setNome(rs.getString("nome"));
				agente.setPassword(rs.getString("password"));
				agente.setEmail(rs.getString("email"));
				agente.setEndereco(rs.getString("endereco"));
				agente.setCpf(rs.getString("cpf"));
				agente.setRg(rs.getString("rg"));
				agente.setTipo(rs.getString("tipo"));
				list.add(agente);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public static List<Agente> getRecords(int start, int total) {
		List<Agente> list = new ArrayList<Agente>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM LIMIT" + (start) + "," + total);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Agente agente = new Agente();
				agente.setId(rs.getInt("id"));
				agente.setNome(rs.getString("nome"));
				agente.setPassword(rs.getString("password"));
				agente.setEmail(rs.getString("email"));
				agente.setEndereco(rs.getString("endereco"));
				agente.setCpf(rs.getString("cpf"));
				agente.setRg(rs.getString("rg"));
				agente.setTipo(rs.getString("tipo"));
				list.add(agente);
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

}
