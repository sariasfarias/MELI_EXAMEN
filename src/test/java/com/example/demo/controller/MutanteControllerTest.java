package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.dto.MutanteDto;
@SpringBootTest
class MutanteControllerTest {
	@Autowired
	MutanteController mutanteController;
	@Test
	void saveMutantTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        MutanteDto mutanteDto = new MutanteDto();
        String[] adn= {"ATGCTA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"};
        mutanteDto.setAdn(adn);
        ResponseEntity<Object> responseEntity = mutanteController.save(mutanteDto);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	@Test
	void saveHumanTest() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        MutanteDto mutanteDto = new MutanteDto();
        String[] adn= {"TTGCTA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"};
        mutanteDto.setAdn(adn);
        ResponseEntity<Object> responseEntity = mutanteController.save(mutanteDto);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(403);
	}

}
