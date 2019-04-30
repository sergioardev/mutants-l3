package com.mutants.app.domain.dto;


public class DNAEntityDTO {

	private String dna;
	private boolean mutant;

	public DNAEntityDTO(String dna, boolean mutant){
		this.dna	= dna;
		this.mutant	= mutant;
	}

	public String getDna(){
		return dna;
	}

	public boolean getMutant(){
		return mutant;
	}

}