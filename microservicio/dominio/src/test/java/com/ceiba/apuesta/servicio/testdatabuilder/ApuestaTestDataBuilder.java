package com.ceiba.apuesta.servicio.testdatabuilder;

import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.partido.modelo.entidad.Partido;

public class ApuestaTestDataBuilder {

	private Long id;
	private int dinero;
	private String nombre;
	private String cedula;
	private int puntajePais1;
	private int puntajePais2;
	private boolean isGanador;
    private int dineroGanado;
    private Partido partido;
    
    public ApuestaTestDataBuilder() {
    	dinero = 100000;
    	nombre = "Angie Vanessa Jaramillo";
    	cedula = "1088310797";
    	puntajePais1 = 1;
    	puntajePais2 = 2;
    }
    
    public ApuestaTestDataBuilder conId(Long id) {
    	this.id = id;
    	return this;
    }
    
    public ApuestaTestDataBuilder conDinero(int dinero) {
    	this.dinero = dinero;
    	return this;
    }
    
    public ApuestaTestDataBuilder conNombre(String nombre) {
    	this.nombre = nombre;
    	return this;
    }
    
    public ApuestaTestDataBuilder conCedula(String cedula) {
    	this.cedula = cedula;
    	return this;
    }
    
    public ApuestaTestDataBuilder conPuntajePais1(int puntajePais1) {
    	this.puntajePais1 = puntajePais1;
    	return this;
    }
    
    public ApuestaTestDataBuilder conPuntajePais2(int puntajePais2) {
    	this.puntajePais2 = puntajePais2;
    	return this;
    }
    
    public ApuestaTestDataBuilder conIsGanador(boolean isGanador) {
    	this.isGanador = isGanador;
    	return this;
    }
    
    public ApuestaTestDataBuilder conDineroGanado(int dineroGanado) {
    	this.dineroGanado = dineroGanado;
    	return this;
    }
    
    public ApuestaTestDataBuilder conPartido(Partido partido) {
    	this.partido = partido;
    	return this;
    }
    
    public Apuesta build() {
    	return new Apuesta(id,dinero,nombre,cedula,puntajePais1,puntajePais2,isGanador,dineroGanado,partido);
    }
    
    public static ApuestaTestDataBuilder unaApuestaBuilder() {
    	return new ApuestaTestDataBuilder();
    }
    
}
