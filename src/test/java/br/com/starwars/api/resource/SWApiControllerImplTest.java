package br.com.starwars.api.resource;

import br.com.starwars.api.resource.dto.UpdateFilmRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class SWApiControllerImplTest {

    @Autowired
    MockMvc mvc;

    @Test
    void returnAllFilms() throws Exception {

        mvc.perform(
                        get("/starwars")
                                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("A New Hope")))
                .andExpect(jsonPath("$[1].title", is("The Empire Strikes Back")))
                .andExpect(jsonPath("$[2].title", is("Return of the Jedi")))
                .andExpect(jsonPath("$[3].title", is("The Phantom Menace")))
                .andExpect(jsonPath("$[4].title", is("Attack of the Clones")))
                .andExpect(jsonPath("$[5].title", is("Revenge of the Sith")));
    }

    @Test
    void returnFilmDetails() throws Exception {
        mvc.perform(
                        get("/starwars/detalhes?episodeId=1")
                                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("The Phantom Menace")))
                .andExpect(jsonPath("$.director", is("George Lucas")))
                .andExpect(jsonPath("$.producer", is("Rick McCallum")))
                .andExpect(jsonPath("$.releaseDate", is("1999-05-19")))
                .andExpect(jsonPath("$.created", is("2014-12-19T16:52:55.740Z")))
                .andExpect(jsonPath("$.edited", is("2014-12-20T10:54:07.216Z")))
                .andExpect(jsonPath("$.url", is("https://swapi.dev/api/films/4/")));
    }

    @Test
    void returnFilmDetail() throws Exception {
        mvc.perform(
                        get("/starwars/detalhar?episodeId=1")
                                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("The Phantom Menace")))
                .andExpect(jsonPath("$.director", is("George Lucas")))
                .andExpect(jsonPath("$.producer", is("Rick McCallum")))
                .andExpect(jsonPath("$.characters.[0].name", is("C-3PO")))
                .andExpect(jsonPath("$.characters.[1].name", is("R2-D2")))
                .andExpect(jsonPath("$.created", is("2014-12-19T16:52:55.740Z")))
                .andExpect(jsonPath("$.edited", is("2014-12-20T10:54:07.216Z")))
                .andExpect(jsonPath("$.url", is("https://swapi.dev/api/films/4/")));
    }

    @Test
    void updateFilmDescription() throws Exception {

        var request = UpdateFilmRequestDto
                .builder()
                .episodeId(1)
                .description("Filme Testado")
                .build();

        mvc.perform(
                        patch("/starwars/film")
                                .content(asJsonString(request))
                                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }

    public static String asJsonString(final Object obj) throws JsonProcessingException {

        return new ObjectMapper().writeValueAsString(obj);

    }


}
