package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Stash;
import com.example.demo.repository.HumanRepository;
import com.example.demo.repository.MutanteRepository;

@SpringBootTest
class StashServiceTest {
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	@Autowired
	private StashService stashService;
	@Autowired
	private MutanteRepository mutantRepository;
	@Autowired
	private HumanRepository humanRepository;
	
	@Test
	void calculateTest() {
		long count_mutant_dna= mutantRepository.count();
		long count_human_dna= humanRepository.count();
		double ratio= (double) count_mutant_dna/count_human_dna;
		
		assertEquals(stashService.calculate().getRatio(),df.format(ratio));
	}

}
