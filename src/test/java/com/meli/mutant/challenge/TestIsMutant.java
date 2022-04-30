package com.meli.mutant.challenge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.meli.mutant.challenge.PruebaApplication;
import com.meli.mutant.controller.MutantController;
import com.meli.mutant.service.impl.MutantMeli;

import junit.framework.Assert;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestIsMutant {

	@Autowired
	MutantController contro;
	
	@Test
	public void generateMatrix() {
		String[] payload = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		MutantMeli mutant =new  MutantMeli();
		Assert.assertEquals(6, mutant.generateMatrix(payload).size());
		Assert.assertNotNull(mutant.generateMatrix(payload));
	}
	@Test
	public void isMutant()
		{
			String[] payload = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
			//MutantController contro = new MutantController();
			Assert.assertEquals(true, contro.verificationMutant(payload)); 	
		}
	@Test
	public void isHuman()
		{
			String[] payload = {"ATGCGA","CAGTGC","TTATAT","AGAAGG","CCCATA","TCACTG"};
			//MutantController contro = new MutantController();
			Assert.assertEquals(false, contro.verificationMutant(payload));
		}
	
}
