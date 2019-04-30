package com.mutants.app.domain.exception;


public class EmptyDNAException extends DNAException{

	private static final long serialVersionUID = 6147111217728932124L;

	public EmptyDNAException(){
		super("DNA sequence without data");
	}

}