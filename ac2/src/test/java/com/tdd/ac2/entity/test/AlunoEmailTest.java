package com.tdd.ac2.entity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tdd.ac2.entity.AlunoEmail;

@SpringBootTest
@ActiveProfiles("test")
public class AlunoEmailTest {
	
	@Test
    public void testValidEmail() {
        AlunoEmail alunoEmail = new AlunoEmail("joao@email.com");
        assertNotNull(alunoEmail);
        assertEquals("joao@email.com", alunoEmail.getEmailAddress());
    }

    @Test
    public void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AlunoEmail("invalidemail");
        });
    }
}
