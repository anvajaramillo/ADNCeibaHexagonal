package com.ceiba.apuesta.servicio.test;

import static com.ceiba.apuesta.servicio.testdatabuilder.ApuestaTestDataBuilder.unaApuestaBuilder;
import static com.ceiba.partido.servicio.testdatabuilder.PartidoTestDataBuilder.unPartidoBuilder;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.apuesta.modelo.entidad.Apuesta;
import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.apuesta.servicio.ServicioEliminarApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;

public class ServicioEliminarApuestaTest {
	
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
		ServicioEliminarApuesta servicioEliminarApuesta = new ServicioEliminarApuesta(repositorioApuesta);
		
		BasePrueba.assertThrows(() -> servicioEliminarApuesta.ejecutar(apuesta.getId()), ExcepcionValorInvalido.class,"NO SE PUEDE ACTUALIZAR LA APUESTA PORQUE EL PARTIDO YA INICIÓ");
		
	}

}
