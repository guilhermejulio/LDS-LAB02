package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDao {

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
	
	public static int deletarUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuario WHERE id=?");
			ps.setInt(1,  u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static int salvarUsuario(Usuario u) {
		
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuario (nome, password, email, endereco, cpf, rg, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)");
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
	
	public static Usuario getRegistroById(int id) {
		Usuario usuario = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE id=?");
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setRg(rs.getString("rg"));
				usuario.setTipo(rs.getString("tipo"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return usuario;
	}
	
	public static int updateUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuario SET nome=?, " + "password=?, email=?, endereco=?, cpf=?, rg=?, tipo=? WHERE id=?");
			
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
	
	public static List<Usuario> getAllUsuarios() {
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setRg(rs.getString("rg"));
				usuario.setTipo(rs.getString("tipo"));
				list.add(usuario);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public static List<Usuario> getRecords(int start, int total) {
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM LIMIT" + (start) + "," + total);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setRg(rs.getString("rg"));
				usuario.setTipo(rs.getString("tipo"));
				list.add(usuario);
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
}
