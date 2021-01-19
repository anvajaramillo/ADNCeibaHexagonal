package com.ceiba.partido.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

@Repository
public class RepositorioPartidoPostgresql implements RepositorioPartido{
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="partido", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="partido", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="partido", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="partido", value="existePorId") 
    private static String sqlExistePorId;
    
    @SqlStatement(namespace="partido", value="finalizarPartido") 
    private static String sqlFinalizarPartido;
    
    @SqlStatement(namespace="partido", value="partidoExiste") 
    private static String sqlPartidoExiste;
    
    @SqlStatement(namespace="partido", value="apuestaAsignada") 
    private static String sqlApuestaAsignada;
    
    public RepositorioPartidoPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public Long crear(Partido partido) {
		return this.customNamedParameterJdbcTemplate.crear(partido, sqlCrear);
	}

	@Override
	public void actualizar(Partido partido) {
		this.customNamedParameterJdbcTemplate.actualizar(partido, sqlActualizar);
	}

	@Override
	public void eliminar(Long idPartido) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existePorId(String idPartido) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPartido);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
	}

	@Override
	public void finalizarPartido(Partido partido) {
		this.customNamedParameterJdbcTemplate.actualizar(partido, sqlFinalizarPartido);
	}

	@Override
	public Boolean validarPartidoExiste(String pais1, String pais2, LocalDateTime horaInicio) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("pais1", pais1);
        paramSource.addValue("pais2", pais2);
        paramSource.addValue("horaInicio", horaInicio);
        
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPartidoExiste,paramSource, Boolean.class);
	}
	
	@Override
	public Boolean validarApuestaAsignada(Long idPartido) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlApuestaAsignada,paramSource, Boolean.class);
	}

}
