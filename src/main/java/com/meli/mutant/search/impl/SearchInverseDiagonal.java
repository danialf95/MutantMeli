package com.meli.mutant.search.impl;

import java.util.Vector;

import com.meli.mutant.enums.Direction;
import com.meli.mutant.services.ISearch;

public class SearchInverseDiagonal implements ISearch{

	@Override
	public boolean search(char caracter, Vector<char[]> data, int i, int j, Direction dir, Integer coincidence,
			Integer minCoincidence) {
		try {
			if(caracter==data.get(i)[j]){
	            	coincidence++;
	            	if(minCoincidence.equals(coincidence)) {
	            		return true;
	            	}else {
	            		if(dir.getValue()==3) //UP
	            		  return this.search(caracter, data, i-1, j+1, dir, coincidence, minCoincidence);
	            		if(dir.getValue()==6) //DOWN
	            		  return this.search(caracter, data, i+1, j-1, dir, coincidence, minCoincidence);
	            	}	
			     } else {
			    	  return false; 
			     }
        } catch (Exception e) {
   		// TODO: handle exception
    	  return false ;
        }
     return false;
	}




	
}
