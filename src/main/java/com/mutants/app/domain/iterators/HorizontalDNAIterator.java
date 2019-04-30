package com.mutants.app.domain.iterators;
import com.mutants.app.domain.wrappers.DNASequence;


public class HorizontalDNAIterator extends DNAIterator {

	private int row;

	public HorizontalDNAIterator(DNASequence dnaSequence, int minLength){
		super(dnaSequence, minLength);
		this.row = -1; //Outside the limit
	}

	/* Implemented methods */

	@Override
	public boolean nextFragment(){
		if ((row<0) || ((row+1)<lengthCurrentFragment())){
			row++;
			return true;
		}
		return false;
	}

	@Override
	public int lengthCurrentFragment(){
		return word(row).length();
	}

	@Override
	public char base(int col){
		return word(row).charAt(col);
	}

}