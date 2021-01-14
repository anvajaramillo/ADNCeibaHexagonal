package com.ceiba.partido.adaptador.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.partido.modelo.dto.DtoPartido;
import com.ceiba.partido.puerto.dao.DaoPartido;

@Component
public class DaoPartidoPostgresql implements DaoPartido {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="partido", value="listar")
	private static String sqlListar;
	
	public DaoPartidoPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public List<DtoPartido> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPartido());
	}

}
