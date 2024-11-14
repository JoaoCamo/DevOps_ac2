package com.tdd.ac2.entity.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.tdd.ac2.entity.Curso;
import com.tdd.ac2.entity.CursoID;

public class CursoTest {
	
	@Test
    public void testCursoCreation() {
        Curso curso = new Curso("Matemática", 10);
        assertNotNull(curso);
        assertEquals("Matemática", curso.getNome());
        assertFalse(curso.isConcluido());
    }

	@Test
	public void testSetCursoID() {
	    Curso curso = new Curso("Matemática", 10);
	    CursoID id = new CursoID("math");
	    curso.setCursoId(id);
	    assertEquals(id, curso.getCursoId());
	}

	@Test
	public void testCalcularMedia() {
	    Curso curso = new Curso("Matemática", 10);
	    curso.adicionarNota(8);
	    curso.adicionarNota(9);
	    assertEquals(8.5, curso.calcularMedia());
	}

	@Test
	public void testConcluirCursoComSucesso() {
	    Curso curso = new Curso("Matemática", 10);
	    for (int i = 0; i < 10; i++) curso.completarAula();
	    curso.adicionarNota(8);
	    curso.adicionarNota(7);
	    assertTrue(curso.concluirCurso());
	}

	@Test
	public void testNaoConcluirCurso() {
	    Curso curso = new Curso("Matemática", 10);
	    for (int i = 0; i < 10; i++) curso.completarAula();
	    curso.adicionarNota(5);
	    assertFalse(curso.concluirCurso());
	}

}
