package com.mutants.app.domain.exception;


public class AntisymmetricDNAException extends DNAException{

	private static final long serialVersionUID = 3521163704856795527L;

	public AntisymmetricDNAException() {
		super("Malformed DNA sequence");
	}
}