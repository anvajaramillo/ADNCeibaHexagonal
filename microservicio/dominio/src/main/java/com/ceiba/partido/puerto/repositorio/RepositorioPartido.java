package com.ceiba.partido.puerto.repositorio;

import com.ceiba.partido.modelo.entidad.Partido;

public interface RepositorioPartido {
	
	Long crear(Partido partido);
	
	void actualizar(Partido partido);
	
	void eliminar(Long idPartido);
	
	boolean existePorId(String idPartido);

}
