package com.meli.mutant.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import junit.framework.Assert;
@ContextConfiguration(classes = PruebaApplication.class)
@SpringBootTest(classes = {PruebaApplicationTests.class})
class PruebaApplicationTests {

	@Test
	void contextLoads() {
		Assert.assertEquals(5, 3+2);
	}

}
