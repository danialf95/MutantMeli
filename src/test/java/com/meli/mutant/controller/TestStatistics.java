package com.meli.mutant.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meli.mutant.challenge.PruebaApplication;
import com.meli.mutant.controller.MutantStatsController;
import com.meli.mutant.response.ResponseStatsData;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PruebaApplication.class)
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
