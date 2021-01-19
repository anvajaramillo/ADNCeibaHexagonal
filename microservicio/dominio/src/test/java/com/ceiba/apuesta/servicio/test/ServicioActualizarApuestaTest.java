package com.ceiba.apuesta.servicio.test;

import static com.ceiba.apuesta.servicio.testdatabuilder.ApuestaTestDataBuilder.unaApuestaBuilder;
import static com.ceiba.partido.servicio.testdatabuilder.PartidoTestDataBuilder.unPartidoBuilder;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.apuesta.servicio.ServicioActualizarApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;

public class ServicioActualizarApuestaTest {
	
	@Test
	public void validarPartidoIniciadoTest(){
		
		Partido partido = unPartidoBuilder()
						.conIdPartido(1L)
						.conHoraInicio(LocalDateTime.now())
						.build();
		Apuesta apuesta = unaApuestaBuilder()
						.conId(1L)
						.conPartido(partido)
						.build();
		
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		
		Mockito.when(repositorioApuesta.validarPartidoIniciado(Mockito.anyLong())).thenReturn(true);
		ServicioActualizarApuesta servicioActualizarApuesta = new ServicioActualizarApuesta(repositorioApuesta);
		
		BasePrueba.assertThrows(() -> servicioActualizarApuesta.ejecutar(apuesta), ExcepcionValorInvalido.class,"NO SE PUEDE ACTUALIZAR LA APUESTA PORQUE EL PARTIDO YA INICIÓ");
		
	}
	
	@Test
	public void validarMismaPersonaTest(){
		
		Partido partido = unPartidoBuilder()
				.conIdPartido(1L)
				.conHoraInicio(LocalDateTime.now())
				.build();
		Apuesta apuesta = unaApuestaBuilder()
						.conId(1L)
						.conPartido(partido)
						.build();
				
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		
		Mockito.when(repositorioApuesta.validarApuestaParaLaMismaPersona(Mockito.anyLong(),Mockito.anyString())).thenReturn(2);
		ServicioActualizarApuesta servicioActualizarApuesta = new ServicioActualizarApuesta(repositorioApuesta);
		
		BasePrueba.assertThrows(() -> servicioActualizarApuesta.ejecutar(apuesta), ExcepcionValorInvalido.class,"LA PERSONA YA TIENE CREADA UNA APUESTA PARA ESTE PARTIDO");
		
	}

}
