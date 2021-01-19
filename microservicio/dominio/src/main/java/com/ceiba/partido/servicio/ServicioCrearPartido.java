package com.ceiba.partido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioCrearPartido {
	
	private static final String VALIDAR_PARTIDO_EXISTE = "NO SE PUEDE CREAR EL PARTIDO DEBIDO A QUE YA EXISTE";
	
	private final RepositorioPartido respositorioPartido;
	
	public ServicioCrearPartido(RepositorioPartido respositorioPartido){
		this.respositorioPartido = respositorioPartido;
	}
	
	public Long ejecutar(Partido partido){
		validarPartidoExiste(partido);
		return this.respositorioPartido.crear(partido);
	}
	
	private void validarPartidoExiste(Partido partido){
		Boolean partidoExiste = this.respositorioPartido.validarPartidoExiste(partido.getPais1(),partido.getPais2(),partido.getHoraInicio());
		if(Boolean.TRUE.equals(partidoExiste)){
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_EXISTE);
		}
	}

}
