package com.ceiba.apuesta.modelo.dto;

import com.ceiba.partido.modelo.dto.DtoPartido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoApuesta {

	private Long id;
	private int dinero;
	private String nombre;
	private String cedula;
	private int puntajePais1;
	private int puntajePais2;
	private boolean isGanador;
    private int dineroGanado;
    private DtoPartido partido;
    
}
