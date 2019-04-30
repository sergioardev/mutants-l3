package com.mutants.app.domain.iterators;
import com.mutants.app.domain.wrappers.DNASequence;


public class RTLDiagonalDNAIterator extends DNAIterator {

	private int row;
	private int col;
	private int fragment;
	private int maxFragments;

	public RTLDiagonalDNAIterator(DNASequence dnaSequence, int minLength){
		super(dnaSequence, minLength);
		int maxRows	= (dnaSequence.length()-minLength);
		int maxCols	= (word(0).length()	   -minLength);
		this.maxFragments = (maxRows + maxCols+1);
		this.fragment	  = -1;			//Outside the limit
		this.row		  = (maxRows+1);//Outside the limit
		this.col		  = (word(0).length()-1);
	}

	@Override
	public boolean nextFragment(){
		if ((fragment+1)<maxFragments){
			fragment++;
			if (row>0){
				row--;
			}else{
				col--;
			}
			return true;
		}
		return false;
	}

	@Override
	public char base(int pos){
		return word(row+pos).charAt(col-pos);
	}

	@Override
	public int lengthCurrentFragment(){
		int maxRow = lengthDNASequence();
		if (row>0)
			return (maxRow-row);
		
		int maxCol = (word(0).length()-1);
		return (maxRow-(maxCol-col));
	}

}