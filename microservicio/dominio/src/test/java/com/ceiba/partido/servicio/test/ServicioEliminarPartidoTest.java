package com.ceiba.partido.servicio.test;

import static com.ceiba.partido.servicio.testdatabuilder.PartidoTestDataBuilder.unPartidoBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;
import com.ceiba.partido.servicio.ServicioEliminarPartido;

public class ServicioEliminarPartidoTest {
	
	@Test
	public void validarApuestaAsignada(){
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		Mockito.when(repositorioPartido.validarApuestaAsignada(Mockito.anyLong())).thenReturn(true);
		ServicioEliminarPartido servicioEliminarPartido = new ServicioEliminarPartido(repositorioPartido);
		
		BasePrueba.assertThrows(() -> servicioEliminarPartido.ejecutar(partido.getIdPartido()), ExcepcionValorInvalido.class,"NO SE PUEDE ELIMINAR EL PARTIDO DEBIDO A QUE TIENE APUESTAS ASIGNADAS");
	}

}
