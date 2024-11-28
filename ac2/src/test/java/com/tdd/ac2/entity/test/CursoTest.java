package com.tdd.ac2.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.tdd.ac2.entity.AlunoEmail;
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

	@Test
	public void testGetTotalAulas() {
	    Curso curso = new Curso("Matemática", 10);
	    assertEquals(10, curso.getTotalAulas());
	}
	
	@Test
	public void testGetId() {
	    Curso curso = new Curso("Matemática", 10);
	    curso.setId(123L);
	    assertEquals(123L, curso.getId());
	}

	@Test
	public void testSetId() {
	    Curso curso = new Curso("Matemática", 10);
	    curso.setId(456L);
	    assertEquals(456L, curso.getId());
	}
	
	@Test
    public void testAlunoEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> { new CursoID(null); }, "Id inválido");
    }
	
	@Test
	public void testEquals() {
		CursoID cursoId1 = new CursoID("1");
		CursoID cursoId2 = new CursoID("2");
		
		assertTrue(cursoId1.equals(cursoId1));
        assertFalse(cursoId1.equals(cursoId2));
        assertFalse(cursoId2.equals(new Object()));
	}
	
	@Test
	public void testCursoIDGetId()
	{
		CursoID cursoId1 = new CursoID("1");
		assertEquals("1", cursoId1.getId());
	}
	
	@Test
	public void testCursoIDGetHash()
	{
		CursoID cursoId1 = new CursoID("1");
		CursoID cursoId2 = new CursoID("1");
		assertEquals(cursoId1.hashCode(), cursoId2.hashCode());
	}
}
