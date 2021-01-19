package com.ceiba.apuesta.servicio.testdatabuilder;

import com.ceiba.apuesta.comando.ComandoApuesta;
import com.ceiba.partido.comando.ComandoPartido;

public class ComandoApuestaTestBuilder {

	private Long id;
	private int dinero;
	private String nombre;
	private String cedula;
	private int puntajePais1;
	private int puntajePais2;
	private boolean isGanador;
    private int dineroGanado;
    private ComandoPartido partido;
    
    public ComandoApuestaTestBuilder() {
    	dinero = 100000;
    	nombre = "Angie Vanessa Jaramillo";
    	cedula = "1088310797";
    	puntajePais1 = 1;
    	puntajePais2 = 2;
    }
    
    public ComandoApuestaTestBuilder conId(Long id) {
    	this.id = id;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conDinero(int dinero) {
    	this.dinero = dinero;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conNombre(String nombre) {
    	this.nombre = nombre;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conCedula(String cedula) {
    	this.cedula = cedula;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conPuntajePais1(int puntajePais1) {
    	this.puntajePais1 = puntajePais1;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conPuntajePais2(int puntajePais2) {
    	this.puntajePais2 = puntajePais2;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conIsGanador(boolean isGanador) {
    	this.isGanador = isGanador;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conDineroGanado(int dineroGanado) {
    	this.dineroGanado = dineroGanado;
    	return this;
    }
    
    public ComandoApuestaTestBuilder conPartido(ComandoPartido partido) {
    	this.partido = partido;
    	return this;
    }
    
    public ComandoApuesta build() {
    	return new ComandoApuesta(id,dinero,nombre,cedula,puntajePais1,puntajePais2,isGanador,dineroGanado,partido);
    }
    
    public static ComandoApuestaTestBuilder unaApuestaBuilder() {
    	return new ComandoApuestaTestBuilder();
    }
	
}
