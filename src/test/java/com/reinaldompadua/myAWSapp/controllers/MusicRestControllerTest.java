package com.reinaldompadua.myAWSapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reinaldompadua.myAWSapp.entities.Music;
import com.reinaldompadua.myAWSapp.entities.Style;
import com.reinaldompadua.myAWSapp.repositories.MusicRepository;
import com.reinaldompadua.myAWSapp.repositories.StyleRepository;
import com.reinaldompadua.myAWSapp.repositories.VersionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MusicRestController.class)
public class MusicRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusicRepository musicRepository;

    @MockBean
    private VersionRepository versionRepository;

    @MockBean
    private StyleRepository styleRepository;

    @BeforeEach //note this replaces the junit 4 @Before
    public void setUp() {

        Mockito.when(styleRepository.findById(Long.valueOf(1))).thenReturn(new Style(Long.valueOf(1),"Rock"));

        List<Music> musics = new ArrayList<Music>();
        musics.add(new Music("new AA","Black almbum"));
        Mockito.when(musicRepository.findAll()).thenReturn(musics);

        Mockito.when(musicRepository.findById(Long.valueOf(1))).thenReturn(new Music("new AA","Black almbum"));
    }

    @Test
    void whenValidInput_thenReturns200() throws Exception {

        mockMvc.perform(post("/musics?styleId=1")
                        .content(new ObjectMapper().writeValueAsString(new Music("DKC","2022")))
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/musics")
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("new AA"));

        mockMvc.perform(get("/musics/1")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("new AA"));
    }

}
