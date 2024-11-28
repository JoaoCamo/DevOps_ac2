package com.tdd.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tdd.ac2.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> { }