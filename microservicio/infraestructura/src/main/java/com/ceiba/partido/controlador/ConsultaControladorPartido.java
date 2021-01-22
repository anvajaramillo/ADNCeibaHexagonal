package com.ceiba.partido.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.partido.consulta.ManejadorConsultarPartido;
import com.ceiba.partido.consulta.ManejadorListarPartidos;
import com.ceiba.partido.modelo.dto.DtoPartido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin({"http://localhost:4200"})
@RestController
@RequestMapping("/partidos")
@Api(tags={"Controlador consulta partidos"})
public class ConsultaControladorPartido {
	
	private final ManejadorListarPartidos manejadorListarPartidos;
	private final ManejadorConsultarPartido manejadorConsultarPartido;

    public ConsultaControladorPartido(ManejadorListarPartidos manejadorListarPartidos, ManejadorConsultarPartido manejadorConsultarPartido) {
		this.manejadorListarPartidos = manejadorListarPartidos;
		this.manejadorConsultarPartido = manejadorConsultarPartido;
	}

	@GetMapping
    @ApiOperation("Listar Partidos")
    public List<DtoPartido> listar() {
		System.out.println("Listar Partidos");
        return this.manejadorListarPartidos.ejecutar();
    }
	
	@GetMapping(value="/consultarPartido/{idPartido}")
	@ApiOperation("Consultar Partido por Id")
    public DtoPartido consultarPartido(@PathVariable Long idPartido) {
		System.out.println("Consultar Partido por Id");
        return this.manejadorConsultarPartido.ejecutar(idPartido);
    }

}
