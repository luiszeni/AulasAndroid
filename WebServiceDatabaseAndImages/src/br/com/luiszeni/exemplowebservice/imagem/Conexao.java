package br.com.luiszeni.exemplowebservice.imagem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost/webservicesandimages";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	// Obtem conexao com banco de dados
	public static Connection obtemConexao() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
