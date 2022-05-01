package com.meli.mutant.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.meli.mutant.challenge.PruebaApplication;
import com.meli.mutant.controller.MutantController;
import com.meli.mutant.service.impl.MutantMeli;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=PruebaApplication.class)
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
	public void invalidGeneticCodeMatrix() {
		String[] payload = {"XTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		MutantMeli mutant =new  MutantMeli();
		Exception exception = Assert.assertThrows(RuntimeException.class, () -> {
			     mutant.generateMatrix(payload);
		    });
		    String expectedMessage = "Invalid genetic code";
		    String actualMessage = exception.getMessage();
		    Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void invalidSizeCodeMatrix() {
		String[] payload = {"TTGCGA","CAGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		MutantMeli mutant =new MutantMeli();
		Exception exception = Assert.assertThrows(RuntimeException.class, () -> {
			     mutant.generateMatrix(payload);
		    });
		    String expectedMessage = "Invalid structure genetic code";
		    String actualMessage = exception.getMessage();
		    Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	public void isMutant()
		{
			String[] payload = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
			Assert.assertEquals(true, contro.verificationMutant(payload)); 	
		}
	@Test
	public void isHuman()
		{
			String[] payload = {"ATGCGA","CAGTGC","TTATAT","AGAAGG","CCCATA","TCACTG"};
			Assert.assertEquals(false, contro.verificationMutant(payload));
		}
	
}
