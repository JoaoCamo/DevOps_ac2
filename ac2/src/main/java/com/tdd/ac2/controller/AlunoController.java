package com.tdd.ac2.controller;

import com.tdd.ac2.dto.AlunoDTO;
import com.tdd.ac2.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoDTO> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public AlunoDTO getAlunoById(@PathVariable Long id) {
        return alunoService.getAlunoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}
