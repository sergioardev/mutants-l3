package com.mutants.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.app.domain.dto.DNAStadisticDTO;
import com.mutants.app.domain.exception.DNAException;
import com.mutants.app.resource.DNAStadisticResponse;
import com.mutants.app.service.DNAStadisticsService;


@RestController
public class StatsRESTController {

	@Autowired
	private DNAStadisticsService dnaStadisticsService;

	@GetMapping(path="/stats", produces="application/json")
	public DNAStadisticResponse stats() throws DNAException{
		//Load statistics
		DNAStadisticDTO dto = dnaStadisticsService.getStadistics();
		DNAStadisticResponse response = new DNAStadisticResponse(dto.getMutans(),dto.getHumans());
		
		//Reponse
		return response;
	}

}