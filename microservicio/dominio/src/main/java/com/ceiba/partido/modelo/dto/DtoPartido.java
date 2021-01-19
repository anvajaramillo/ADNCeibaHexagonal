package com.ceiba.partido.modelo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoPartido {
	
	private Long idPartido;
	private String pais1;
	private String pais2;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private int puntajePais1;
	private int puntajePais2;
	private Boolean tieneApuestas;

}
