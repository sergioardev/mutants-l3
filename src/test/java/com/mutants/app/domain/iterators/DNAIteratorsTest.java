package com.mutants.app.domain.iterators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mutants.app.builder.SymmetricDNABuilder;
import com.mutants.app.domain.wrappers.SymmetricDNA;


class DNAIteratorsTest {
	
	@Test
	final void testHorizontalDNAIterator(){
		SymmetricDNA dna = SymmetricDNABuilder.dnaSequence(
			"ATCGAT",
			"AAAAAA",
			"ATCGAT",
			"CCCCCC",
			"ATAAAT",
			"TTTTTT"
		);
		List<String> dnaFragments = new ArrayList<>();
		HorizontalDNAIterator iterator = new HorizontalDNAIterator(dna,4);
		while(iterator.nextFragment()){
			int lengthCurrentFragment = iterator.lengthCurrentFragment();
			StringBuilder fragment = new StringBuilder();
			for (int col=0; col<lengthCurrentFragment; col++){
				fragment.append(iterator.base(col));
			}
			dnaFragments.add(fragment.toString());
			
			//Test length current frangment
			assertEquals(fragment.length(),lengthCurrentFragment);
		}
		//Test expected data in the fragment
		for (int n=0; n<dnaFragments.size(); n++){
			assertEquals(dna.word(n),dnaFragments.get(n));
		}
	}

	@Test
	final void testVerticalDNAIterator(){
		SymmetricDNA dna = SymmetricDNABuilder.dnaSequence(
			"ATCGAT",
			"AAAAAA",
			"ATCGAT",
			"CCCCCC",
			"ATAAAT",
			"TTTTTT"
		);
		List<String> dnaFragments = new ArrayList<>();
		VerticalDNAIterator iterator = new VerticalDNAIterator(dna,4);
		while(iterator.nextFragment()){
			int lengthCurrentFragment = iterator.lengthCurrentFragment();
			StringBuilder fragment = new StringBuilder();
			for (int row=0; row<lengthCurrentFragment; row++){
				fragment.append(iterator.base(row));
			}
			dnaFragments.add(fragment.toString());
			
			//Test length current frangment
			assertEquals(fragment.length(),lengthCurrentFragment);
		}
		//Test expected data in the fragment
		List<String> expectedData = Arrays.asList(
			"AAACAT",
			"TATCTT",
			"CACCAT",
			"GAGCAT",
			"AAACAT",
			"TATCTT"
		);
		for (int n=0; n<dnaFragments.size(); n++){
			assertEquals(expectedData.get(n),dnaFragments.get(n));
		}
	}

	@Test
	final void testLTRDiagonalDNAIterator(){
		SymmetricDNA dna = SymmetricDNABuilder.dnaSequence(
			"ATCGAT",
			"AAAAAA",
			"ATCGAT",
			"CCCCCC",
			"ATAAAT",
			"TTTTTT"
		);
		List<String> dnaFragments = new ArrayList<>();
		LTRDiagonalDNAIterator iterator = new LTRDiagonalDNAIterator(dna,4);
		while(iterator.nextFragment()){
			int lengthCurrentFragment = iterator.lengthCurrentFragment();
			StringBuilder fragment = new StringBuilder();
			for (int row=0; row<lengthCurrentFragment; row++){
				fragment.append(iterator.base(row));
			}
			dnaFragments.add(fragment.toString());
			
			//Test length current frangment
			assertEquals(fragment.length(),lengthCurrentFragment);
		}
		//Test expected data in the fragment
		List<String> expectedData = Arrays.asList(
			"ACAT",
			"ATCAT",
			"AACCAT",
			"TAGCT",
			"CAAC"
		);
		for (int n=0; n<dnaFragments.size(); n++){
			assertEquals(expectedData.get(n),dnaFragments.get(n));
		}
	}

	@Test
	final void testRTLDiagonalDNAIterator(){
		SymmetricDNA dna = SymmetricDNABuilder.dnaSequence(
				"ATCGAT",
				"AAAAAA",
				"ATCGAT",
				"CCCCCC",
				"ATAAAT",
				"TTTTTT"
			);
			List<String> dnaFragments = new ArrayList<>();
			RTLDiagonalDNAIterator iterator = new RTLDiagonalDNAIterator(dna,4);
			while(iterator.nextFragment()){
				int lengthCurrentFragment = iterator.lengthCurrentFragment();
				StringBuilder fragment = new StringBuilder();
				for (int row=0; row<lengthCurrentFragment; row++){
					fragment.append(iterator.base(row));
				}
				dnaFragments.add(fragment.toString());
				
				//Test length current frangment
				assertEquals(fragment.length(),lengthCurrentFragment);
			}
			//Test expected data in the fragment
			List<String> expectedData = Arrays.asList(
				"TCAT",
				"AACAT",
				"TAGCTT",
				"AACCA",
				"GATC"
			);
			for (int n=0; n<dnaFragments.size(); n++){
				assertEquals(expectedData.get(n),dnaFragments.get(n));
			}
	}

}