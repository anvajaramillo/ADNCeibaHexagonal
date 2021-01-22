package com.ceiba.apuesta.servicio;

import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioEliminarApuesta {
	
	private static final String VALIDAR_PARTIDO_INICIADO = "NO SE PUEDE ACTUALIZAR LA APUESTA PORQUE EL PARTIDO YA INICI�";
	
	private final RepositorioApuesta repositorioApuesta;

	public ServicioEliminarApuesta(RepositorioApuesta repositorioApuesta) {
		this.repositorioApuesta = repositorioApuesta;
	}
	
	public int ejecutar(Long idApuesta){
		validarPartidoIniciado(idApuesta);
		return this.repositorioApuesta.eliminar(idApuesta);
	}
	
	private void validarPartidoIniciado(Long idApuesta){
		Boolean partidoIniciado = this.repositorioApuesta.validarPartidoIniciadoPorApuesta(idApuesta);
		if(Boolean.TRUE.equals(partidoIniciado)){
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_INICIADO);
		}
	}

}
