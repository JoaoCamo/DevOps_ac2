package com.tdd.ac2.entity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.entity.Curso;

@SpringBootTest
@ActiveProfiles("test")
public class AlunoTest {

    @Test
    public void testAlunoCreation() {
        Aluno aluno = new Aluno("João");
        assertNotNull(aluno);
        assertEquals("João", aluno.getNome());
        assertTrue(aluno.getCursos().isEmpty());
        assertEquals(0, aluno.getMoedas());
    }

    @Test
    public void testAdicionarCurso() {
        Aluno aluno = new Aluno("João");
        Curso curso = new Curso("Matemática", 10);
        aluno.adicionarCurso(curso);
        assertTrue(aluno.getCursos().contains(curso));
    }

    @Test
    public void testConcluirCurso() {
        Aluno aluno = new Aluno("João");
        Curso curso = new Curso("Matemática", 10);
        aluno.adicionarCurso(curso);
        for (int i = 0; i < 10; i++) {
            aluno.completarAula(curso);
        }
        aluno.adicionarNotaCurso(curso, 8.0);
        assertTrue(aluno.concluirCurso(curso));
        assertTrue(curso.isConcluido());
    }

    @Test
    public void testDesbloquearCurso() {
        Aluno aluno = new Aluno("João");
        Curso curso = new Curso("Matemática", 10);
        aluno.desbloquearCurso(curso);
        assertTrue(aluno.getCursos().contains(curso));
    }
}