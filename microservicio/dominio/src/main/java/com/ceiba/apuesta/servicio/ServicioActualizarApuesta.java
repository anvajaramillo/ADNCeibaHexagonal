package com.ceiba.apuesta.servicio;

import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;

public class ServicioActualizarApuesta {
	
	private static final String VALIDAR_PARTIDO_INICIADO = "NO SE PUEDE ACTUALIZAR LA APUESTA PORQUE EL PARTIDO YA INICIÓ";
	private static final String VALIDAR_APUESTAS_PARA_LA_MISMA_PERSONAS = "LA PERSONA YA TIENE CREADA UNA APUESTA PARA ESTE PARTIDO";
	private static final String VALIDAR_PARTIDO_EXISTE = "NO SE PUEDE ACTUALIZAR LA APUESTA DEBIDO A QUE EL PARTIDO NO EXISTE";
	
	private final RepositorioApuesta repositorioApuesta;

	public ServicioActualizarApuesta(RepositorioApuesta repositorioApuesta) {
		this.repositorioApuesta = repositorioApuesta;
	}

	public int ejecutar(Apuesta apuesta){
		Long idPartido = validarPartidoExiste(apuesta.getPartido());
		validarPartidoIniciado(idPartido);
		validarApuestasParaLaMismaPersona(idPartido, apuesta.getCedula());
		apuesta.setIdPartido(idPartido);
		apuesta.getPartido().setIdPartido(idPartido);
		return this.repositorioApuesta.actualizar(apuesta);
	}
	
	private void validarPartidoIniciado(Long idPartido){
		Boolean partidoIniciado = this.repositorioApuesta.validarPartidoIniciado(idPartido);
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
	
	private Long validarPartidoExiste(Partido partido){
		Long partidoExiste = this.repositorioApuesta.validarPartidoExiste(partido.getPais1(),partido.getPais2(),partido.getHoraInicio());
		if(partidoExiste != null){
			return partidoExiste;
		}else{
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_EXISTE);
		}
	}

}
