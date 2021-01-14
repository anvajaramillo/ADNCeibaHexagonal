package com.ceiba.partido.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPartido {
	
	private Long idPartido;
	private String pais1;
	private String pais2;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private int puntajePais1;
	private int puntajePais2;

}
