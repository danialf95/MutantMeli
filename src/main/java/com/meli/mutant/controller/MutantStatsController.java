package com.meli.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meli.mutant.repository.LogAuditAdnDao;
import com.meli.mutant.response.ResponseStatsData;

@Component
public class MutantStatsController {
	
	
	@Autowired
	LogAuditAdnDao stats;
	
	public ResponseStatsData getStatistics()
	
	{
		ResponseStatsData response = new ResponseStatsData();
		try {
		response.setCount_human_dna(stats.countByStatus(false));
		response.setCount_mutant_dna(stats.countByStatus(true));
		response.setRatio(Double.valueOf((response.getCount_human_dna()/response.getCount_mutant_dna())));
		return response;
		} catch (Exception e) {
			// TODO: handle exception
			response.setRatio(0.0);
			return response;
			
		}
	}
	
	

}
