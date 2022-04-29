package com.meli.mutant.challenge;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.mutant.enums.Direction;

@SpringBootTest
public class TestEnums {

	
	
	@Test
	public void testEnums()
	{
		Assert.assertEquals(Direction.HORIZONTAL_LT.getValue(), 4);
		Assert.assertEquals(Direction.HORIZONTAL_RT.getValue(), 5);
		Assert.assertEquals(Direction.HORIZONTAL_LT, Direction.find(4));
		Assert.assertEquals(Direction.HORIZONTAL_RT, Direction.find(5));
	}
}
