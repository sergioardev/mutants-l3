package com.mutants.app.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mutants.app.entity.DNAEntity;


@Repository
public interface DNAEntityRepository extends MongoRepository<DNAEntity,String>{
	public Long countByMutant(boolean mutant);
}