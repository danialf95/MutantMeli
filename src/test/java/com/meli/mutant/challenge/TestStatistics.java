package com.meli.mutant.challenge;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.meli.mutant.controller.MutantStatsController;
import com.meli.mutant.response.ResponseStatsData;

@SpringBootTest
public class TestStatistics {

	
	@Autowired
    MutantStatsController stats;
	
	@Test
	public void statistics()
	{
		ResponseStatsData response = new ResponseStatsData();
		response = stats.getStatistics();
		
		if(response.getCount_human_dna()>response.getCount_mutant_dna())
		   Assert.assertTrue(response.getRatio()>0.0);
		else
		   Assert.assertTrue(response.getRatio().equals(0.0));
		
	}	
}
