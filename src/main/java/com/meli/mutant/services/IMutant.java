package com.meli.mutant.services;

import java.util.Vector;

public interface IMutant {
	
	public boolean isMutant(Vector<char[]> dna);
	
	public Vector<char[]> generateMatrix(String[] dna);

}
