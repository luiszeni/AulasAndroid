package br.com.luiszeni.exemplowebservice.imagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

	public int inserirUsuario(Usuario usuario) {

		try {
			Connection conn = Conexao.obtemConexao();
			String sqlSelect = "INSERT INTO usuario VALUES (null, ?, ?,?)";
			PreparedStatement stmt = null;

			stmt = conn.prepareStatement(sqlSelect,	Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getIdade());
			stmt.setBytes(3, usuario.getFoto());

			int affectedRows = stmt.executeUpdate();
			
			if (affectedRows == 0) {
				return -1;
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return (int) generatedKeys.getLong(1);
				} else {
					return -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	public Usuario buscaUsuarioPorId(int id) {

		Usuario usuario = new Usuario();
		try {
			Connection conn = Conexao.obtemConexao();
			String sqlSelect = "SELECT * FROM usuario WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlSelect);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				usuario.setId(rs.getInt(1));
				usuario.setNome(rs.getString(2));
				usuario.setIdade(rs.getInt(3));
				usuario.setFoto(rs.getBytes(4));
			} else {
				return null;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return usuario;
	}
	
	
	public ArrayList<Usuario> buscarTodosUsuarios(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection conn = Conexao.obtemConexao();
			String queryInserir = "SELECT * FROM usuario";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ResultSet rSet = ppStm.executeQuery();
			
			while(rSet.next()){
				Usuario usr = new Usuario();
				
				usr.setId(rSet.getInt(1));
				usr.setNome(rSet.getString(2));
				usr.setIdade(rSet.getInt(3));
				usr.setFoto(rSet.getBytes(4));
				lista.add(usr);
				
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public boolean excluirUsuario(int id){
		try {
			Connection conn = Conexao.obtemConexao();
			String queryInserir = "DELETE FROM usuario WHERE id = ?";
			
			PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			ppStm.setInt(1, id);
			
			ppStm.executeUpdate();
		
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
