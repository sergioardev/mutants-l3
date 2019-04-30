package com.mutants.app.validator;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mutants.app.domain.exception.AntisymmetricDNAException;
import com.mutants.app.domain.exception.DNAException;
import com.mutants.app.domain.exception.EmptyDNAException;
import com.mutants.app.domain.exception.InvalidDNAException;
import com.mutants.app.resource.DNARequest;


@Component
public class SymmetricDNAValidator implements DNAValidator{

	private static List<Character> NITROGENOUS_BASE_CHARS = Arrays.asList('A','T','C','G');

	@Override
	public void validate(DNARequest dnaRequest) throws DNAException{
		String[] dna = dnaRequest.getDna();
		if (isEmptyDNA(dna))
			throw new EmptyDNAException();
		
		for (String word : dna){
			if (isAntisymmetricDNA(word,dna.length))
				throw new AntisymmetricDNAException();
			
			if (isInvalidDNA(word))
				throw new InvalidDNAException();
		}
	}

	private boolean isEmptyDNA(String[] dna){
		return ((dna==null) || (dna.length==0));
	}

	private boolean isAntisymmetricDNA(String word, int expectedLength){
		return (word.length()!=expectedLength);
	}

	private boolean isInvalidDNA(String word){
		for (int n=0; n<word.length(); n++){
			char base = word.charAt(n);
			if (!NITROGENOUS_BASE_CHARS.contains(base))
				return true;
		}
		return false;
	}

}