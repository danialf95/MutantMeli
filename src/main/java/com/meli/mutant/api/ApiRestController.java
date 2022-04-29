package com.meli.mutant.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.mutant.controller.MutantController;
import com.meli.mutant.controller.MutantStatsController;
import com.meli.mutant.exceptions.ResponseError;
import com.meli.mutant.request.RequestData;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	
	@Autowired
	MutantController controller;
	@Autowired
	MutantStatsController statsController;
	
	@CrossOrigin("*")
    @PostMapping(value= "/mutant")
	public ResponseEntity <Object> generateResponse(@RequestBody RequestData input)
	{
		try {			
			if(input.getDna()==null)
			   throw new Exception("Input fail data is null");
				
			if(controller.verificationMutant(input.getDna()))
				  return ResponseEntity.status(HttpStatus.OK).build();
			  else  return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			
		    } catch (Exception e) {
				ResponseError ResponseException=new ResponseError(500,e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseException);
		    }
	}
	
	
	@CrossOrigin("*")
    @GetMapping(value ="/stats")
	public ResponseEntity <Object> getlog()
	{
		try {	
			return ResponseEntity.ok().body(statsController.getStatistics());
		} catch (Exception e) {
			ResponseError ResponseException=new ResponseError(500,e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseException);
		}
	}
	
}
