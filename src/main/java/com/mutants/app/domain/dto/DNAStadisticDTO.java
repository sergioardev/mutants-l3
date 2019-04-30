package com.mutants.app.domain.dto;


public class DNAStadisticDTO {

	private long mutans;
	private long humans;

	public DNAStadisticDTO(long mutans, long humans){
		this.mutans	= mutans;
		this.humans	= humans;
	}

	public long getMutans(){
		return mutans;
	}

	public long getHumans(){
		return humans;
	}

}