package com.mutants.app.domain.iterators;
import com.mutants.app.domain.wrappers.DNASequence;


public abstract class DNAIterator {

	private DNASequence dnaSequence;
	private int minLength;

	public DNAIterator(DNASequence dnaSequence, int minLength){
		this.dnaSequence = dnaSequence;
		this.minLength	 = minLength;
	}

	protected String word(int row){
		return dnaSequence.word(row);
	}

	protected int lengthDNASequence(){
		return dnaSequence.length();
	}

	protected int minLength(){
		return minLength;
	}

	/* Methods to implement */

	public abstract boolean nextFragment();

	public abstract int lengthCurrentFragment();

	public abstract char base(int pos);

}