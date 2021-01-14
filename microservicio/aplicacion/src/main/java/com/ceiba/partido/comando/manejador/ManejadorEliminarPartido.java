package com.ceiba.partido.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.partido.servicio.ServicioEliminarPartido;

@Component
public class ManejadorEliminarPartido implements ManejadorComando<Long>{
	
	private final ServicioEliminarPartido servicioEliminarPartido;
	
	public ManejadorEliminarPartido(ServicioEliminarPartido servicioEliminarPartido){
		this.servicioEliminarPartido = servicioEliminarPartido;
	}
	
	public void ejecutar(Long idPartido){
		this.servicioEliminarPartido.ejecutar(idPartido);
	}
	
}
