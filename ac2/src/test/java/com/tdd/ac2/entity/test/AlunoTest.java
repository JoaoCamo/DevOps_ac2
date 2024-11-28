package com.tdd.ac2.entity.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.entity.AlunoEmail;
import com.tdd.ac2.entity.Curso;

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
    public void testSetEmail() {
        Aluno aluno = new Aluno("João");
        AlunoEmail email = new AlunoEmail("joao@email.com");
        aluno.setEmail(email);
        assertEquals(email, aluno.getEmail());
    }
    
    @Test
    public void testAdicionarCurso() {
        Aluno aluno = new Aluno("João");
        Curso curso = new Curso("Matemática", 10);
        aluno.adicionarCurso(curso);
        assertEquals(1, aluno.getCursos().size());
        assertEquals("Matemática", aluno.getCursos().get(0).getNome());
    }

    @Test
    public void testConcluirCurso() {
        Aluno aluno = new Aluno("João");
        Curso curso = new Curso("Matemática", 10);
        aluno.adicionarCurso(curso);
        
        for (int i = 0; i < 10; i++) aluno.completarAula(curso);
        aluno.adicionarNotaCurso(curso, 8);
        aluno.adicionarNotaCurso(curso, 9);
        assertTrue(aluno.concluirCurso(curso));
    }

    @Test
    public void testDesbloquearCurso() {
        Aluno aluno = new Aluno("João");
        Curso curso1 = new Curso("Matemática", 10);
        Curso curso2 = new Curso("Física", 10);
        
        aluno.adicionarCurso(curso1);
        
        for (int i = 0; i < 10; i++) {
            aluno.completarAula(curso1);
        }
        
        aluno.adicionarNotaCurso(curso1, 7.0);
        aluno.concluirCurso(curso1);
        
        aluno.desbloquearCurso(curso2);
        
        assertEquals(2, aluno.getCursos().size());
    }
    
    @Test
    public void testVerificarConclusaoComCursoNulo() {
        Aluno aluno = new Aluno("João");
        Curso curso = new Curso("Matemática", 10);
        boolean resultado = aluno.concluirCurso(curso);
        assertFalse(resultado);
    }
    
    @Test
    public void testAlunoEmailConstrutorProtegido() {
        AlunoEmail alunoEmail = new AlunoEmail("test@example.com") {};
        assertNotNull(alunoEmail);
    }
    
    @Test
    public void testAlunoEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> { new AlunoEmail("invalid-email"); }, "Email inválido");
    }

    @Test
    public void testEquals() {
        AlunoEmail email1 = new AlunoEmail("test@example.com");
        AlunoEmail email2 = new AlunoEmail("test@example.com");
        AlunoEmail email3 = new AlunoEmail("different@example.com");
        
        assertTrue(email1.equals(email2));
        assertFalse(email1.equals(email3));
        assertFalse(email1.equals(new Object()));
    }

    @Test
    public void testHashCode() {
        AlunoEmail email1 = new AlunoEmail("test@example.com");
        AlunoEmail email2 = new AlunoEmail("test@example.com");
        
        assertEquals(email1.hashCode(), email2.hashCode());
    }

}