package com.tdd.ac2.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}