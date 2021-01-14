package com.ceiba.partido.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.partido.comando.ComandoPartido;
import com.ceiba.partido.comando.fabrica.FabricaPartido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.servicio.ServicioActualizarPartido;

@Component
public class ManejadorActualizarPartido implements ManejadorComando<ComandoPartido>{

	private final FabricaPartido fabricaPartido;
	private final ServicioActualizarPartido servicioActualizarPartido;
	
	public ManejadorActualizarPartido(FabricaPartido fabricaPartido, ServicioActualizarPartido servicioActualizarPartido){
		this.fabricaPartido = fabricaPartido;
		this.servicioActualizarPartido = servicioActualizarPartido;
	}
	
	public void ejecutar(ComandoPartido comandoPartido){
		Partido partido = this.fabricaPartido.transformar(comandoPartido);
		this.servicioActualizarPartido.ejecutar(partido);
	}
	
}
