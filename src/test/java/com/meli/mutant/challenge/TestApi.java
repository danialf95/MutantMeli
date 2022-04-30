package com.meli.mutant.challenge;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.meli.mutant.api.ApiRestController;
import com.meli.mutant.request.RequestData;

import junit.framework.Assert;
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath:/WEB-INF/applicationContext.xml"})
@SpringBootTest
public class TestApi {
	
	
	@Autowired
	ApiRestController api;
	
	@Test
	public void api() {
		String[] payload = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		RequestData request = new RequestData();
		request.setDna(payload);
		//ResponseEntity<T>= api.generateResponse(payload);
		Assert.assertEquals(api.generateResponse(request).getStatusCodeValue(),200);
		String[] payloaderror = {"ATGCGA","CAGTGC","TTATAT","AGAAGG","CCCATA","TCACTG"};
		request.setDna(payloaderror);
		Assert.assertEquals(api.generateResponse(request).getStatusCodeValue(),403);
	}
	@Test
	public void logs() {	
     Assert.assertEquals(api.getlog().getStatusCodeValue(),200);
	}

}
