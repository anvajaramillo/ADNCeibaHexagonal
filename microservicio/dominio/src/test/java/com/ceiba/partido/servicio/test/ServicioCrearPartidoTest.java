package com.ceiba.partido.servicio.test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;
import com.ceiba.partido.servicio.ServicioCrearPartido;
import static com.ceiba.partido.servicio.testdatabuilder.PartidoTestDataBuilder.unPartidoBuilder;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPartidoTest {
	
	@Test
	public void validarPartidoExisteTest(){
		
		Partido partido = unPartidoBuilder().build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		Mockito.when(repositorioPartido.validarPartidoExiste(Mockito.anyString(),Mockito.anyString(),any(LocalDateTime.class))).thenReturn(true);
		ServicioCrearPartido servicioCrearPartido = new ServicioCrearPartido(repositorioPartido);
		
		BasePrueba.assertThrows(() -> servicioCrearPartido.ejecutar(partido), ExcepcionValorInvalido.class,"NO SE PUEDE CREAR EL PARTIDO DEBIDO A QUE YA EXISTE");
	}
	
	@Test
	public void validarCreacionPartidoTest(){
		Partido partido = unPartidoBuilder().build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		ServicioCrearPartido servicioCrearPartido = new ServicioCrearPartido(repositorioPartido);
		
		Long idPartido = servicioCrearPartido.ejecutar(partido);
		
		assertNotNull(idPartido);
	}

}
