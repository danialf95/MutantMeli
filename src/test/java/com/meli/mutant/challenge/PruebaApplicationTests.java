package com.meli.mutant.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.Assert;

@SpringBootTest
class PruebaApplicationTests {

	@Test
	void contextLoads() {
		Assert.assertEquals(5, 3+2);
	}

}
