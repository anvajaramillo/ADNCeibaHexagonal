package com.ceiba.apuesta.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.ceiba.ApplicationMock;
import com.ceiba.apuesta.comando.ComandoApuesta;
import com.ceiba.partido.comando.ComandoPartido;

import static com.ceiba.apuesta.servicio.testdatabuilder.ComandoApuestaTestBuilder.unaApuestaBuilder;
import static com.ceiba.partido.servicio.testdatabuilder.ComandoPartidoTestDataBuilder.unPartidoBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorApuesta.class)
public class ComandoControladorApuestaTest {
	
//	@Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private MockMvc mocMvc;
//    
//    @Test
//    public void crear() throws Exception{
//    	// arrange
//    	ComandoPartido partido = unPartidoBuilder()
//    							.conIdPartido(1L)
//								.build();
//    	ComandoApuesta apuesta = unaApuestaBuilder()
//    							.conCedula("123852")
//    							.conPartido(partido)
//								.build();
//    	
//    	// act - assert
//    	mocMvc.perform(post("/apuestas")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(apuesta)))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{'valor': 2}"));
//    }
//    
//    @Test
//    public void actualizar() throws Exception{
//    	// arrange
//    	Long idApuesta = 1L;
//    	ComandoPartido partido = unPartidoBuilder()
//    							.conIdPartido(1L)
//								.build();
//    	ComandoApuesta apuesta = unaApuestaBuilder()
//    							.conId(idApuesta)
//    							.conPartido(partido)
//    							.conPuntajePais1(2)
//    							.conDinero(200000)
//								.build();
//    	
//    	// act - assert
//    	mocMvc.perform(put("/apuestas/{id}",idApuesta)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(apuesta)))
//                .andExpect(status().isOk());
//    	
//    	 mocMvc.perform(get("/apuestas/consultarApuesta/{id}", idApuesta)
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.puntajePais1",is(2)))
//                 .andExpect(jsonPath("$.dinero",is(200000)));
//    	
//    }
//    
//    @Test
//    public void eliminar() throws Exception{
//    	// arrange
//    	Long id = 2L;
//    	
//    	// act - assert
//    	mocMvc.perform(delete("/apuestas/{id}",id)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//        
//        mocMvc.perform(get("/apuestas/consultarApuesta/{id}", id)
//                .contentType(MediaType.APPLICATION_JSON))
//        		.andExpect(status().isOk())
//        		.andExpect(jsonPath("$.idApuesta").doesNotExist());
//    	
//    }
    
}
