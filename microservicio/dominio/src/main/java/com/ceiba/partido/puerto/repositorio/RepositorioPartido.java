package com.ceiba.partido.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.partido.modelo.entidad.Partido;

public interface RepositorioPartido {
	
	Long crear(Partido partido);
	
	int actualizar(Partido partido);
	
	void eliminar(Long idPartido);
	
	boolean existePorId(String idPartido);
	
	Boolean validarApuestaAsignada(Long idPartido);

	int finalizarPartido(Partido partido);

	Boolean validarPartidoExiste(String pais1, String pais2, LocalDateTime horaInicio);

}
