package com.mutants.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutants.app.domain.dto.DNAStadisticDTO;
import com.mutants.app.repository.DNAEntityRepository;


@Service
public class DNAStadisticsService {

	@Autowired
	private DNAEntityRepository repository;

	public DNAStadisticDTO getStadistics(){
		long humans	 = repository.countByMutant(false);
		long mutants = repository.countByMutant(true);
		return new DNAStadisticDTO(mutants,humans);
	}

}