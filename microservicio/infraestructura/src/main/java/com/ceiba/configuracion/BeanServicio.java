package com.ceiba.configuracion;

import com.ceiba.apuesta.puerto.repositorio.RepositorioApuesta;
import com.ceiba.apuesta.servicio.ServicioActualizarApuesta;
import com.ceiba.apuesta.servicio.ServicioCrearApuesta;
import com.ceiba.apuesta.servicio.ServicioEliminarApuesta;
import com.ceiba.partido.puerto.dao.DaoPartido;
import com.ceiba.partido.puerto.repositorio.RepositorioPartido;
import com.ceiba.partido.servicio.ServicioActualizarPartido;
import com.ceiba.partido.servicio.ServicioCrearPartido;
import com.ceiba.partido.servicio.ServicioEliminarPartido;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
	
    @Bean
    public ServicioCrearPartido servicioCrearPartido(RepositorioPartido repositorioPartido) {
    	return new ServicioCrearPartido(repositorioPartido);
    }
    
    @Bean
    public ServicioActualizarPartido servicioActualizarPartido(RepositorioPartido repositorioPartido, RepositorioApuesta repositorioApuesta, DaoPartido daoPartido){
    	return new ServicioActualizarPartido(repositorioPartido, repositorioApuesta, daoPartido);
    }
    
    @Bean
    public ServicioEliminarPartido servicioEliminarPartido(RepositorioPartido repositorioPartido){
    	return new ServicioEliminarPartido(repositorioPartido);
    }
    
    @Bean
    public ServicioCrearApuesta servicioCrearApuesta(RepositorioApuesta repositorioApuesta) {
    	return new ServicioCrearApuesta(repositorioApuesta);
    }
    
    @Bean
    public ServicioActualizarApuesta servicioActualizarApuesta(RepositorioApuesta repositorioApuesta){
    	return new ServicioActualizarApuesta(repositorioApuesta);
    }
    
    @Bean
    public ServicioEliminarApuesta servicioEliminarApuesta(RepositorioApuesta repositorioApuesta){
    	return new ServicioEliminarApuesta(repositorioApuesta);
    }
    
}
