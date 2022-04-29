package com.meli.mutant.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.mutant.utils.Indexes;

import junit.framework.Assert;

@SpringBootTest
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
