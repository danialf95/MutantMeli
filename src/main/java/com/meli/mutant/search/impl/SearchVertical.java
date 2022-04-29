package com.meli.mutant.search.impl;

import java.util.Vector;

import com.meli.mutant.enums.Direction;
import com.meli.mutant.services.ISearch;

public class SearchVertical implements ISearch{

	@Override
	public boolean search(char caracter, Vector<char[]> data, int i, int j, Direction dir, Integer Coincidence,
			Integer minCoincidence) {
		 try {
				if(caracter==data.get(i)[j]){
		            	Coincidence++;
		            	if(minCoincidence==Coincidence) {
		            		return true;
		            	}else {
		            		if(dir.getValue()==2) //UP
		            		return this.search(caracter, data, i-1, j, dir, Coincidence, minCoincidence);
		            		if(dir.getValue()==7) //DOWN
		            		return this.search(caracter, data, i+1, j, dir, Coincidence, minCoincidence);
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