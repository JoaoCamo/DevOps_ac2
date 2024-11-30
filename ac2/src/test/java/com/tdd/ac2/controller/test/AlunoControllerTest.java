package com.tdd.ac2.controller.test;

import com.tdd.ac2.controller.AlunoController;
import com.tdd.ac2.dto.AlunoDTO;
import com.tdd.ac2.service.AlunoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService;

    @Test
    public void testGetAllAlunos() throws Exception {
        AlunoDTO mockAluno = new AlunoDTO();
        mockAluno.setId(1L);
        mockAluno.setNome("Aluno Teste");
        mockAluno.setEmail("aluno@teste.com");

        List<AlunoDTO> mockAlunos = List.of(mockAluno);
        Mockito.when(alunoService.getAllAlunos()).thenReturn(mockAlunos);

        mockMvc.perform(MockMvcRequestBuilders.get("/alunos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Aluno Teste"))
                .andExpect(jsonPath("$[0].email").value("aluno@teste.com"));
    }

    @Test
    public void testGetAlunoById() throws Exception {
        AlunoDTO mockAluno = new AlunoDTO();
        mockAluno.setId(1L);
        mockAluno.setNome("Aluno Teste");
        mockAluno.setEmail("aluno@teste.com");

        Mockito.when(alunoService.getAlunoById(1L)).thenReturn(mockAluno);

        mockMvc.perform(MockMvcRequestBuilders.get("/alunos/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Aluno Teste"))
                .andExpect(jsonPath("$.email").value("aluno@teste.com"));
    }
    
    @Test
    public void testGetAlunoByIdFullConstructor() throws Exception {
    	Long id = 1L;
        String nome = "Aluno Teste";
        String email = "aluno@teste.com";

        AlunoDTO mockAluno = new AlunoDTO(id, nome, email);

        Mockito.when(alunoService.getAlunoById(1L)).thenReturn(mockAluno);

        mockMvc.perform(MockMvcRequestBuilders.get("/alunos/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Aluno Teste"))
                .andExpect(jsonPath("$.email").value("aluno@teste.com"));
    }

    @Test
    public void testDeleteAluno() throws Exception {
        Mockito.doNothing().when(alunoService).deleteAluno(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/alunos/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}