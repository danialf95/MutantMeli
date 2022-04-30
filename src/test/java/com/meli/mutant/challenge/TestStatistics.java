package com.meli.mutant.challenge;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.meli.mutant.controller.MutantStatsController;
import com.meli.mutant.response.ResponseStatsData;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PruebaApplication.class)
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
