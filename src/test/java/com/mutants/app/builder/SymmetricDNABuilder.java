package com.mutants.app.builder;
import com.mutants.app.domain.wrappers.SymmetricDNA;


public class SymmetricDNABuilder {

	//With all base characters
	private static final String NOT_REPEATED_DNA_FRAGMENT_1 = "ATGC";
	private static final String NOT_REPEATED_DNA_FRAGMENT_2 = "GCAT";
	
	//Without base 'A' character
	private static final String NOT_REPEATED_DNA_FRAGMENT_3 = "TTGC";
	private static final String NOT_REPEATED_DNA_FRAGMENT_4 = "GCCT";

	public static SymmetricDNA noMutantDNASequenceNxN(int length){
		return noMutantDNASequenceNxN(length,NOT_REPEATED_DNA_FRAGMENT_1,NOT_REPEATED_DNA_FRAGMENT_2);
	}

	public static SymmetricDNA noMutantDNASequenceNxN_withoutBaseA_toReplace(int length, char[][] values){
		SymmetricDNA dna = noMutantDNASequenceNxN(length,NOT_REPEATED_DNA_FRAGMENT_3,NOT_REPEATED_DNA_FRAGMENT_4);
		String[] words = new String[length];
		for (int row=0; row<length; row++){
			StringBuilder newRow = new StringBuilder();
			for (int col=0; col<length; col++){
				char newBase = values[row][col];
				newRow.append((newBase!=' ')?
					newBase : dna.base(row,col)
				);
			}
			words[row] = newRow.toString();
		}
		return new SymmetricDNA(words);
	}

	public static SymmetricDNA dnaSequence(String...words){
		return new SymmetricDNA(words);
	}

	/* Auxilary methods */

	private static String copyUntil(int length, String s){
		StringBuilder builder = new StringBuilder();
		while(builder.length()<length){
			builder.append(s);
		}
		return builder.substring(0,length);
	}

	private static SymmetricDNA noMutantDNASequenceNxN(int length, String dnaFragment1, String dnaFragment2){
		String[] words = new String[length];
		for (int n=0; n<length; n++){
			words[n] = copyUntil(length,((n%2)==0)?
				dnaFragment1 : dnaFragment2
			);
		}
		return new SymmetricDNA(words);
	}

}