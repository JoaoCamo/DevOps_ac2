package com.tdd.ac2.service.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tdd.ac2.dto.AlunoDTO;
import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.entity.AlunoEmail;
import com.tdd.ac2.repository.AlunoRepository;
import com.tdd.ac2.service.AlunoService;

class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testGetAlunoById() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Aluno 1");
        aluno.setEmail(new AlunoEmail("aluno1@example.com"));

        when(alunoRepository.findById(1L)).thenReturn(java.util.Optional.of(aluno));

        AlunoDTO resultado = alunoService.getAlunoById(1L);

        assertEquals("Aluno 1", resultado.getNome());
        assertEquals("aluno1@example.com", resultado.getEmail());
    }


    @Test
    void testGetAllAlunos() {
        Aluno aluno1 = new Aluno();
        aluno1.setId(1L);
        aluno1.setNome("Aluno 1");
        aluno1.setEmail(new AlunoEmail("aluno1@example.com"));

        Aluno aluno2 = new Aluno();
        aluno2.setId(2L);
        aluno2.setNome("Aluno 2");
        aluno2.setEmail(new AlunoEmail("aluno2@example.com"));

        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));

        List<AlunoDTO> alunos = alunoService.getAllAlunos();

        assertEquals(2, alunos.size());
        assertEquals("Aluno 1", alunos.get(0).getNome());
        assertEquals("aluno1@example.com", alunos.get(0).getEmail());
    }
    
    @Test
    void testGetAlunoByIdAlunoNaoEncontrado() {
        when(alunoRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> alunoService.getAlunoById(1L));
    }

    @Test
    void testUpdateAluno() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Aluno 1");
        aluno.setEmail(new AlunoEmail("aluno1@example.com"));

        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Aluno Atualizado");

        when(alunoRepository.findById(1L)).thenReturn(java.util.Optional.of(aluno));

        AlunoDTO updatedAlunoDTO = alunoService.updateAluno(1L, alunoDTO);

        assertEquals("Aluno Atualizado", updatedAlunoDTO.getNome());
    }

    @Test
    void testUpdateAlunoAlunoNaoEncontrado() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Aluno Atualizado");

        when(alunoRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> alunoService.updateAluno(1L, alunoDTO));
    }

    @Test
    void testDeleteAluno() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Aluno 1");
        aluno.setEmail(new AlunoEmail("aluno1@example.com"));

        when(alunoRepository.findById(1L)).thenReturn(java.util.Optional.of(aluno));

        alunoService.deleteAluno(1L);

        verify(alunoRepository).delete(aluno);
    }

    @Test
    void testDeleteAlunoAlunoNaoEncontrado() {
        when(alunoRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> alunoService.deleteAluno(1L));
    }
}