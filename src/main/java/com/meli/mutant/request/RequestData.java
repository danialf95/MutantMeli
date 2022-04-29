package com.meli.mutant.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestData {
	
	String[] dna;
	
	
	@JsonProperty("dna")
	public String[] getDna() {
		return dna;
	}
	@JsonProperty("dna")
	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
	
	
	
	
	
	

}
