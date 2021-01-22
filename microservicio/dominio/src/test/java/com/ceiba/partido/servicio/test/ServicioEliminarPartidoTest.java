package com.ceiba.partido.servicio.test;

import static com.ceiba.partido.servicio.testdatabuilder.PartidoTestDataBuilder.unPartidoBuilder;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;
import com.ceiba.partido.servicio.ServicioEliminarPartido;

public class ServicioEliminarPartidoTest {
	
	@Test
	public void validarApuestaAsignadaTest(){
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		Mockito.when(repositorioPartido.validarApuestaAsignada(Mockito.anyLong())).thenReturn(true);
		ServicioEliminarPartido servicioEliminarPartido = new ServicioEliminarPartido(repositorioPartido);
		
		BasePrueba.assertThrows(() -> servicioEliminarPartido.ejecutar(partido.getIdPartido()), ExcepcionValorInvalido.class,"NO SE PUEDE ELIMINAR EL PARTIDO DEBIDO A QUE TIENE APUESTAS ASIGNADAS");
	}
	
	@Test
	public void validarEliminarPartidoTest(){
		
		int eliminar = 1;
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		Mockito.when(repositorioPartido.validarApuestaAsignada(Mockito.anyLong())).thenReturn(false);
		Mockito.when(repositorioPartido.eliminar(Mockito.anyLong())).thenReturn(1);
		ServicioEliminarPartido servicioEliminarPartido = new ServicioEliminarPartido(repositorioPartido);
		
		assertEquals(eliminar,servicioEliminarPartido.ejecutar(partido.getIdPartido()));
	}

}
