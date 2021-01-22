package com.ceiba.apuesta.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioApuestaPostgresql implements RepositorioApuesta {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="apuesta", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="apuesta", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="apuesta", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="apuesta", value="existePorId") 
    private static String sqlExistePorId;
    
    @SqlStatement(namespace="apuesta", value="validarMismaPersona") 
    private static String sqlValidarMismaPersona;
    
    @SqlStatement(namespace="apuesta", value="consultarTotalGanadores") 
    private static String sqlConsultarTotalGanadores;
    
    @SqlStatement(namespace="apuesta", value="consultarTotalPerdedores") 
    private static String sqlConsultarTotalPerdedores;
    
    @SqlStatement(namespace="apuesta", value="finalizarApuestas") 
    private static String sqlFinalizarApuestas;
    
    @SqlStatement(namespace="apuesta", value="partidoIniciado") 
    private static String sqlPartidoIniciado;
    
    @SqlStatement(namespace="apuesta", value="partidoIniciadoPorIdApuesta") 
    private static String sqlPartidoIniciadoPorIdApuesta;
    
    @SqlStatement(namespace="apuesta", value="partidoExiste") 
    private static String sqlPartidoExiste;
    
    public RepositorioApuestaPostgresql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public Long crear(Apuesta apuesta) {
		return this.customNamedParameterJdbcTemplate.crear(apuesta, sqlCrear);
	}

	@Override
	public void actualizar(Apuesta apuesta) {
		this.customNamedParameterJdbcTemplate.actualizar(apuesta, sqlActualizar);
	}

	@Override
	public void eliminar(Long idApuesta) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idApuesta", idApuesta);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existePorId(String idApuesta) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idApuesta", idApuesta);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
	}

	@Override
	public int validarApuestaParaLaMismaPersona(Long idPartido, String cedula) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);
        paramSource.addValue("cedula", cedula);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlValidarMismaPersona,paramSource, int.class);
	}

	@Override
	public int consultarTotalGanadores(Long idPartido, int puntajePais1, int puntajePais2) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);
        paramSource.addValue("puntajePais1", puntajePais1);
        paramSource.addValue("puntajePais2", puntajePais2);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarTotalGanadores,paramSource, int.class);
	}

	@Override
	public int consultarTotalDineroPerderores(Long idPartido, int puntajePais1, int puntajePais2) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);
        paramSource.addValue("puntajePais1", puntajePais1);
        paramSource.addValue("puntajePais2", puntajePais2);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultarTotalPerdedores,paramSource, int.class);
	}
	
	@Override
	public int finalizarApuestas(Long idPartido, int puntajePais1, int puntajePais2, int excedente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);
        paramSource.addValue("puntajePais1", puntajePais1);
        paramSource.addValue("puntajePais2", puntajePais2);
        paramSource.addValue("excedente", excedente);
      
        return this.customNamedParameterJdbcTemplate.actualizar(paramSource, sqlFinalizarApuestas);
	}

	@Override
	public Boolean validarPartidoIniciado(Long idPartido) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPartido", idPartido);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPartidoIniciado,paramSource, Boolean.class);
	}

	@Override
	public Long validarPartidoExiste(String pais1, String pais2, LocalDateTime horaInicio) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("pais1", pais1);
        paramSource.addValue("pais2", pais2);
        paramSource.addValue("horaInicio", horaInicio);
        
        try {
        	return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPartidoExiste,paramSource, Long.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } 
        
	}

	@Override
	public Boolean validarPartidoIniciadoPorApuesta(Long idApuesta) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idApuesta", idApuesta);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlPartidoIniciadoPorIdApuesta,paramSource, Boolean.class);
	}

}
