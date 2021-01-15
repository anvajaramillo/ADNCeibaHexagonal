package com.ceiba.apuesta.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.apuesta.servicio.ServicioEliminarApuesta;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorEliminarApuesta  implements ManejadorComando<Long>{
	
	private final ServicioEliminarApuesta servicioEliminarApuesta;

	public ManejadorEliminarApuesta(ServicioEliminarApuesta servicioEliminarApuesta) {
		this.servicioEliminarApuesta = servicioEliminarApuesta;
	}

	public void ejecutar(Long idApuesta) {
		this.servicioEliminarApuesta.ejecutar(idApuesta);
	}

}
