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

}
