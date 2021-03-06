package com.example.demo.service;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MutantServiceTest {
	@Autowired
	MutantService mutanteService;
	
	private static String[][] dna = {{"A","T","G","C","G","A"},{"C","A","G","T","G","C"},{"T","T","A","T","G","T"},{"A","G","A","A","G","G"},{"C","C","C","C","T","A"},{"T","C","A","C","T","G"}};
	
	@Test
	void rowTest() {	
		assertTrue(mutanteService.onLine(dna));
	}
	
	@Test
	void columnTest() {	
		assertTrue(mutanteService.onLine(dna));
	}
	
	@Test
	void crossTest() {	
		assertTrue(mutanteService.onLine(dna));
	}
}
