package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Human;
import com.example.demo.domain.Mutante;
import com.example.demo.dto.HumanDto;
import com.example.demo.dto.MutanteDto;
import com.example.demo.repository.HumanRepository;
import com.example.demo.repository.MutanteRepository;

@Service
public class MutanteService {
	@Autowired
	private MutanteRepository mutantRepository;
	@Autowired
	private HumanRepository humanRepository;
	
	private boolean error=false;
	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public MutanteService(MutanteRepository mutantRepository,HumanRepository humanRepository) {
		super();
		this.mutantRepository = mutantRepository;
		this.humanRepository=humanRepository;
	}

	public MutanteDto save(MutanteDto mutanteDto) {
		
		try {
			Mutante mutante = new Mutante();
			mutante.setAdn(String.join(",", mutanteDto.getAdn()));

			mutantRepository.save(mutante);
			return mutanteDto;

		} catch (Exception e) {
			
			return mutanteDto;
		}

	}
	
	public void saveHuman(MutanteDto mutanteDto) {

		Human human = new Human();
		human.setAdn(String.join(",", mutanteDto.getAdn()));
		humanRepository.save(human);

	}

	public boolean isMutant(String[] adn) {
		error=false;
		String[][] matrizAdn = new String[adn.length][adn.length];
		try {
			for (int i = 0; i < adn.length; i++) {
				char[] aux = adn[i].toCharArray();
				for (int j = 0; j < aux.length; j++) {
					matrizAdn[i][j] = Character.toString(aux[j]);
					if(!(matrizAdn[i][j].equals("A") || matrizAdn[i][j].equals("T") || matrizAdn[i][j].equals("C") || matrizAdn[i][j].equals("G"))) {
						error=true;
					}
				}
			}
			return onLine(matrizAdn);
			
		}catch(Exception e) {
			error=true;
			return false;
		}
	}

	public boolean onLine(String[][] adn) {
		int contadorRow = 0;
		int contadorColumn=0;
		int contadorCross=0;
		for (int i = 0; i < adn.length; i++) {
			for (int j = 0; j < adn.length; j++) {
				// recorro la matriz
				 contadorRow = 0;
				 contadorColumn=0;
				 contadorCross=0;
				if(adn.length-i>=4 && adn.length-j>=4) {
//					for (int a = j; a < j+4; a++) {
//						if (adn[i][j].equals(adn[i][a]) || adn[i][j].equals(adn[a][j])) {
//							contador++;
//						}
//						if (contador == 4)
//							return true;
//					}
					for (int b = 1; b <4 ; b++) {
						if (adn[i][j].equals(adn[i][j+b]))
							contadorRow++;
						if ( adn[i][j].equals(adn[i+b][j])) 
							contadorColumn++;
						if (adn[i][j].equals(adn[i + b][j + b]))
							contadorCross++;
						if (contadorRow == 3 || contadorColumn == 3 ||contadorCross == 3)
							return true;
					}
				}
				
			}
			
		}
		return false;
	}

//	public boolean onColumn(String[][] adn) {
//		boolean isMutant = false;
//		int contador = 0;
//		for (int i = 0; i < adn.length; i++) {
//			for (int j = 0; j < adn.length; j++) {
//				// recorro la matriz
//				contador = 0;
//				if(adn.length-i>=4) {
//					for (int a = i; a <i+4; a++) {
//						if (adn[i][j].equals(adn[a][j]))
//							contador++;
//						if (contador == 4)
//							isMutant = true;
//					}
//				}
//			}
//		}
//		return isMutant;
//	}
//
//	public boolean onCross(String[][] adn) {
//		boolean isMutant = false;
//		int contador = 0;
//		for (int i = 0; i < adn.length; i++) {
//			for (int j = 0; j < adn.length; j++) {
//				// recorro la matriz
//				contador = 0;
//				if(adn.length-i>=4 && adn.length-j>=4) {
//					for (int b = 0; b <4 ; b++) {
//						if (adn[i][j].equals(adn[i + b][j + b]))
//							contador++;
//						if (contador == 4)
//							isMutant = true;
//					}
//				}	
//			}
//		}
//		return isMutant;
//	}
}
