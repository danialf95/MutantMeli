package com.meli.mutant.enums;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.meli.mutant.challenge.PruebaApplication;
import com.meli.mutant.enums.Direction;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=PruebaApplication.class)
public class TestEnums {

	
	
	@Test
	public void testEnums()
	{
		Assert.assertEquals(Direction.HORIZONTAL_LT, Direction.find(4));
		Assert.assertEquals(Direction.HORIZONTAL_RT, Direction.find(5));
	}
}
