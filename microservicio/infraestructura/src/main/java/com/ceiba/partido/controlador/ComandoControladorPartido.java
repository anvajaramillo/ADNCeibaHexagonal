package com.ceiba.partido.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.partido.comando.ComandoPartido;
import com.ceiba.partido.comando.manejador.ManejadorActualizarPartido;
import com.ceiba.partido.comando.manejador.ManejadorCrearPartido;
import com.ceiba.partido.comando.manejador.ManejadorEliminarPartido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/partidos")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorPartido {
	
	private final ManejadorCrearPartido manejadorCrearPartido;
	private final ManejadorActualizarPartido manejadorActualizarPartido;
	private final ManejadorEliminarPartido manejadorEliminarPartido;
	
	@Autowired
    public ComandoControladorPartido(ManejadorCrearPartido manejadorCrearPartido,ManejadorActualizarPartido manejadorActualizarPartido,ManejadorEliminarPartido manejadorEliminarPartido) {
        this.manejadorCrearPartido = manejadorCrearPartido;
		this.manejadorActualizarPartido = manejadorActualizarPartido;
		this.manejadorEliminarPartido = manejadorEliminarPartido;
    }
	
	@PostMapping
    @ApiOperation("Crear Partido")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPartido comandoPartido) {
        return manejadorCrearPartido.ejecutar(comandoPartido);
    }
	
	@PutMapping(value="/{idPartido}")
	@ApiOperation("Actualizar Partido")
	public void actualizar(@RequestBody ComandoPartido comandoPartido,@PathVariable Long idPartido) {
		comandoPartido.setIdPartido(idPartido);
		manejadorActualizarPartido.ejecutar(comandoPartido);
	}

    @DeleteMapping(value="/{idPartido}")
	@ApiOperation("Eliminar Partido")
	public void eliminar(@PathVariable Long idPartido) {
    	manejadorEliminarPartido.ejecutar(idPartido);
	}

}
