package com.ceiba.partido.puerto.dao;

import java.util.List;

import com.ceiba.partido.modelo.dto.DtoPartido;


public interface DaoPartido {
	
    List<DtoPartido> listar();
    
    DtoPartido consultarPorId(Long idPartido);

}
