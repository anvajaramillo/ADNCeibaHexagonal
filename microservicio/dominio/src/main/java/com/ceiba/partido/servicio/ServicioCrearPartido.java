package com.ceiba.partido.servicio;

import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioCrearPartido {
	
	private final RepositorioPartido respositorioPartido;
	
	public ServicioCrearPartido(RepositorioPartido respositorioPartido){
		this.respositorioPartido = respositorioPartido;
	}
	
	public Long ejecutar(Partido partido){
		return this.respositorioPartido.crear(partido);
	}

}
