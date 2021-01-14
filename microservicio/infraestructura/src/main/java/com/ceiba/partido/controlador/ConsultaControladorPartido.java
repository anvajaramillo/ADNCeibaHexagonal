package com.ceiba.partido.controlador;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.partido.consulta.ManejadorListarPartidos;
import com.ceiba.partido.modelo.dto.DtoPartido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/partidos")
@Api(tags={"Controlador consulta partidos"})
public class ConsultaControladorPartido {
	
	private final ManejadorListarPartidos manejadorListarPartidos;

    public ConsultaControladorPartido(ManejadorListarPartidos manejadorListarPartidos) {
		this.manejadorListarPartidos = manejadorListarPartidos;
	}

	@GetMapping
    @ApiOperation("Listar Partidos")
    public List<DtoPartido> listar() {
        return this.manejadorListarPartidos.ejecutar();
    }

}
