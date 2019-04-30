package com.mutants.app.domain.wrappers;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mutants.app.builder.SymmetricDNABuilder;


class SymmetricDNATest {

	@Test
	final void testLength(){
		SymmetricDNA dnaSequence6x6 = SymmetricDNABuilder.noMutantDNASequenceNxN(6);
		assertEquals(6,dnaSequence6x6.length());
		
		SymmetricDNA dnaSequence9x9 = SymmetricDNABuilder.noMutantDNASequenceNxN(9);
		assertNotEquals(7,dnaSequence9x9.length());
		assertEquals(9,dnaSequence9x9.length());
	}

	@Test
	final void testBase(){
		SymmetricDNA dnaSequence = SymmetricDNABuilder.noMutantDNASequenceNxN_withoutBaseA_toReplace(4,new char[][]{
			{' ',' ','A',' '},
			{'A',' ',' ',' '},
			{' ',' ','T',' '},
			{' ',' ',' ','A'}
		});
		assertNotEquals('A',dnaSequence.base(0,0));
		assertNotEquals('A',dnaSequence.base(3,1));
		assertEquals('T',dnaSequence.base(2,2));
		assertEquals('A',dnaSequence.base(1,0));
		assertEquals('A',dnaSequence.base(0,2));
		assertEquals('A',dnaSequence.base(3,3));
	}

	@Test
	final void testWord(){
		SymmetricDNA dnaSequence = SymmetricDNABuilder.dnaSequence(
			"AAAAAA",
			"AATTCC",
			"GGGGGG",
			"CTTGAG",
			"AACCTT",
			"TTTTTT"
		);
		assertEquals("AAAAAA",dnaSequence.word(0));
		assertEquals("GGGGGG",dnaSequence.word(2));
		assertEquals("TTTTTT",dnaSequence.word(5));
		assertNotEquals("TTTTTT",dnaSequence.word(3));
		assertNotEquals("AAAAAA",dnaSequence.word(1));
	}

}