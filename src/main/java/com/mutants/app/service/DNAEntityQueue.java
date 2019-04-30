package com.mutants.app.service;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mutants.app.domain.dto.DNAEntityDTO;
import com.mutants.app.repository.DNAEntityRepository;


@Component
public class DNAEntityQueue {

	@Autowired
	private DNAEntityRepository repository;

	private LinkedBlockingQueue<DNAEntityDTO> dnaRegistersToAnalyze;
	private LinkedBlockingQueue<DNAEntityDTO> dnaRegistersToProcess;

	@PostConstruct
	public void init(){
		dnaRegistersToAnalyze = new LinkedBlockingQueue<>();
		dnaRegistersToProcess = new LinkedBlockingQueue<>();
	}

	@Scheduled(fixedRate = 1000)//FIXME:Ajustar!
	public void analizeDNARegisters(){
		while(true){
			try{
				DNAEntityDTO dto = dnaRegistersToAnalyze.take();
				if (!repository.existsById(dto.getDna())){
					dnaRegistersToProcess.put(dto);
				}
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	/* Queue to analize */
	public void put(DNAEntityDTO dnaRegisterDTO){
		try{
			dnaRegistersToAnalyze.put(dnaRegisterDTO);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	/* Take to process */
	public DNAEntityDTO take(){
		try{
			return dnaRegistersToProcess.take();
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		return null;
	}

}