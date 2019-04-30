package com.mutants.app.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "dna_registers")
public class DNAEntity {

	@Id//DNA-Sequence
	private String id;

	private boolean mutant;

	public DNAEntity(){}

	public DNAEntity(String id, boolean mutant){
		this.id		= id;
		this.mutant = mutant;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public boolean getMutant(){
		return mutant;
	}

	public void setMutant(boolean mutant){
		this.mutant = mutant;
	}

}