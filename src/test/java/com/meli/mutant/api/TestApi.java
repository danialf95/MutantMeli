package com.meli.mutant.api;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.meli.mutant.api.ApiRestController;
import com.meli.mutant.challenge.PruebaApplication;
import com.meli.mutant.request.RequestData;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=PruebaApplication.class)
public class TestApi {
	
	
	@Autowired
	ApiRestController api;
	
	public void api() {
		String[] payload = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		RequestData request = new RequestData();
		request.setDna(payload);
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
