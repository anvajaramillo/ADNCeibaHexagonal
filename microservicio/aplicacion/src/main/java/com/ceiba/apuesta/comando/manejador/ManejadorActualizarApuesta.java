package com.ceiba.apuesta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;
import com.ceiba.apuesta.comando.ComandoApuesta;
import com.ceiba.apuesta.comando.fabrica.FabricaApuesta;
import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.servicio.ServicioActualizarApuesta;

@Component
public class ManejadorActualizarApuesta implements ManejadorComando<ComandoApuesta>{
	
	private final FabricaApuesta fabricaApuesta;
	private final ServicioActualizarApuesta servicioActualizarApuesta;

	public ManejadorActualizarApuesta(FabricaApuesta fabricaApuesta, ServicioActualizarApuesta servicioActualizarApuesta) {
		this.fabricaApuesta = fabricaApuesta;
		this.servicioActualizarApuesta = servicioActualizarApuesta;
	}

	public void ejecutar(ComandoApuesta comandoApuesta) {
		Apuesta apuesta = this.fabricaApuesta.transformar(comandoApuesta);
		this.servicioActualizarApuesta.ejecutar(apuesta);
	}

}
