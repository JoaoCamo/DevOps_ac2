package com.tdd.ac2.dto.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.tdd.ac2.dto.AlunoDTO;

public class AlunoDtoTest {
	
	@Test
    public void testAlunoDTOConstructor() {
        Long id = 1L;
        String nome = "João";
        String email = "joao@example.com";

        AlunoDTO alunoDTO = new AlunoDTO(id, nome, email);
        AlunoDTO alunoDTO2 = new AlunoDTO(id, nome, email);

        assertNotNull(alunoDTO);
        assertEquals(id, alunoDTO.getId());
        assertEquals(nome, alunoDTO.getNome());
        assertEquals(email, alunoDTO.getEmail());
        assertEquals(alunoDTO, alunoDTO2);
    }
}
