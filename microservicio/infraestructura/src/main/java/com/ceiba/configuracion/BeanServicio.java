package com.ceiba.configuracion;

import com.ceiba.partido.puerto.repositorio.RepositorioPartido;
import com.ceiba.partido.servicio.ServicioActualizarPartido;
import com.ceiba.partido.servicio.ServicioCrearPartido;
import com.ceiba.partido.servicio.ServicioEliminarPartido;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	
    @Bean
    public ServicioCrearPartido servicioCrearPartido(RepositorioPartido repositorioPartido) {
    	return new ServicioCrearPartido(repositorioPartido);
    }
    
    @Bean
    public ServicioActualizarPartido servicioActualizarPartido(RepositorioPartido repositorioPartido){
    	return new ServicioActualizarPartido(repositorioPartido);
    }
    
    @Bean
    public ServicioEliminarPartido servicioEliminarPartido(RepositorioPartido repositorioPartido){
    	return new ServicioEliminarPartido(repositorioPartido);
    }
    
}
