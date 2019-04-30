package com.mutants.app.validator;
import com.mutants.app.domain.exception.DNAException;
import com.mutants.app.resource.DNARequest;


public interface DNAValidator {

	void validate(DNARequest dna) throws DNAException;

}