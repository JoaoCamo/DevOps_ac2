package com.tdd.ac2.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_a;
    
    @Embedded
    private AlunoEmail email;

    @OneToMany
    private List<Curso> cursos;
    
    private String nome;
    private int moedas;

    public Aluno(String nome) {
        this.nome = nome;
        this.cursos = new ArrayList<>();
        this.moedas = 0;
    }

    public void adicionarCurso(Curso curso) {
    	if(curso != null)
    		cursos.add(curso);
    }

    public void completarAula(Curso curso) {
    	getCurso(curso).completarAula();
    }

    public void adicionarNotaCurso(Curso curso, double nota) {
        getCurso(curso).adicionarNota(nota);
    }

    public boolean concluirCurso(Curso curso) {
        Curso cursoDoAluno = getCurso(curso);
        return verificarConclusao(cursoDoAluno);
    }

    private boolean verificarConclusao(Curso curso) {
        if (curso != null && curso.concluirCurso()) {
            ganharMoedas();
            return true;
        }
        return false;
    }

    private void ganharMoedas() {
        moedas += 3;
    }

    public void desbloquearCurso(Curso novoCurso) {
        if (moedas > 0) {
            moedas--;
            adicionarCurso(novoCurso);
        }
    }
    
    public Long getId()
    {
    	return id_a;
    }
    
    public void setId(long id)
    {
    	this.id_a = id;
    }
    
    public AlunoEmail getEmail()
    {
    	return this.email;
    }
    
    public void setEmail(AlunoEmail email)
    {
    	this.email = email;
    }

    public int getMoedas() {
        return moedas;
    }

    public List<Curso> getCursos() {
        return Collections.unmodifiableList(cursos);
    }
    
    public String getNome()
    {
    	return nome;
    }

    private Curso getCurso(Curso curso) {
        return cursos.stream()
                     .filter(c -> c.getNome().equals(curso.getNome()))
                     .findFirst()
                     .orElse(null);
    }
}