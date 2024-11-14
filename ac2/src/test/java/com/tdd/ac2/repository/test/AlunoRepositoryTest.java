package com.tdd.ac2.repository.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.repository.AlunoRepository;

@SpringBootTest
public class AlunoRepositoryTest {
	
	@Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testCreateAluno() {
        Aluno aluno = new Aluno("João");
        aluno = alunoRepository.save(aluno);

        assertNotNull(aluno.getId());
        assertEquals("João", aluno.getNome());
    }

    @Test
    public void testFindAlunoById() {
        Aluno aluno = new Aluno("Maria");
        aluno = alunoRepository.save(aluno);

        Aluno alunoEncontrado = alunoRepository.findById(aluno.getId()).orElse(null);

        assertNotNull(alunoEncontrado);
        assertEquals("Maria", alunoEncontrado.getNome());
    }

    @Test
    public void testDeleteAluno() {
        Aluno aluno = new Aluno("Carlos");
        aluno = alunoRepository.save(aluno);

        alunoRepository.delete(aluno);

        Aluno alunoDeletado = alunoRepository.findById(aluno.getId()).orElse(null);
        assertNull(alunoDeletado);
    }
}
