package br.fiap.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CargoDAO extends DAO {

	// método para retornar a lista de cargos
	public Map<Integer, String> listar() {
		Map<Integer, String> mapa = new HashMap<>();
		sql = "select * from java_cargo order by id_cargo";
		
		try(Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				mapa.put(rs.getInt("id_cargo"), rs.getString("cargo"));
			}
		} 
		catch (SQLException e) {
			System.out.println("erro ao listar cargo\n" + e);
		}
		
		return mapa;
	}
	
	
}
