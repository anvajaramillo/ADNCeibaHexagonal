package com.ceiba.partido.consulta;

import org.springframework.stereotype.Component;
import com.ceiba.partido.modelo.dto.DtoPartido;
import com.ceiba.partido.puerto.dao.DaoPartido;

@Component
public class ManejadorConsultarPartido {
	
	private final DaoPartido daoPartido;
	
	public ManejadorConsultarPartido(DaoPartido daoPartido){
		this.daoPartido = daoPartido;
	}
	
	public DtoPartido ejecutar(Long idPartido){
		return this.daoPartido.consultarPorId(idPartido);
	}


}
