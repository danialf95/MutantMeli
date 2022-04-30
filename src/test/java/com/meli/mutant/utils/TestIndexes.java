package com.meli.mutant.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.meli.mutant.challenge.PruebaApplication;
import com.meli.mutant.utils.Indexes;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PruebaApplication.class)
public class TestIndexes {

	@Test
	public void isValidIndex() {
		Indexes index= new Indexes();
		index.setPositionI(2);
		index.setPositionJ(0);
		index.setMaxIndex(5);
		Assert.assertEquals(false,index.InvalidIndexes());
		index.setPositionI(4);
		index.setPositionJ(1);
		index.setMaxIndex(5);
		Assert.assertEquals(false,index.InvalidIndexes());
	}
	@Test
	public void isInvalidIndex()
	{
		Indexes index= new Indexes();
		index.setPositionI(-1);
		index.setPositionJ(0);
		index.setMaxIndex(5);
		Assert.assertEquals(true,index.InvalidIndexes());
		index.setPositionI(4);
		index.setPositionJ(6);
		index.setMaxIndex(5);
		Assert.assertEquals(true,index.InvalidIndexes());
	}
	
}
