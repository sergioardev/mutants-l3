package com.mutants.app.domain.exception;


public class InvalidDNAException extends DNAException{

	private static final long serialVersionUID = 6147111217728932124L;

	public InvalidDNAException() {
		super("Invalid DNA sequence");
	}

}