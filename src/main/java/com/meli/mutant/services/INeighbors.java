package com.meli.mutant.services;

import java.util.List;
import java.util.Vector;

import com.meli.mutant.service.impl.Neighbors;
import com.meli.mutant.utils.Indexes;

public interface INeighbors {

	
	public Neighbors search(Vector<char[]> data, int i,int j);
	public List<Indexes> calculateIndexof(Vector<char[]> data, int i,int j);
	
	
}
