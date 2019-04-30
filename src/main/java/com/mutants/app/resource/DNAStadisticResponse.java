package com.mutants.app.resource;

public class DNAStadisticResponse {

	private long count_mutant_dna;
	private long count_human_dna;
	private double ratio;

	public DNAStadisticResponse(long mutants, long humans){
		this.count_mutant_dna = mutants;
		this.count_human_dna  = humans;
		this.ratio			  = (mutants / ((humans!=0)?humans:1));
	}

	public long getCount_mutant_dna(){
		return count_mutant_dna;
	}

	public long getCount_human_dna(){
		return count_human_dna;
	}

	public double getRatio(){
		return ratio;
	}

}