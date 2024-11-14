package com.tdd.ac2.service;

import com.tdd.ac2.dto.AlunoDTO;
import com.tdd.ac2.entity.Aluno;
import com.tdd.ac2.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTO> getAllAlunos() {
        return alunoRepository.findAll().stream()
                .map(aluno -> new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getMoedas()))
                .collect(Collectors.toList());
    }

    public AlunoDTO getAlunoById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getMoedas());
    }

    @Transactional
    public AlunoDTO createAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO.getNome());
        aluno = alunoRepository.save(aluno);
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getMoedas());
    }

    @Transactional
    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}