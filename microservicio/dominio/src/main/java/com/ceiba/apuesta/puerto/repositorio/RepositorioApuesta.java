package com.ceiba.apuesta.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.apuesta.modelo.entidad.Apuesta;

public interface RepositorioApuesta {

	Long crear(Apuesta apuesta);
	
	void actualizar(Apuesta apuesta);
	
	void eliminar(Long idApuesta);
	
	boolean existePorId(String idApuesta);

	int validarApuestaParaLaMismaPersona(Long idPartido, String cedula);

	int consultarTotalGanadores(Long idPartido, int puntajePais1, int puntajePais2);

	int consultarTotalDineroPerderores(Long idPartido, int puntajePais1, int puntajePais2);

	void finalizarApuestas(Long idPartido, int puntajePais1, int puntajePais2, int calcularExcedente);

	Boolean validarPartidoIniciado(Long idPartido);
	
	Boolean validarPartidoIniciadoPorApuesta(Long idApuesta);

	Long validarPartidoExiste(String pais1, String pais2, LocalDateTime horaInicio);
	
}
