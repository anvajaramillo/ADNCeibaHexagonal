package com.ceiba.partido.servicio;

import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioActualizarPartido {
	
	private final RepositorioPartido repositorioPartido;
	
	public ServicioActualizarPartido(RepositorioPartido repositorioPartido){
		this.repositorioPartido = repositorioPartido;
	}
	
	public void ejecutar(Partido partido){
		this.repositorioPartido.actualizar(partido);
	}


}
