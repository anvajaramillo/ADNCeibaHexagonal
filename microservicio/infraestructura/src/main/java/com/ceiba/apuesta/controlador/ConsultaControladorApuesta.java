package com.ceiba.apuesta.controlador;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.apuesta.consulta.ManejadorConsultarResultados;
import com.ceiba.apuesta.consulta.ManejadorListarApuesta;
import com.ceiba.apuesta.modelo.dto.DtoApuesta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apuestas")
@Api(tags={"Controlador consulta apuestas"})
public class ConsultaControladorApuesta {
	
	private final ManejadorListarApuesta manejadorListarApuesta;
	private final ManejadorConsultarResultados manejadorConsultarResultados;

	public ConsultaControladorApuesta(ManejadorListarApuesta manejadorListarApuesta, ManejadorConsultarResultados manejadorConsultarResultados) {
		this.manejadorListarApuesta = manejadorListarApuesta;
		this.manejadorConsultarResultados = manejadorConsultarResultados;
	}

	@GetMapping
    @ApiOperation("Listar Apuestas")
    public List<DtoApuesta> listar() {
        return this.manejadorListarApuesta.ejecutar();
    }
	
	@GetMapping(value="/{idPartido}")
    @ApiOperation("Consultar Resultados Apuestas")
    public List<DtoApuesta> consultarResultados(@PathVariable Long idPartido) {
        return this.manejadorConsultarResultados.ejecutar(idPartido);
    }

}
