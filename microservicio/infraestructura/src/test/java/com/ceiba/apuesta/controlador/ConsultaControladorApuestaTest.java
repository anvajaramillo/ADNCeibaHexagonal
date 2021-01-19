package com.ceiba.apuesta.controlador;

import static com.ceiba.partido.servicio.testdatabuilder.ComandoPartidoTestDataBuilder.unPartidoBuilder;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorApuesta.class)
public class ConsultaControladorApuestaTest {
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
    private MockMvc mocMvc;
	
	@Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/apuestas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        		.andExpect(jsonPath("$[0].nombre", is("Angie Jaramillo")))
        		.andExpect(jsonPath("$[0].id", is(1)));
    }
    
    @Test
    public void consultarApuesta() throws Exception {
        // arrange
    	Long id = 1L;
    	
        // act - assert
        mocMvc.perform(get("/apuestas/consultarApuesta/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        		.andExpect(jsonPath("$.nombre",is("Angie Jaramillo")))
        		.andExpect(jsonPath("$.id",is(1)));
    }
    
    @Test
    public void consultarResultados() throws Exception {
        // arrange
    	Long idPartido = 1L;
    	
        // act - assert
        mocMvc.perform(get("/apuestas/consultarResultados/{id}", idPartido)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").doesNotExist());
    }
    
    @Test
    public void consultarResultadosFinalizados() throws Exception {
        // arrange
    	Long idPartido = 1L;
    	LocalDateTime horaInicio = LocalDateTime.now();
	    String stringFechaFin = "3000-01-01 00:00:00";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime horaFin = LocalDateTime.parse(stringFechaFin, formatter);
        ComandoPartido partido = unPartidoBuilder()
        						.conIdPartido(idPartido)
        						.conHoraInicio(horaInicio)
        						.build(); 
    	
        // act - assert
        mocMvc.perform(put("/partidos/{id}",idPartido)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(partido)))
                .andExpect(status().isOk());
        
        partido = unPartidoBuilder()
        		.conIdPartido(idPartido)
				.conHoraFin(horaFin)
				.conPuntajePais1(1)
				.conPuntajePais2(2)
				.build(); 
        
        mocMvc.perform(put("/partidos/{id}",idPartido)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(partido)))
                .andExpect(status().isOk());
        
        mocMvc.perform(get("/apuestas/consultarResultados/{id}", idPartido)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("Angie Jaramillo")))
        		.andExpect(jsonPath("$[0].dineroGanado", is(100000)))
        		.andExpect(jsonPath("$[0].ganador", is(true)));
    }

}
