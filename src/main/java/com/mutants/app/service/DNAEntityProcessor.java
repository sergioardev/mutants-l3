package com.mutants.app.service;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mutants.app.domain.dto.DNAEntityDTO;
import com.mutants.app.entity.DNAEntity;
import com.mutants.app.repository.DNAEntityRepository;


@Component
public class DNAEntityProcessor {

	@Autowired
	private DNAEntityRepository repository;

	private LinkedBlockingQueue<DNAEntityDTO> dnaRegistersToProcess;

	@Scheduled(fixedRate = 2000)//FIXME:Ajustar!
	public void processDNARegister(){
		while(true){
			DNAEntityDTO dto;
			try{
				dto = dnaRegistersToProcess.take();
				persist(dto);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	private void persist(DNAEntityDTO dto){
		DNAEntity dnaRegister = new DNAEntity(dto.getDna(),dto.getMutant());
		repository.insert(dnaRegister);
	}

}