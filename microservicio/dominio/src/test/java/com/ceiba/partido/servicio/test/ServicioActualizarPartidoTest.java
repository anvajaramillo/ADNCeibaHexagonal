package com.ceiba.partido.servicio.test;

import static com.ceiba.partido.servicio.testdatabuilder.PartidoTestDataBuilder.unPartidoBuilder;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;
import com.ceiba.partido.modelo.dto.DtoPartido;
import com.ceiba.partido.modelo.entidad.Partido;
import com.ceiba.partido.puerto.dao.DaoPartido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;
import com.ceiba.BasePrueba;
import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.partido.servicio.ServicioActualizarPartido;

public class ServicioActualizarPartidoTest {
	
	@Test
	public void validarPartidoFinalizado(){
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(2L,"colombia","nicaragua",LocalDateTime.MIN,LocalDateTime.MIN,1,2,true));
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);
		
		BasePrueba.assertThrows(() -> servicioActualizarPartido.ejecutar(partido), ExcepcionValorInvalido.class,"NO SE PUEDE EDITAR EL PARTIDO PORQUE YA FINALIZÓ");
	}

}
