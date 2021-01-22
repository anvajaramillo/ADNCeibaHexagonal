package com.ceiba.apuesta.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.apuesta.consulta.ManejadorConsultarApuesta;
import com.ceiba.apuesta.consulta.ManejadorConsultarResultados;
import com.ceiba.apuesta.consulta.ManejadorListarApuesta;
import com.ceiba.apuesta.modelo.dto.DtoApuesta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/apuestas")
@Api(tags={"Controlador consulta apuestas"})
public class ConsultaControladorApuesta {
	
	private final ManejadorListarApuesta manejadorListarApuesta;
	private final ManejadorConsultarResultados manejadorConsultarResultados;
	private final ManejadorConsultarApuesta manejadorConsultarApuesta;

	public ConsultaControladorApuesta(ManejadorListarApuesta manejadorListarApuesta, ManejadorConsultarResultados manejadorConsultarResultados, ManejadorConsultarApuesta manejadorConsultarApuesta) {
		this.manejadorListarApuesta = manejadorListarApuesta;
		this.manejadorConsultarResultados = manejadorConsultarResultados;
		this.manejadorConsultarApuesta = manejadorConsultarApuesta;
	}

	@GetMapping
    @ApiOperation("Listar Apuestas")
    public List<DtoApuesta> listar() {
        return this.manejadorListarApuesta.ejecutar();
    }
	
	@GetMapping(value="/consultarResultados/{idPartido}")
    @ApiOperation("Consultar Resultados Apuestas")
    public List<DtoApuesta> consultarResultados(@PathVariable Long idPartido) {
		System.out.println("Consultar Resultados Apuestas");
        return this.manejadorConsultarResultados.ejecutar(idPartido);
    }
	
	@GetMapping(value="/consultarApuesta/{idApuesta}")
    @ApiOperation("Consultar Apuesta por Id")
    public DtoApuesta consultarApuesta(@PathVariable Long idApuesta) {
        return this.manejadorConsultarApuesta.ejecutar(idApuesta);
    }

}
