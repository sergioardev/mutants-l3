package com.mutants.app.domain.wrappers;


public class SymmetricDNA extends DNASequence {

	private int length;

	public SymmetricDNA(String[] words){
		super(words);
		this.length = words.length;
	}

	@Override
	public int length(){
		return length;
	}

}