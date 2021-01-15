package com.ceiba.apuesta.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.apuesta.comando.ComandoApuesta;
import com.ceiba.apuesta.comando.fabrica.FabricaApuesta;
import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.servicio.ServicioCrearApuesta;

@Component
public class ManejadorCrearApuesta implements ManejadorComandoRespuesta<ComandoApuesta, ComandoRespuesta<Long>>{
	
	private final FabricaApuesta fabricaApuesta;
	private final ServicioCrearApuesta servicioCrearApuesta;

	public ManejadorCrearApuesta(FabricaApuesta fabricaApuesta, ServicioCrearApuesta servicioCrearApuesta) {
		this.fabricaApuesta = fabricaApuesta;
		this.servicioCrearApuesta = servicioCrearApuesta;
	}
	
	public ComandoRespuesta<Long> ejecutar(ComandoApuesta comandoApuesta) {
		Apuesta apuesta = this.fabricaApuesta.transformar(comandoApuesta);
		return new ComandoRespuesta<>(this.servicioCrearApuesta.ejecutar(apuesta));
	}

}
