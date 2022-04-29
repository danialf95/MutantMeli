package com.meli.mutant.service.impl;

import java.util.List;

import com.meli.mutant.utils.Indexes;

public class Neighbors {

	
	boolean exists;
	List<Indexes> indexlist;
	
	public boolean isExists() {
		return exists;
	}
	public void setExists(boolean exists) {
		this.exists = exists;
	}
	public List<Indexes> getIndexlist() {
		return indexlist;
	}
	public void setIndexlist(List<Indexes> indexlist) {
		this.indexlist = indexlist;
	}
	
	
}
