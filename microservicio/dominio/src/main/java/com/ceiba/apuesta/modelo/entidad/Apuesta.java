package com.ceiba.apuesta.modelo.entidad;

import com.ceiba.partido.modelo.entidad.Partido;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
public class Apuesta {
	
	private static final String DINERO_OBLIGATORIO = "El dinero es obligatorio";
	private static final String NOMBRE_OBLIGATORIO = "El nombre es obligatorio";
	private static final String CEDULA_OBLIGATORIO = "La cedula es obligatoria";
	private static final String PUNTAJE_PAIS1_OBLIGATORIO = "El puntaje pais1 es obligatorio";
	private static final String PUNTAJE_PAIS2_OBLIGATORIO = "El puntaje pais2 es obligatorio";
	private static final String PARTIDO_OBLIGATORIO = "El dinero es obligatorio";
	
	private Long id;
	private int dinero;
	private String nombre;
	private String cedula;
	private int puntajePais1;
	private int puntajePais2;
	private boolean isGanador;
    private int dineroGanado;
    private Partido partido;
    private Long idPartido;
    
	public Apuesta(Long id, int dinero, String nombre, String cedula, int puntajePais1, int puntajePais2, boolean isGanador, int dineroGanado, Partido partido) {
		
		validarObligatorio(dinero,DINERO_OBLIGATORIO);
		validarObligatorio(nombre,NOMBRE_OBLIGATORIO);
		validarObligatorio(cedula,CEDULA_OBLIGATORIO);
		validarObligatorio(puntajePais1,PUNTAJE_PAIS1_OBLIGATORIO);
		validarObligatorio(puntajePais2,PUNTAJE_PAIS2_OBLIGATORIO);
		validarObligatorio(partido,PARTIDO_OBLIGATORIO);
		
		this.id = id;
		this.dinero = dinero;
		this.nombre = nombre;
		this.cedula = cedula;
		this.puntajePais1 = puntajePais1;
		this.puntajePais2 = puntajePais2;
		this.isGanador = isGanador;
		this.dineroGanado = dineroGanado;
		this.partido = partido;
		this.idPartido = partido.getIdPartido();
	}
    
    

}
