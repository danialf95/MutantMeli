package com.meli.mutant.challenge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import junit.framework.Assert;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PruebaApplication.class)
@SpringBootTest
class PruebaApplicationTests {

	@Test
	void contextLoads() {
		Assert.assertEquals(5, 3+2);
	}

}
