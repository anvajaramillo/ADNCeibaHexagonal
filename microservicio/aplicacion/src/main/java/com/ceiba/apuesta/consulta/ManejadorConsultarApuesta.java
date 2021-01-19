package com.ceiba.apuesta.consulta;

import org.springframework.stereotype.Component;
import com.ceiba.apuesta.modelo.dto.DtoApuesta;
import com.ceiba.apuesta.puerto.dao.DaoApuesta;

@Component
public class ManejadorConsultarApuesta {
	
	private final DaoApuesta daoApuesta;

	public ManejadorConsultarApuesta(DaoApuesta daoApuesta) {
		this.daoApuesta = daoApuesta;
	}
	
	public DtoApuesta ejecutar(Long idApuesta){
		return this.daoApuesta.consultarPorId(idApuesta);
	}

}
