package com.bancovid.BancoVid;

import com.bancovid.BancoVid.controller.ClienteController;
import com.bancovid.BancoVid.domain.ClienteCivil;
import com.bancovid.BancoVid.dto.ClienteCivilDTO;
import com.bancovid.BancoVid.repository.ClienteCivilRepository;
import com.bancovid.BancoVid.rest.v1.ClienteCivilRest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BancoVidApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteCivilRest mockRepository;

	@Test
	public void salva_cliente_civil_sem_dados_erro_400() throws Exception {

		String bookInJson = "{\"cpf\":\"\"," +
				"\"dataNascimento\":\"\"," +
				"\"email\":\"\"," +
				"\"nome\":\"\"}";

		mockMvc.perform(post("/v1/cliente_civil/cliente")
				.content(bookInJson)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status", is("BAD_REQUEST")))
				.andExpect(jsonPath("$.errors").isArray())
				.andExpect(jsonPath("$.errors", hasSize(5)))
				.andExpect(jsonPath("$.errors", hasItem("cpf: Nome é um campo obrigatório")))
				.andExpect(jsonPath("$.errors", hasItem("cpf: O valor não condiz com um cpf válido")))
				.andExpect(jsonPath("$.errors", hasItem("email: Nome é um campo obrigatório")))
				.andExpect(jsonPath("$.errors", hasItem("nome: Nome é um campo obrigatório")))
				.andExpect(jsonPath("$.errors", hasItem("dataNascimento: Nome é um campo obrigatório")));

		verify(mockRepository, times(0)).create(any(ClienteCivilDTO.class));

	}

}
