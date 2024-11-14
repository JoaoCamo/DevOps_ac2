package com.tdd.ac2.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CursoID {
	private String id;

    protected CursoID() {}

    public CursoID(String id) {
        if (id == null || !id.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoID cursoId = (CursoID) o;
        return Objects.equals(id, cursoId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
