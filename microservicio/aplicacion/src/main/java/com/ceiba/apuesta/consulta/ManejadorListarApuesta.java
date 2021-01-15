package com.ceiba.apuesta.consulta;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ceiba.apuesta.modelo.dto.DtoApuesta;
import com.ceiba.apuesta.puerto.dao.DaoApuesta;

@Component
public class ManejadorListarApuesta {
	
	private final DaoApuesta daoApuesta;

	public ManejadorListarApuesta(DaoApuesta daoApuesta) {
		this.daoApuesta = daoApuesta;
	}
	
	public List<DtoApuesta> ejecutar(){
		return this.daoApuesta.listar();
	}

}
