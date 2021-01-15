package com.ceiba.partido.servicio;

import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioActualizarPartido {
	
	private static final String VALIDAR_PARTIDO_FINALIZADO = "NO SE PUEDE EDITAR EL PARTIDO PORQUE YA FINALIZÓ";
	
	private final RepositorioPartido repositorioPartido;
	private final RepositorioApuesta repositorioApuesta;
	
	public ServicioActualizarPartido(RepositorioPartido repositorioPartido, RepositorioApuesta repositorioApuesta) {
		this.repositorioPartido = repositorioPartido;
		this.repositorioApuesta = repositorioApuesta;
	}

	public void ejecutar(Partido partido){
		validarPartidoFinalizado(partido);
		if(Boolean.TRUE.equals(validarActualizacionCompleta(partido))){
			this.repositorioPartido.finalizarPartido(partido);
			this.repositorioApuesta.finalizarApuestas(partido.getIdPartido(),calcularExcedente(partido));
		}else{
			this.repositorioPartido.actualizar(partido);
		}
	}

	private void validarPartidoFinalizado(Partido partido){
		Boolean partidoFinalizado = this.repositorioPartido.validarPartidoFinalizado(partido.getIdPartido());
		if(Boolean.TRUE.equals(partidoFinalizado)){
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_FINALIZADO);
		}
	}
	
	private Boolean validarActualizacionCompleta(Partido partido){
		Boolean apuestaAsignada = this.repositorioPartido.validarApuestaAsignada(partido.getIdPartido());
		Boolean partidoIniciado = this.repositorioPartido.validarPartidoIniciado(partido.getIdPartido());
		return Boolean.TRUE.equals(apuestaAsignada) || Boolean.TRUE.equals(partidoIniciado);
	}
	
	private int consultarTotalGanadores(Partido partido){
		return this.repositorioApuesta.consultarTotalGanadores(partido.getIdPartido(), partido.getPuntajePais1(), partido.getPuntajePais2());
	}
	
	private int consultarTotalDineroPerdedores(Partido partido){
		return this.repositorioApuesta.consultarTotalDineroPerderores(partido.getIdPartido(), partido.getPuntajePais1(), partido.getPuntajePais2());
	}
	
	private int calcularExcedente(Partido partido){
		int totalGanadores = consultarTotalGanadores(partido);
		int totalDineroPerdedores = consultarTotalDineroPerdedores(partido);
		return (totalGanadores != 0) ? totalDineroPerdedores / totalGanadores : 0;
	}
	
}
