package com.meli.mutant.search.impl;

import java.util.Vector;

import com.meli.mutant.enums.Direction;
import com.meli.mutant.services.ISearch;

public class SearchVertical implements ISearch{

	@Override
	public boolean search(char caracter, Vector<char[]> data, int i, int j, Direction dir, Integer coincidence,
			Integer minCoincidence) {
		 try {
				if(caracter==data.get(i)[j]){
		            	coincidence++;
		            	if(minCoincidence.equals(coincidence)) {
		            		return true;
		            	}else {
		            		if(dir.getValue()==2) //UP
		            		  return this.search(caracter, data, i-1, j, dir, coincidence, minCoincidence);
		            		if(dir.getValue()==7) //DOWN
		            		  return this.search(caracter, data, i+1, j, dir, coincidence, minCoincidence);
		            	}	
				     } else {
				    	  return false; 
				     }
	        } catch (Exception e) {
	    	  return false ;
	        }
	     return false;	
		 }

}