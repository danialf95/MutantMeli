package com.meli.mutant.service.impl;


import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meli.mutant.search.impl.SearchHorizontal;
import com.meli.mutant.search.impl.SearchInverseDiagonal;
import com.meli.mutant.search.impl.SearchNeighbors;
import com.meli.mutant.search.impl.SearchPrincipalDiagonal;
import com.meli.mutant.search.impl.SearchVertical;
import com.meli.mutant.services.IMutant;
import com.meli.mutant.services.ISearch;
import com.meli.mutant.utils.Indexes;
@Component
public class MutantMeli implements IMutant{

@Autowired
SearchNeighbors searchNeighbors;

private final Integer mutation = 2;

	@Override
	public boolean isMutant(Vector<char[]> dna) {
		Integer countExistsPattern = 0;
		//Recorrido De la Matriz
		for (int i = 0; i < dna.size(); i++) {	
			for (int j = 0; j < dna.get(i).length; j++) {
				Neighbors vecinos = searchNeighbors.search(dna, i, j);
				if(vecinos.isExists())
				{
					ISearch searchRecursive=null;
					for (Indexes cs : vecinos.getIndexlist()) {
						
						Integer orientation= cs.getDirection().getValue();
						switch (orientation) {
							case 1:
							case 8:
								searchRecursive = new SearchPrincipalDiagonal();
								break;
							case 2:
							case 7:
								searchRecursive = new SearchVertical();
								break;
							case 3:
							case 6:
								searchRecursive = new SearchInverseDiagonal();
								break;
							case 4:
							case 5:
								searchRecursive = new SearchHorizontal();
								break;
						default:
							break;
						}				
						/*
						 Integer orientation= cs.getDirection().getValue();
						 if(orientation==1 ||orientation==8)
							  searchRecursive = new SearchPrincipalDiagonal();
						 if(orientation==2 ||orientation==7)
							  searchRecursive = new SearchVertical();
						 if(orientation==3 ||orientation==6)
							  searchRecursive = new SearchInverseDiagonal();
						 if(orientation==4 ||orientation==5)
							  searchRecursive = new SearchHorizontal();
						 */
						//System.out.println("Ocurrio Un error al encontrar la direccion de busqueda");
									//throw new RuntimeException("Ocurrio Un error al encontrar la direccion de busqueda");
						
						
						boolean coincidence = searchRecursive.search(dna.get(i)[j],dna,i,j,cs.getDirection(),0, 4);
						if(coincidence){ 							
								countExistsPattern++;
									if(countExistsPattern>this.mutation) {							
										return true;
									}
							}
				       }				
				   }
	  		}	
		}
		return false;
	}


	@Override
	public Vector<char[]> generateMatrix(String[] dna) {
		
		int normalize = dna[0].length(); 
		Vector<char[]> vector = new Vector<char[]>();
		Pattern pat = Pattern.compile("(A|C|G|T)+");
		Matcher mat = null;                                                                           
		for (String string : dna) 
			{
			    mat = pat.matcher(string.toUpperCase());
			     if(!mat.matches())
					throw new RuntimeException("Invalid genetic code");
				if(normalize != string.length())
					throw new RuntimeException("Invalid structure genetic code");
				
				
				char[] array = string.toCharArray();
				vector.add(array);
			}
		return vector;
	}

}