package com.meli.mutant.services;


import java.util.Vector;
import com.meli.mutant.enums.Direction;


public interface ISearch {

	public boolean search(char caracter,Vector<char[]> data, int i,int j,Direction dir,Integer Coincidence,Integer minCoincidence);
	
}
