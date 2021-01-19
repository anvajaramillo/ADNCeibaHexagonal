package com.ceiba.partido.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.ceiba.ApplicationMock;
import com.ceiba.partido.comando.ComandoPartido;
import static com.ceiba.partido.servicio.testdatabuilder.ComandoPartidoTestDataBuilder.unPartidoBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPartido.class)
public class ComandoControladorPartidoTest {
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    //nota: se ejecutan en orden alfabetico

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoPartido partido = unPartidoBuilder()
        						.build();

        // act - assert
        mocMvc.perform(post("/partidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(partido)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    public void actualizarAntesDeIniciar() throws Exception{
        // arrange
    	Long id = 2L;
        ComandoPartido partido = unPartidoBuilder()
        						.conPais1("Ecuador")
        						.build(); 
        
        // act - assert  
        mocMvc.perform(post("/partidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(partido)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
        
        partido = unPartidoBuilder()
        		.conIdPartido(id)
				.conPais1("Alemania")
				.conHoraFin(LocalDateTime.MAX)
				.conPuntajePais1(1)
				.conPuntajePais2(2)
				.build(); 
        
        mocMvc.perform(put("/partidos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(partido)))
                .andExpect(status().isOk());
     
        mocMvc.perform(get("/partidos/consultarPartido/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pais1",is("Alemania")))
                .andExpect(jsonPath("$.puntajePais1",is(0)))
                .andExpect(jsonPath("$.puntajePais2",is(0)))
                .andExpect(jsonPath("$.horaFin").doesNotExist());
       
    }
    
    @Test
    public void actualizarDespuesDeIniciar() throws Exception{
        // arrange
    	Long id = 2L;
	    LocalDateTime horaInicio = LocalDateTime.now();
	    String stringFechaFin = "3000-01-01 00:00:00";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime horaFin = LocalDateTime.parse(stringFechaFin, formatter);
        ComandoPartido partido = unPartidoBuilder()
        						.conIdPartido(id)
        						.conHoraInicio(horaInicio)
        						.build(); 
        
        // act - assert  
        mocMvc.perform(put("/partidos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(partido)))
                .andExpect(status().isOk());
        
        partido = unPartidoBuilder()
        		.conIdPartido(id)
				.conPais1("Uruguay")
				.conHoraInicio(horaInicio)
				.conHoraFin(horaFin)
				.conPuntajePais1(1)
				.conPuntajePais2(2)
				.build(); 
        
        mocMvc.perform(put("/partidos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(partido)))
                .andExpect(status().isOk());
     
        mocMvc.perform(get("/partidos/consultarPartido/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.puntajePais1",is(1)))
                .andExpect(jsonPath("$.puntajePais2",is(2)))
                .andExpect(jsonPath("$.horaFin",is(stringFechaFin)))
                .andExpect(jsonPath("$.pais1",is("Colombia")));
       
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/partidos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
        mocMvc.perform(get("/partidos/consultarPartido/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$.idPartido").doesNotExist());
    }

}
