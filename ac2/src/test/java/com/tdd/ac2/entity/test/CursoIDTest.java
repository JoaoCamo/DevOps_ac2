package com.tdd.ac2.entity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tdd.ac2.entity.CursoID;

@SpringBootTest
@ActiveProfiles("test")
public class CursoIDTest {
	
	@Test
    public void testValidCursoID() {
        CursoID cursoID = new CursoID("1234");
        assertNotNull(cursoID);
        assertEquals("1234", cursoID.getId());
    }

    @Test
    public void testInvalidCursoIDThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CursoID("invalid@id");
        });
    }
}
