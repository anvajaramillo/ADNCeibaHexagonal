package com.ceiba.partido.puerto.dao;

import java.util.List;

import com.ceiba.partido.modelo.dto.DtoPartido;


public interface DaoPartido {
	
	/**
     * Permite listar partidos
     * @return los partidos
     */
    List<DtoPartido> listar();

}
