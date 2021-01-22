package com.ceiba.apuesta.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.ComandoRespuesta;
import com.ceiba.apuesta.comando.ComandoApuesta;
import com.ceiba.apuesta.comando.manejador.ManejadorActualizarApuesta;
import com.ceiba.apuesta.comando.manejador.ManejadorCrearApuesta;
import com.ceiba.apuesta.comando.manejador.ManejadorEliminarApuesta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/apuestas")
@Api(tags = { "Controlador comando apuesta"})
public class ComandoControladorApuesta {
	
	private final ManejadorCrearApuesta manejadorCrearApuesta;
	private final ManejadorActualizarApuesta manejadorActualizarApuesta;
	private final ManejadorEliminarApuesta manejadorEliminarApuesta;
	
	@Autowired
	public ComandoControladorApuesta(ManejadorCrearApuesta manejadorCrearApuesta,ManejadorActualizarApuesta manejadorActualizarApuesta, ManejadorEliminarApuesta manejadorEliminarApuesta) {
		this.manejadorCrearApuesta = manejadorCrearApuesta;
		this.manejadorActualizarApuesta = manejadorActualizarApuesta;
		this.manejadorEliminarApuesta = manejadorEliminarApuesta;
	}
	
	@PostMapping
    @ApiOperation("Crear Apuesta")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoApuesta comandoApuesta) {
        return manejadorCrearApuesta.ejecutar(comandoApuesta);
    }
	
	@PutMapping(value="/{idApuesta}")
	@ApiOperation("Actualizar Apuesta")
	public void actualizar(@RequestBody ComandoApuesta comandoApuesta,@PathVariable Long idApuesta) {
		comandoApuesta.setIdApuesta(idApuesta);
		manejadorActualizarApuesta.ejecutar(comandoApuesta);
	}

    @DeleteMapping(value="/{idApuesta}")
	@ApiOperation("Eliminar Apuesta")
	public void eliminar(@PathVariable Long idApuesta) {
    	manejadorEliminarApuesta.ejecutar(idApuesta);
	}

}
