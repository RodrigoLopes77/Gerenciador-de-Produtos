package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			System.out.println("Procurando o driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado!");
		} catch (ClassNotFoundException ex) {
			System.err.println("O driver não encontrado.");
		}
	}
	
	public static Connection conectar() {
		try {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/web_produtos?useTimezone=true&serverTimezone=UTC&useSSL=false", 
							"root", "001626");
		} catch (SQLException ex) {
			System.err.println("NÃ£o foi possivel conexão");
			ex.printStackTrace();
			return null;
		}
	}
	
}
