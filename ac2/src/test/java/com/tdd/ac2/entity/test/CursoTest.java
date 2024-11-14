package com.tdd.ac2.entity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tdd.ac2.entity.Curso;

@SpringBootTest
@ActiveProfiles("test")
public class CursoTest {
	
	@Test
    public void testCursoCreation() {
        Curso curso = new Curso("Matemática", 10);
        assertNotNull(curso);
        assertEquals("Matemática", curso.getNome());
        assertFalse(curso.isConcluido());
    }

    @Test
    public void testConcluirCurso() {
        Curso curso = new Curso("Matemática", 10);
        for (int i = 0; i < 10; i++) {
            curso.completarAula();
        }
        curso.adicionarNota(8.0);
        assertTrue(curso.concluirCurso());
    }
}
