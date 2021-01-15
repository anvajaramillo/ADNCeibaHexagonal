package com.ceiba.apuesta.servicio;

import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioActualizarApuesta {
	
	private static final String VALIDAR_PARTIDO_INICIADO = "NO SE PUEDE CREAR LA APUESTA PORQUE EL PARTIDO YA INICIÓ";
	private static final String VALIDAR_APUESTAS_PARA_LA_MISMA_PERSONAS = "LA PERSONA YA TIENE CREADA UNA APUESTA PARA ESTE PARTIDO";
	
	private final RepositorioApuesta repositorioApuesta;
	private final RepositorioPartido repositorioPartido;

	public ServicioActualizarApuesta(RepositorioApuesta repositorioApuesta, RepositorioPartido repositorioPartido) {
		this.repositorioApuesta = repositorioApuesta;
		this.repositorioPartido = repositorioPartido;
	}

	public void ejecutar(Apuesta apuesta){
		validarPartidoIniciado(apuesta.getPartido().getIdPartido());
		validarApuestasParaLaMismaPersona(apuesta.getPartido().getIdPartido(), apuesta.getCedula());
		this.repositorioApuesta.actualizar(apuesta);
	}
	
	private void validarPartidoIniciado(Long idPartido){
		Boolean partidoIniciado = this.repositorioPartido.validarPartidoIniciado(idPartido);
		if(Boolean.TRUE.equals(partidoIniciado)){
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_INICIADO);
		}
	}
	
	private void validarApuestasParaLaMismaPersona(Long idPartido, String cedula){
		int apuestaParaLaMismaPersona = this.repositorioApuesta.validarApuestaParaLaMismaPersona(idPartido, cedula);
		if(apuestaParaLaMismaPersona > 1){
			throw new ExcepcionValorInvalido(VALIDAR_APUESTAS_PARA_LA_MISMA_PERSONAS);
		}
	}

}
