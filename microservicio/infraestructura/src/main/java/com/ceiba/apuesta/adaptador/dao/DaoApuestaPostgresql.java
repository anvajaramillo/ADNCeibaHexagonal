package com.ceiba.apuesta.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.apuesta.modelo.dto.DtoApuesta;
import com.ceiba.apuesta.puerto.dao.DaoApuesta;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoApuestaPostgresql implements DaoApuesta {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	public DaoApuestaPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@SqlStatement(namespace="apuesta", value="listar")
	private static String sqlListar;
	
	@SqlStatement(namespace="apuesta", value="consultarResultados")
	private static String sqlConsultarResultados;
	
	@Override
	public List<DtoApuesta> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoApuesta());
	}

	@Override
	public List<DtoApuesta> consultarResultados(Long idPartido) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);
        
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultarResultados, paramSource, new MapeoApuesta());
	}

}
