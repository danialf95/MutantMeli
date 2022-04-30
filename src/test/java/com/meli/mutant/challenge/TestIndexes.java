package com.meli.mutant.challenge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.meli.mutant.utils.Indexes;

import junit.framework.Assert;
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath:/WEB-INF/applicationContext.xml"})
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
