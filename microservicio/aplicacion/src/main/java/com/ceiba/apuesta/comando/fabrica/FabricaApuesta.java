package com.ceiba.apuesta.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.apuesta.comando.ComandoApuesta;
import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.partido.comando.fabrica.FabricaPartido;

@Component
public class FabricaApuesta {

	public Apuesta transformar(ComandoApuesta comandoApuesta){
		return new Apuesta(
				comandoApuesta.getIdApuesta(), 
				comandoApuesta.getDinero(), 
				comandoApuesta.getNombre(), 
				comandoApuesta.getCedula(), 
				comandoApuesta.getPuntajePais1(), 
				comandoApuesta.getPuntajePais2(), 
				comandoApuesta.isGanador(), 
				comandoApuesta.getDineroGanado(), 
				new FabricaPartido().transformar(comandoApuesta.getPartido()));
	}
	
}
