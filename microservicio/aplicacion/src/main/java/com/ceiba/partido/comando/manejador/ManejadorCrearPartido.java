package com.ceiba.partido.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.partido.comando.ComandoPartido;
import com.ceiba.partido.comando.fabrica.FabricaPartido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.servicio.ServicioCrearPartido;


@Component
public class ManejadorCrearPartido implements ManejadorComandoRespuesta<ComandoPartido, ComandoRespuesta<Long>> {
	
	private final FabricaPartido fabricaPartido;
	private final ServicioCrearPartido servicioCrearPartido;
	
	public ManejadorCrearPartido(FabricaPartido fabricaPartido, ServicioCrearPartido servicioCrearPartido) {
		this.fabricaPartido = fabricaPartido;
		this.servicioCrearPartido = servicioCrearPartido;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoPartido comandoPartido) {
		Partido partido = this.fabricaPartido.transformar(comandoPartido);
		return new ComandoRespuesta<>(this.servicioCrearPartido.ejecutar(partido));
	}

}
