package com.ceiba.partido.servicio;

import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioEliminarPartido {
	
	private final RepositorioPartido repositorioPartido;
	
	public ServicioEliminarPartido(RepositorioPartido repositorioPartido){
		this.repositorioPartido = repositorioPartido;
	}
	
	public void ejecutar(Long idPartido){
		this.repositorioPartido.eliminar(idPartido);
	}

}
