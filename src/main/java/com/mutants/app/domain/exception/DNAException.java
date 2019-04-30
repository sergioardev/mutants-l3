package com.mutants.app.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class DNAException extends Exception {

	private static final long serialVersionUID = -7307299217007016049L;

	public DNAException(String message){
		super(message);
	}

}