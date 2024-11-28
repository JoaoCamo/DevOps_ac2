package com.tdd.ac2.service;

import com.tdd.ac2.dto.AlunoDTO;
import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTO> getAllAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                     .map(AlunoDTO::fromEntity)
                     .collect(Collectors.toList());
    }

    public AlunoDTO getAlunoById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return AlunoDTO.fromEntity(aluno);
    }

    public AlunoDTO updateAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.setNome(alunoDTO.getNome());
        alunoRepository.save(aluno);
        return AlunoDTO.fromEntity(aluno);
    }

    public void deleteAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                                     .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        alunoRepository.delete(aluno);
    }
}