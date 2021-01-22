package com.ceiba.partido.servicio.test;

import static com.ceiba.partido.servicio.testdatabuilder.PartidoTestDataBuilder.unPartidoBuilder;
import static org.junit.Assert.*;

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
	public void validarPartidoSinIniciar(){
		
		int actualizar = 1;
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .build();
		
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(1L,"Colombia","Costa Rica",LocalDateTime.MAX,null,1,2,false));
		Mockito.when(repositorioPartido.finalizarPartido(partido)).thenReturn(0);
		Mockito.when(repositorioApuesta.finalizarApuestas(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(0);
		Mockito.when(repositorioPartido.actualizar(partido)).thenReturn(1);
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);
		
		assertEquals(actualizar,servicioActualizarPartido.ejecutar(partido));
	}
	
	@Test
	public void validarPartidoFinalizadoConApuestas(){
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(1L,"Colombia","Costa Rica",LocalDateTime.MIN,LocalDateTime.MIN,1,2,false));
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);
		
		BasePrueba.assertThrows(() -> servicioActualizarPartido.ejecutar(partido), ExcepcionValorInvalido.class,"NO SE PUEDE EDITAR EL PARTIDO PORQUE YA FINALIZÓ");
	}
	
	@Test
	public void validarPartidoFinalizadoSinApuestas(){
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(1L,"Colombia","Costa Rica",LocalDateTime.MIN,LocalDateTime.MIN,1,2,false));
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);
		
		BasePrueba.assertThrows(() -> servicioActualizarPartido.ejecutar(partido), ExcepcionValorInvalido.class,"NO SE PUEDE EDITAR EL PARTIDO PORQUE YA FINALIZÓ");
	}
	
	@Test
	public void validarFinalizarPartidosSinApuestas(){
		
		LocalDateTime horaFin = LocalDateTime.now();
		int puntajePais1 = 3;
		int puntajePais2 = 1;
		int actualizar = 1;
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .conHoraFin(horaFin)
						  .conPuntajePais1(puntajePais1)
						  .conPuntajePais2(puntajePais2)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(1L,"Colombia","Costa Rica",LocalDateTime.MIN,null,1,2,false));
		Mockito.when(repositorioPartido.finalizarPartido(partido)).thenReturn(1);
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);

		assertEquals(actualizar,servicioActualizarPartido.ejecutar(partido));

	}
	
	@Test
	public void validarFinalizarPartidosSinApuestasConFechaFinSinCumplir(){
		
		LocalDateTime horaFin = LocalDateTime.now();
		int puntajePais1 = 3;
		int puntajePais2 = 1;
		int actualizar = 1;
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .conHoraFin(horaFin)
						  .conPuntajePais1(puntajePais1)
						  .conPuntajePais2(puntajePais2)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(1L,"Colombia","Costa Rica",LocalDateTime.MIN,LocalDateTime.MAX,1,2,false));
		Mockito.when(repositorioPartido.finalizarPartido(partido)).thenReturn(1);
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);

		assertEquals(actualizar,servicioActualizarPartido.ejecutar(partido));

	}
	
	@Test
	public void validarFinalizarPartidosConApuestas(){
		
		LocalDateTime horaFin = LocalDateTime.now();
		int puntajePais1 = 3;
		int puntajePais2 = 1;
		int actualizar = 1;
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .conHoraFin(horaFin)
						  .conPuntajePais1(puntajePais1)
						  .conPuntajePais2(puntajePais2)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(1L,"Colombia","Costa Rica",LocalDateTime.MIN,null,1,2,true));
		Mockito.when(repositorioPartido.finalizarPartido(partido)).thenReturn(0);
		Mockito.when(repositorioApuesta.finalizarApuestas(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);

		assertEquals(actualizar,servicioActualizarPartido.ejecutar(partido));

	}
	
	@Test
	public void validarFinalizarPartidosConApuestaSinGanadores(){
		
		LocalDateTime horaFin = LocalDateTime.now();
		int puntajePais1 = 3;
		int puntajePais2 = 1;
		int actualizar = 1;
		
		Partido partido = unPartidoBuilder()
						  .conIdPartido(1L)
						  .conHoraFin(horaFin)
						  .conPuntajePais1(puntajePais1)
						  .conPuntajePais2(puntajePais2)
						  .build();
		RepositorioPartido repositorioPartido = Mockito.mock(RepositorioPartido.class);
		RepositorioApuesta repositorioApuesta = Mockito.mock(RepositorioApuesta.class);
		DaoPartido daoPartido = Mockito.mock(DaoPartido.class);
		Mockito.when(daoPartido.consultarPorId(Mockito.anyLong())).thenReturn(new DtoPartido(1L,"Colombia","Costa Rica",LocalDateTime.MIN,null,1,2,true));
		Mockito.when(repositorioPartido.finalizarPartido(partido)).thenReturn(0);
		Mockito.when(repositorioApuesta.consultarTotalGanadores(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(0);
		Mockito.when(repositorioApuesta.consultarTotalDineroPerderores(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(100);
		Mockito.when(repositorioApuesta.finalizarApuestas(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt())).thenReturn(1);
		ServicioActualizarPartido servicioActualizarPartido = new ServicioActualizarPartido(repositorioPartido,repositorioApuesta,daoPartido);

		assertEquals(actualizar,servicioActualizarPartido.ejecutar(partido));

	}

}
