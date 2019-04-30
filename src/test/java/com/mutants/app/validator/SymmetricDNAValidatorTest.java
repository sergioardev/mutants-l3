package com.mutants.app.validator;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mutants.app.builder.DNARequestBuilder;
import com.mutants.app.domain.exception.AntisymmetricDNAException;
import com.mutants.app.domain.exception.EmptyDNAException;
import com.mutants.app.domain.exception.InvalidDNAException;


@ExtendWith(MockitoExtension.class)
class SymmetricDNAValidatorTest {

	@InjectMocks
	private SymmetricDNAValidator dnaValidator;

	@Test
	final void dnaRequestWithoutData(){
		assertThrows(
			EmptyDNAException.class,
			()->dnaValidator.validate(DNARequestBuilder.dnaWithNullData())
		);
		assertThrows(
			EmptyDNAException.class,
			()->dnaValidator.validate(DNARequestBuilder.dnaWithEmptyData())
		);
	}

	@Test
	final void dnaRequestWithAsymmetricData(){
		assertThrows(
			AntisymmetricDNAException.class,
			()->dnaValidator.validate(DNARequestBuilder.dnaWith5x6LengthData())
		);
		assertThrows(
			AntisymmetricDNAException.class,
			()->dnaValidator.validate(DNARequestBuilder.dnaWithIrregularLengthData())
		);
	}

	@Test
	final void dnaRequestWithInvalidData(){
		assertThrows(
			InvalidDNAException.class,
			()->dnaValidator.validate(DNARequestBuilder.dnaWithInvalidData())
		);
	}


}