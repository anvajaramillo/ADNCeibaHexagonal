package com.ceiba.partido.servicio.testdatabuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.ceiba.partido.modelo.entidad.Partido;

public class PartidoTestDataBuilder {
	
	private Long idPartido;
	private String pais1;
	private String pais2;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private int puntajePais1;
	private int puntajePais2;
	
	public PartidoTestDataBuilder(){
		pais1 = "Colombia";
	    pais2 = "Costa Rica";
	    String fecha = "2021-01-16 07:00:00";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
	    horaInicio = dateTime;
	}
	
	public PartidoTestDataBuilder conIdPartido(Long idPartido) {
		this.idPartido = idPartido;
		return this;
	}
	
	public PartidoTestDataBuilder conPais1(String pais1) {
		this.pais1 = pais1;
		return this;
	}
	
	public PartidoTestDataBuilder conPais2(String pais2) {
		this.pais2 = pais2;
		return this;
	}
	
	public PartidoTestDataBuilder conHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
		return this;
	}
	
	public PartidoTestDataBuilder conHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
		return this;
	}
	
	public PartidoTestDataBuilder conPuntajePais1(int puntajePais1) {
		this.puntajePais1 = puntajePais1;
		return this;
	}
	
	public PartidoTestDataBuilder conPuntajePais2(int puntajePais2) {
		this.puntajePais2 = puntajePais2;
		return this;
	}
	
	public Partido build() {
		return new Partido(idPartido,pais1,pais2,horaInicio,horaFin,puntajePais1,puntajePais2);
	}
	
	public static PartidoTestDataBuilder unPartidoBuilder() {
		return new PartidoTestDataBuilder();
	}

}
