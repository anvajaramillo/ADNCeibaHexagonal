package com.ceiba.partido.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.partido.modelo.dto.DtoPartido;
import com.ceiba.partido.puerto.dao.DaoPartido;

@Component
public class ManejadorListarPartidos {
	
	private final DaoPartido daoPartido;
	
	public ManejadorListarPartidos(DaoPartido daoPartido){
		this.daoPartido = daoPartido;
	}
	
	public List<DtoPartido> ejecutar(){
		return this.daoPartido.listar();
	}

}
