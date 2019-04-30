package com.mutants.app.domain.iterators;
import com.mutants.app.domain.wrappers.DNASequence;


public class VerticalDNAIterator extends DNAIterator {

	private int col;

	public VerticalDNAIterator(DNASequence dnaSequence, int minLength){
		super(dnaSequence, minLength);
		this.col = -1; //Outside the limit
	}

	/* Implemented methods */

	@Override
	public boolean nextFragment(){
		if ((col+1)<lengthCurrentFragment()){
			col++;
			return true;
		}
		return false;
	}

	@Override
	public int lengthCurrentFragment(){
		return lengthDNASequence();
	}

	@Override
	public char base(int row){
		return word(row).charAt(col);
	}

}