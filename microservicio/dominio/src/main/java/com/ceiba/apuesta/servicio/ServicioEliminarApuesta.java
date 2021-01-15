package com.ceiba.apuesta.servicio;

import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;

public class ServicioEliminarApuesta {
	
	private final RepositorioApuesta repositorioApuesta;

	public ServicioEliminarApuesta(RepositorioApuesta repositorioApuesta) {
		this.repositorioApuesta = repositorioApuesta;
	}
	
	public void ejecutar(Long idApuesta){
		this.repositorioApuesta.eliminar(idApuesta);
	}

}
