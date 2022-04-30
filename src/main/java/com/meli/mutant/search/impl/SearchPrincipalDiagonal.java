package com.meli.mutant.search.impl;

import java.util.Vector;

import com.meli.mutant.enums.Direction;
import com.meli.mutant.services.ISearch;

public class SearchPrincipalDiagonal implements ISearch{

	

	@Override
	public boolean search(char character, Vector<char[]> data, int i, int j, Direction dir,Integer coincidence,Integer minCoincidence) {	
       try {
			if(character==data.get(i)[j]){
	            	coincidence++;
	            	if(minCoincidence.equals(coincidence)) {
	            		return true;
	            	}else {
	            		if(dir.getValue()==1) //UP
	            		return this.search(character, data, i-1, j-1, dir, coincidence, minCoincidence);
	            		if(dir.getValue()==8) //DOWN
	            		return this.search(character, data, i+1, j+1, dir, coincidence, minCoincidence);
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
