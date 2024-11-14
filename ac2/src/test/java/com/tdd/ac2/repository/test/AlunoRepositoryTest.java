package com.tdd.ac2.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.repository.AlunoRepository;

@ActiveProfiles("test")
@SpringBootTest
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testSaveAndFindAluno() {
        Aluno aluno = new Aluno("Maria");

        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());

        Aluno retrievedAluno = alunoRepository.findById(savedAluno.getId()).orElse(null);
        assertThat(retrievedAluno).isNotNull();
        assertThat(retrievedAluno.getNome()).isEqualTo("Maria");
    }
}
