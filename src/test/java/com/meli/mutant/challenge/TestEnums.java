package com.meli.mutant.challenge;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.meli.mutant.enums.Direction;
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@SpringBootTest
public class TestEnums {

	
	
	@Test
	public void testEnums()
	{
		Assert.assertEquals(Direction.HORIZONTAL_LT, Direction.find(4));
		Assert.assertEquals(Direction.HORIZONTAL_RT, Direction.find(5));
	}
}
