package com.example.demo.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Stash;
import com.example.demo.repository.HumanRepository;
import com.example.demo.repository.MutantRepository;

@Service
public class StashService {
	@Autowired
	private MutantRepository mutantRepository;
	@Autowired
	private HumanRepository humanRepository;
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public StashService(MutantRepository mutantRepository, HumanRepository humanRepository) {
		super();
		this.mutantRepository = mutantRepository;
		this.humanRepository = humanRepository;
	}
	public StashService() {
		super();
	}
	
	public Stash calculate() {
		long count_mutant_dna= mutantRepository.count();
		long count_human_dna= humanRepository.count();
		double ratio= (double) count_mutant_dna/count_human_dna;
		if(ratio==0)
			return new Stash((int)count_mutant_dna ,(int)count_human_dna,"1");
		
		return new Stash((int)count_mutant_dna ,(int)count_human_dna,df.format(ratio));
	}
	
}
