package com.ceiba.partido.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.partido.comando.ComandoPartido;
import com.ceiba.partido.modelo.entidad.Partido;

@Component
public class FabricaPartido {

	public Partido transformar(ComandoPartido comandoPartido){
		return new Partido(
				comandoPartido.getIdPartido(),
				comandoPartido.getPais1(),
				comandoPartido.getPais2(),
				comandoPartido.getHoraInicio(),
				comandoPartido.getHoraFin(),
				comandoPartido.getPuntajePais1(),
				comandoPartido.getPuntajePais2()
			);
							
	}
	
}
