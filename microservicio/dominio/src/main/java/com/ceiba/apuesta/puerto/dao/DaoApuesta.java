package com.ceiba.apuesta.puerto.dao;

import java.util.List;

import com.ceiba.apuesta.modelo.dto.DtoApuesta;

public interface DaoApuesta {
	
    List<DtoApuesta> listar();
    
    List<DtoApuesta> consultarResultados(Long idPartido);
    
    DtoApuesta consultarPorId(Long idApuesta);

}
