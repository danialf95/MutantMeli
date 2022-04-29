package com.meli.mutant.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseStatsData {

	Long count_mutant_dna;
	Long count_human_dna;
	Double ratio;
	
	@JsonProperty("count_mutant_dna")
	public Long getCount_mutant_dna() {
		return count_mutant_dna;
	}
	@JsonProperty("count_mutant_dna")
	public void setCount_mutant_dna(Long count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
	@JsonProperty("count_human_dna")
	public Long getCount_human_dna() {
		return count_human_dna;
	}
	@JsonProperty("count_human_dna")
	public void setCount_human_dna(Long count_human_dna) {
		this.count_human_dna = count_human_dna;
	}
	@JsonProperty("ratio")
	public Double getRatio() {
		return ratio;
	}
	@JsonProperty("ratio")
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
		
}
