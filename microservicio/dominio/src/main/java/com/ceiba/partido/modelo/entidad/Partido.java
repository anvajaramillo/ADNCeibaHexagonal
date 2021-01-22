package com.ceiba.partido.modelo.entidad;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Setter
@Getter
public class Partido {
	
	private static final String PAIS1_OBLIGATORIO = "EL pa�s 1 es obligatorio";
	private static final String PAIS2_OBLIGATORIO = "El pa�s 2 es obligatorio";
	private static final String HORA_INICIO_OBLIGATORIO = "La hora inicio es obligatorio";
	
	private Long idPartido;
	private String pais1;
	private String pais2;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private int puntajePais1;
	private int puntajePais2;
	
	
	public Partido(Long idPartido, String pais1, String pais2, LocalDateTime horaInicio, LocalDateTime horaFin,int puntajePais1, int puntajePais2) {
		
		validarObligatorio(pais1,PAIS1_OBLIGATORIO);
		validarObligatorio(pais2,PAIS2_OBLIGATORIO);
		validarObligatorio(horaInicio,HORA_INICIO_OBLIGATORIO);
		
		this.idPartido = idPartido;
		this.pais1 = pais1;
		this.pais2 = pais2;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.puntajePais1 = puntajePais1;
		this.puntajePais2 = puntajePais2;
	}
	
	

}
