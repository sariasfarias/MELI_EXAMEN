package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HumanDto;
import com.example.demo.dto.MutantDto;
import com.example.demo.service.MutantService;
import com.example.demo.service.StashService;

@Controller

@RestController
@RequestMapping("api/v1/mutante")
public class MutantController {

	@Autowired
	private MutantService mutanteService;
	@Autowired
	private StashService stashService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@RequestBody MutantDto mutanteDto){
		if(mutanteService.isError()) {
			return ResponseEntity.badRequest().body("The input values are incorrect");
		}
		
		if(mutanteService.isMutant(mutanteDto.getAdn())) {
			mutanteDto= mutanteService.save(mutanteDto);
				return ResponseEntity.ok().body("Mutant insert");
		}
		mutanteService.saveHuman(new HumanDto(mutanteDto));
		return ResponseEntity.status(403).body("Human insert");
				
	}
	
	@GetMapping("/stash")
	public ResponseEntity<Object> stash(){
		return ResponseEntity.ok(stashService.calculate());
	}
	
	
}
