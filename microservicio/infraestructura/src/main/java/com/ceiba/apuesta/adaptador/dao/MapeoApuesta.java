package com.ceiba.apuesta.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ceiba.apuesta.modelo.dto.DtoApuesta;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.partido.adaptador.dao.MapeoPartido;
import com.ceiba.partido.modelo.dto.DtoPartido;

public class MapeoApuesta implements RowMapper<DtoApuesta>, MapperResult {
	
	@Override
	public DtoApuesta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Long id = resultSet.getLong("id");
		int dinero = resultSet.getInt("dinero");
		String nombre = resultSet.getString("nombre");
		String cedula = resultSet.getString("cedula");
		int puntajePais1 = resultSet.getInt("puntajepais1");
		int puntajePais2 = resultSet.getInt("puntajepais2");
		boolean isGanador = resultSet.getBoolean("is_ganador");
		int dineroGanado = resultSet.getInt("dinero_ganado");
		DtoPartido dtoPartido = new MapeoPartido().mapRow(resultSet,rowNum);
		
		return new DtoApuesta(id,dinero,nombre,cedula,puntajePais1,puntajePais2,isGanador,dineroGanado,dtoPartido);
	}

}
