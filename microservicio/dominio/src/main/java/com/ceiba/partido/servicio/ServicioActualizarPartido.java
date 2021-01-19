package com.ceiba.partido.servicio;

import java.time.LocalDateTime;

import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.dto.DtoPartido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.dao.DaoPartido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;

public class ServicioActualizarPartido {
	
	private static final String VALIDAR_PARTIDO_FINALIZADO = "NO SE PUEDE EDITAR EL PARTIDO PORQUE YA FINALIZÓ";
	
	private final RepositorioPartido repositorioPartido;
	private final RepositorioApuesta repositorioApuesta;
	private final DaoPartido daoPartido;
	
	public ServicioActualizarPartido(RepositorioPartido repositorioPartido, RepositorioApuesta repositorioApuesta, DaoPartido daoPartido) {
		this.repositorioPartido = repositorioPartido;
		this.repositorioApuesta = repositorioApuesta;
		this.daoPartido = daoPartido;
	}

	public void ejecutar(Partido partido){
		DtoPartido partidoAntiguo = this.daoPartido.consultarPorId(partido.getIdPartido());
		if(Boolean.TRUE.equals(partidoAntiguo.getTieneApuestas()) || Boolean.TRUE.equals(validarPartidoIniciado(partidoAntiguo))){
			validarPartidoFinalizado(partidoAntiguo);
			this.repositorioPartido.finalizarPartido(partido);
			if(Boolean.TRUE.equals(partidoAntiguo.getTieneApuestas())){
				this.repositorioApuesta.finalizarApuestas(partido.getIdPartido(),partido.getPuntajePais1(),partido.getPuntajePais2(),calcularExcedente(partido));
			}
		}else{
			this.repositorioPartido.actualizar(partido);
		}
	}

	private void validarPartidoFinalizado(DtoPartido partido){
		if(partido.getHoraFin() != null && LocalDateTime.now().compareTo(partido.getHoraFin()) >= 0){
			throw new ExcepcionValorInvalido(VALIDAR_PARTIDO_FINALIZADO);
		}
	}
	
	private Boolean validarPartidoIniciado(DtoPartido partido){
		return (LocalDateTime.now().compareTo(partido.getHoraInicio()) >= 0);
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
