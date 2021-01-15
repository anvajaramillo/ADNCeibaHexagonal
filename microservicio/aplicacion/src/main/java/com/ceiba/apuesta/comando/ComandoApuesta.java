package com.ceiba.apuesta.comando;

import com.ceiba.partido.comando.ComandoPartido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoApuesta {
	
	private Long idApuesta;
	private int dinero;
	private String nombre;
	private String cedula;
	private int puntajePais1;
	private int puntajePais2;
	private boolean isGanador;
    private int dineroGanado;
    private ComandoPartido partido;

}
