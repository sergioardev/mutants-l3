package com.mutants.app.builder;
import com.mutants.app.resource.DNARequest;


public class DNARequestBuilder {

	public static DNARequest dnaWithNullData(){
		return new DNARequest();
	}

	public static DNARequest dnaWithEmptyData(){
		return dnaRequest();
	}

	public static DNARequest dnaWith5x6LengthData(){
		return dnaRequest(
			"AAAAAA",
			"CCCCCC",
			"TTTTTT",
			"TTTTTT",
			"CCCCCC"
		);
	}

	public static DNARequest dnaWithIrregularLengthData(){
		return dnaRequest(
			"AAAAAA",
			"CCCCCC",
			"TTT",
			"TTTTTT",
			"CCCCCC",
			"TTTTTT"
		);
	}

	public static DNARequest dnaWithInvalidData(){
		return dnaRequest(
			"AAAAAA",
			"CCCCCC",
			"TTXXTT",
			"TTTTTT",
			"CCCCCC",
			"TTTTTT"
		);
	}

	static DNARequest dnaRequest(String...words){
		DNARequest dnaRequest = new DNARequest();
		dnaRequest.setDna(words);
		return dnaRequest;
	}

}