package com.mutants.app.service;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mutants.app.domain.iterators.DNAIterator;
import com.mutants.app.domain.iterators.HorizontalDNAIterator;
import com.mutants.app.domain.iterators.LTRDiagonalDNAIterator;
import com.mutants.app.domain.iterators.RTLDiagonalDNAIterator;
import com.mutants.app.domain.iterators.VerticalDNAIterator;
import com.mutants.app.domain.wrappers.DNASequence;


@Service
public class MutantDetectorService {

	private static final int MATCH_PATTERN_LENGTH = 4;
	private static final int SCORE_TO_BE_MUTANT	  = 2;
	
	private List<Class<? extends DNAIterator>> dnaIterators = Arrays.asList(
		HorizontalDNAIterator.class,
		VerticalDNAIterator.class,
		LTRDiagonalDNAIterator.class,
		RTLDiagonalDNAIterator.class
	);

	public boolean isMutant(DNASequence dna){
		int score = 0;
		for (Class<? extends DNAIterator> iteratorClass : dnaIterators){
			DNAIterator dnaIterator = getIterator(iteratorClass,dna);
			int expectedScore		= (SCORE_TO_BE_MUTANT-score);
			
			score += scoreMutant(dnaIterator,expectedScore);
			if (score==SCORE_TO_BE_MUTANT)
				return true;
		}
		return false;
	}

	private DNAIterator getIterator(Class<? extends DNAIterator> iteratorClasss, DNASequence dnaSequence){
		try{
			return iteratorClasss.getConstructor(DNASequence.class,int.class).newInstance(dnaSequence,MATCH_PATTERN_LENGTH);
		}catch(ReflectiveOperationException e){
			e.printStackTrace();
		}
		return null;
	}

	private int scoreMutant(DNAIterator dnaIterator, int expectedScore){
		int	 pos,  maxPosReached, occurs, lengthFragment;
		char base, expectedBase;
		int	 score = 0;
		
		/* Analyze the DNA fragments */
		while(dnaIterator.nextFragment()){
			lengthFragment = dnaIterator.lengthCurrentFragment();
			expectedBase   = Character.UNASSIGNED;
			occurs		   = 0;
			pos			   = -1;
			
			/* Compare the base characters by grouping them by "MATCH_PATTERN_LENGTH" positions*/
			while(score<expectedScore){
				pos += MATCH_PATTERN_LENGTH;
				if (pos>=lengthFragment)
					break;
				
				maxPosReached = pos;
				base = dnaIterator.base(pos);
				if (base==expectedBase){
					occurs++;
				}else{
					expectedBase = base;
					occurs = 1;//Reset
				}
				while(occurs<MATCH_PATTERN_LENGTH){
					pos--;
					base = dnaIterator.base(pos);
					if (base==expectedBase){
						occurs++;
					}else{
						occurs = (maxPosReached-pos);
						break;
					}
				}
				if (occurs==MATCH_PATTERN_LENGTH){
					pos	   = maxPosReached;
					occurs = 0;
					score++;
				}
			}
			if (score==expectedScore)
				break;
		}
		return score;
	}

}