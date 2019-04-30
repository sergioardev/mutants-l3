package com.mutants.app.service;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mutants.app.builder.SymmetricDNABuilder;
import com.mutants.app.domain.wrappers.SymmetricDNA;


@ExtendWith(MockitoExtension.class)
class MutantDetectorServiceTest {

	@InjectMocks
	private MutantDetectorService mutantDetector;
	
	@Test
	final void notMutantDNA_withoutMatchesNxN_4_to_50(){
		for (int n=4; n<=50; n++){
			SymmetricDNA dnaNotMutant = SymmetricDNABuilder.noMutantDNASequenceNxN(n);
			assertFalse(mutantDetector.isMutant(dnaNotMutant));
		}
	}

	@Test
	final void notMutantDNA_with1HorizontalMatch6x6(){
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ','A','A','A','A',' '},//<--
			{' ',' ',' ',' ',' ',' '},
			{'A','A','A',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '},
			{'A',' ',' ',' ','A','A'},
			{' ',' ',' ',' ',' ',' '}
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{' ',' ','A','A','A','A'},//<--
			{' ',' ',' ',' ',' ',' '},
			{'A','A',' ',' ','A','A'},
			{' ',' ',' ',' ',' ',' '},
			{'A',' ',' ','A','A','A'}
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{'A','A','A',' ','A','A'},
			{' ',' ',' ',' ',' ',' '},
			{'A',' ','A','A',' ','A'},
			{' ',' ',' ',' ',' ',' '},
			{'A','A','A','A','A','A'},//<--
			{' ',' ',' ',' ',' ',' '}
		})));
	}

	@Test
	final void notMutantDNA_with1VerticalMatch6x6(){
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//V----------------------
			{'A',' ','A',' ',' ','A'},
			{'A',' ',' ',' ',' ','A'},
			{'A',' ',' ',' ',' ',' '},
			{'A',' ',' ',' ',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ',' ','A',' ',' ','A'}
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//--------V--------------
			{'A',' ',' ',' ','A',' '},
			{'A',' ',' ',' ',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{'A',' ','A',' ','A',' '},
			{' ',' ','A',' ','A',' '},
			{'A',' ','A',' ','A',' '}
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//------------V----------
			{'A',' ',' ','A',' ','A'},
			{'A',' ',' ','A',' ','A'},
			{' ',' ',' ','A',' ',' '},
			{' ',' ',' ','A',' ','A'},
			{'A',' ',' ',' ',' ','A'},
			{'A',' ',' ','A',' ','A'}
		})));
	}

	@Test
	final void notMutantDNA_with1LTRDiagonalMatch6x6(){
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//V----------------------
			{'A','A','A',' ',' ',' '},
			{' ','A','A','A',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ',' ',' ','A','A','A'},
			{' ',' ',' ',' ',' ','A'},
			{' ',' ',' ',' ',' ',' '} 
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//----V------------------
			{'A','A',' ',' ',' ',' '},
			{' ','A','A',' ',' ',' '},
			{' ',' ',' ','A',' ',' '},
			{'A',' ',' ','A','A',' '},
			{' ','A',' ',' ','A',' '},
			{' ',' ','A',' ',' ','A'}
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
		    //V----------------------
			{' ',' ',' ','A',' ',' '},
			{' ','A',' ',' ','A',' '},
			{'A',' ','A',' ',' ','A'},
			{' ','A',' ','A',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ',' ',' ','A',' ','A'}
		})));
	}

	@Test
	final void notMutantDNA_with1RTLDiagonalMatch6x6(){
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//------------V----------
			{' ','A',' ','A',' ',' '},
			{'A',' ','A',' ',' ',' '},
			{' ','A',' ',' ',' ',' '},
			{'A',' ',' ',' ',' ','A'},
			{' ',' ',' ',' ','A',' '},
			{' ',' ',' ','A',' ',' '}
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//--------------------V--
			{' ',' ',' ','A',' ','A'},
			{' ',' ',' ',' ','A','A'},
			{' ','A',' ','A',' ',' '},
			{'A',' ','A','A',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ','A',' ',' ',' ',' '}
		})));
		assertFalse(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//--------------------V--
			{' ',' ','A',' ','A',' '},
			{' ','A',' ','A',' ','A'},
			{'A',' ','A',' ','A',' '},
			{' ',' ',' ','A',' ',' '},
			{'A',' ','A',' ',' ',' '},
			{' ','A',' ',' ',' ',' '}
		})));
	}

	@Test
	final void mutantDNA_with2HorizontalMatches6x6(){
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ','A','A','A','A'},//<--
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '},
			{' ','A','A','A','A',' '} //<--
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '},
			{'A','A','A','A',' ','A'},//<--
			{'A',' ','A','A','A','A'},//<--
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{'A','A','A','A',' ',' '},//<--
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '},
			{'A','A','A','A','A','A'},//<--
			{' ',' ',' ',' ',' ',' '}
		})));
	}

	@Test
	final void mutantDNA_with2VerticalMatches6x6(){
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//V-------V--------------
			{'A',' ','A',' ',' ',' '},
			{'A',' ','A',' ',' ',' '},
			{'A',' ','A',' ',' ',' '},
			{'A',' ','A',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '},
			{' ',' ','A',' ',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//----V-------V----------
			{' ','A',' ','A',' ',' '},
			{' ','A',' ',' ',' ',' '},
			{' ','A',' ','A',' ',' '},
			{' ','A',' ','A',' ',' '},
			{' ',' ',' ','A',' ',' '},
			{' ',' ',' ','A',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//----------------V---V--
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ','A','A'},
			{' ',' ',' ',' ','A','A'},
			{' ',' ',' ',' ','A','A'},
			{' ',' ',' ',' ','A','A'},
			{' ',' ',' ',' ',' ',' '}
		})));
	}

	@Test
	final void mutantDNA_with2LTRMatches6x6(){
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//V-------V--------------
			{'A',' ','A',' ',' ',' '},
			{' ','A',' ','A',' ',' '},
			{' ',' ','A',' ','A',' '},
			{' ',' ',' ','A',' ','A'},
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//V-------V--------------
			{' ',' ',' ',' ',' ',' '},
			{'A',' ','A',' ',' ',' '},
			{' ','A',' ','A',' ',' '},
			{' ',' ','A',' ','A',' '},
			{' ',' ',' ','A',' ','A'},
			{' ',' ',' ',' ',' ',' '}
		})));
	}

	@Test
	final void mutantDNA_with2RTLMatches6x6(){
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//----------------V------
			{' ',' ',' ',' ','A',' '},
			{' ',' ',' ','A','A',' '},
			{' ',' ','A','A',' ',' '},
			{' ','A','A',' ',' ',' '},
			{' ','A',' ',' ',' ',' '},
			{'A',' ',' ',' ',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			//------------V-------V--
			{' ',' ',' ','A',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ','A',' ',' ',' ','A'},
			{'A',' ',' ',' ','A',' '},
			{' ',' ',' ','A',' ',' '},
			{' ',' ','A',' ',' ',' '}
		})));
	}

	@Test
	final void mutantDNA_with2MatchesAnyDirection6x6(){
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{' ','A',' ',' ',' ',' '},
			{' ','A','A','A','A',' '},
			{' ','A',' ',' ',' ',' '},
			{' ','A',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ','A',' ',' '},
			{' ',' ',' ','A',' ',' '},
			{'A',' ',' ','A',' ',' '},
			{' ','A',' ','A',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ',' ',' ','A',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ','A',' '},
			{'A',' ',' ','A',' ',' '},
			{'A',' ','A',' ',' ',' '},
			{'A','A',' ',' ',' ',' '},
			{'A',' ',' ',' ',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ','A','A','A','A',' '},
			{' ',' ',' ',' ',' ',' '},
			{' ','A',' ',' ',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ',' ',' ','A',' ',' '},
			{' ',' ',' ',' ','A',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{' ',' ',' ',' ','A',' '},
			{' ',' ',' ','A',' ',' '},
			{' ','A','A','A','A',' '},
			{' ','A',' ',' ',' ',' '},
			{' ',' ',' ',' ',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ','A'},
			{' ',' ',' ',' ','A',' '},
			{'A',' ',' ','A',' ',' '},
			{' ','A','A',' ',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ',' ',' ','A',' ',' '}
		})));
	}

	@Test
	final void mutantDNA_withManyMatchesOnAnyDirection6x6(){
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{' ','A',' ',' ',' ',' '},
			{' ','A','A','A','A',' '},
			{' ','A',' ','A',' ',' '},
			{' ','A',' ',' ','A',' '},
			{' ',' ',' ',' ',' ','A'}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ','A',' ',' '},
			{' ',' ',' ','A',' ',' '},
			{'A',' ','A','A','A','A'},
			{' ','A',' ','A',' ',' '},
			{' ',' ','A',' ',' ',' '},
			{' ',' ',' ','A',' ',' '}
		})));
		assertTrue(mutantDetector.isMutant(SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(6,new char[][]{
			{' ',' ',' ',' ',' ',' '},
			{'A',' ',' ',' ','A',' '},
			{'A','A',' ','A',' ',' '},
			{'A',' ','A','A',' ',' '},
			{'A','A','A','A',' ',' '},
			{'A',' ',' ',' ',' ',' '}
		})));
	}

}
