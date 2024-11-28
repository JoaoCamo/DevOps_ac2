package com.tdd.ac2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_c;
	
	@Embedded
	private CursoID cursoId;
	
	private String nome;
    private boolean status;
    private int totalAulas;
    private int aulasConcluidas;
    private List<Double> notas;

    public Curso(String nome, int totalAulas) {
        this.nome = nome;
        this.status = false;
        this.totalAulas = totalAulas;
        this.aulasConcluidas = 0;
        this.notas = new ArrayList<>();
    }

    public void completarAula() {
        if (aulasConcluidas < totalAulas) {
            aulasConcluidas++;
        }
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public double calcularMedia() {
        return notas.isEmpty() ? 0.0 : notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public boolean concluirCurso() {
        if (aulasConcluidas == totalAulas && calcularMedia() >= 7.0) {
            status = true;
            return true;
        }
        return false;
    }

    public boolean isConcluido() {
        return status;
    }

    public int getTotalAulas() {
        return totalAulas;
    }
    
    public String getNome()
    {
    	return nome;
    }
    
    public Long getId()
    {
    	return id_c;
    }
    
    public void setId(long id)
    {
    	this.id_c = id;
    }
    
    public void setCursoId(CursoID id)
    {
    	this.cursoId = id;
    }
    
    public CursoID getCursoId()
    {
    	return this.cursoId;
    }
}