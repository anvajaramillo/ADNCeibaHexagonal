package com.ceiba.apuesta.servicio;

import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioEliminarApuesta {
	
	private static final String VALIDAR_PARTIDO_INICIADO = "NO SE PUEDE ACTUALIZAR LA APUESTA PORQUE EL PARTIDO YA INICIÓ";
	
	private final RepositorioApuesta repositorioApuesta;

	public ServicioEliminarApuesta(RepositorioApuesta repositorioApuesta) {
		this.repositorioApuesta = repositorioApuesta;
	}
	
	public void ejecutar(Long idApuesta){
		validarPartidoIniciado(idApuesta);
		this.repositorioApuesta.eliminar(idApuesta);
	}
	
	private void validarPartidoIniciado(Long idApuesta){
		Boolean partidoIniciado = this.repositorioApuesta.validarPartidoIniciadoPorApuesta(idApuesta);
		if(Boolean.TRUE.equals(partidoIniciado)){
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_INICIADO);
		}
	}

}
