package com.ceiba.partido.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.partido.modelo.dto.DtoPartido;


public class MapeoPartido implements RowMapper<DtoPartido>, MapperResult {

	@Override
	public DtoPartido mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Long idPartido = resultSet.getLong("id");
		String pais1 = resultSet.getString("pais1");
		String pais2 = resultSet.getString("pais2");
		LocalDateTime horaInicio = extraerLocalDateTime(resultSet, "hora_inicio");
		LocalDateTime horaFin = extraerLocalDateTime(resultSet, "hora_fin");
		int puntajePais1 = resultSet.getInt("puntaje_pais1");
		int puntajePais2 = resultSet.getInt("puntaje_pais2");
		
		return new DtoPartido(idPartido,pais1,pais2,horaInicio,horaFin,puntajePais1,puntajePais2);
		
	}

	

}
