package com.ceiba.apuesta.servicio;

import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioCrearApuesta {
	
	private static final String VALIDAR_PARTIDO_INICIADO = "NO SE PUEDE CREAR LA APUESTA PORQUE EL PARTIDO YA INICIÓ";
	private static final String VALIDAR_APUESTAS_PARA_LA_MISMA_PERSONAS = "LA PERSONA YA TIENE CREADA UNA APUESTA PARA ESTE PARTIDO";
	
	private final RepositorioApuesta repositorioApuesta;
	
	public ServicioCrearApuesta(RepositorioApuesta repositorioApuesta) {
		this.repositorioApuesta = repositorioApuesta;
	}

	public Long ejecutar(Apuesta apuesta){
		validarPartidoIniciado(apuesta.getPartido().getIdPartido());
		validarApuestasParaLaMismaPersona(apuesta.getPartido().getIdPartido(), apuesta.getCedula());
		return this.repositorioApuesta.crear(apuesta);
	}
	
	private void validarPartidoIniciado(Long idApuesta){
		Boolean partidoIniciado = this.repositorioApuesta.validarPartidoIniciado(idApuesta);
		if(Boolean.TRUE.equals(partidoIniciado)){
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_INICIADO);
		}
	}
	
	private void validarApuestasParaLaMismaPersona(Long idPartido, String cedula){
		int apuestaParaLaMismaPersona = this.repositorioApuesta.validarApuestaParaLaMismaPersona(idPartido, cedula);
		if(apuestaParaLaMismaPersona > 0){
			throw new ExcepcionValorInvalido(VALIDAR_APUESTAS_PARA_LA_MISMA_PERSONAS);
		}
	}

}
