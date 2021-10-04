package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Carro;
import com.mysql.jdbc.PreparedStatement;

public class CarroDao {
	
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
	
	public static int aprovarCarro(Carro u) {
		
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM carro");
			ps.setString(1, u.getMatricula());
			ps.setInt(2, u.getAno());
			ps.setString(3, u.getMarca());
            ps.setString(4, u.getModelo());
            ps.setString(5, u.getPlaca());
            ps.setString(6, u.getPropriedade());
            status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
	public static int deletarCarro(Carro u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM carro WHERE id=?");
			ps.setInt(1,  u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static int salvarCarro(Carro u) {
		
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO carro (matricula, ano, marca, modelo, placa, propriedade) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, u.getMatricula());
			ps.setInt(2, u.getAno());
			ps.setString(3, u.getMarca());
            ps.setString(4, u.getModelo());
            ps.setString(5, u.getPlaca());
            ps.setString(6, u.getPropriedade());
            status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
	public static Carro getRegistroById(int id) {
		Carro carro = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM carro WHERE id=?");
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setMatricula(rs.getString("matricula"));
				carro.setAno(rs.getInt("ano"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
				carro.setPlaca(rs.getString("placa"));
				carro.setPropriedade(rs.getString("propriedade"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return carro;
	}
	
	public static List<Carro> getAllUsuarios() {
		List<Carro> list = new ArrayList<Carro>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM carro");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Carro carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setMatricula(rs.getString("matricula"));
				carro.setAno(rs.getInt("ano"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
				carro.setPlaca(rs.getString("placa"));
				carro.setPropriedade(rs.getString("propriedade"));
				list.add(carro);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public static List<Carro> getRecords(int start, int total) {
		List<Carro> list = new ArrayList<Carro>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM LIMIT" + (start) + "," + total);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Carro carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setMatricula(rs.getString("matricula"));
				carro.setAno(rs.getInt("ano"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
				carro.setPlaca(rs.getString("placa"));
				carro.setPropriedade(rs.getString("propriedade"));
				list.add(carro);
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

}
