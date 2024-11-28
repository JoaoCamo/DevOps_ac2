package com.tdd.ac2.repository.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.repository.AlunoRepository;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AlunoRepositoryJPATest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testSaveAndFindAluno() {
        Aluno aluno = new Aluno("João");

        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());

        Aluno retrievedAluno = alunoRepository.findById(savedAluno.getId()).orElse(null);
        assertThat(retrievedAluno).isNotNull();
        assertThat(retrievedAluno.getNome()).isEqualTo("João");
    }
}