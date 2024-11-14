package com.tdd.ac2.dto;

public class AlunoDTO {
    private Long id;
    private String nome;
    private int moedas;

    public AlunoDTO() {}

    public AlunoDTO(Long id, String nome, int moedas) {
        this.id = id;
        this.nome = nome;
        this.moedas = moedas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }
}