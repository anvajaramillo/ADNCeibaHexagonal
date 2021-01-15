package com.ceiba.partido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioEliminarPartido {
	
	private static final String VALIDAR_APUESTA_ASIGNADA = "NO SE PUEDE ELIMINAR EL PARTIDO DEBIDO A QUE TIENE APUESTAS ASIGNADAS";
	
	private final RepositorioPartido repositorioPartido;
	
	public ServicioEliminarPartido(RepositorioPartido repositorioPartido){
		this.repositorioPartido = repositorioPartido;
	}
	
	public void ejecutar(Long idPartido){
		validarApuestaAsignada(idPartido);
		this.repositorioPartido.eliminar(idPartido);
	}
	
	private void validarApuestaAsignada(Long idPartido){
		Boolean apuestaAsignada = this.repositorioPartido.validarApuestaAsignada(idPartido);
		if(Boolean.TRUE.equals(apuestaAsignada)){
			throw new ExcepcionValorInvalido(VALIDAR_APUESTA_ASIGNADA);
		}
	}

}
