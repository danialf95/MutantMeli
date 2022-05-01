package com.meli.mutant.search.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Component;
import com.meli.mutant.enums.Direction;
import com.meli.mutant.service.impl.Neighbors;
import com.meli.mutant.services.INeighbors;
import com.meli.mutant.utils.Indexes;
@Component
public class SearchNeighbors implements INeighbors{

	public SearchNeighbors()
	{
		
	}
	
	@Override
	public Neighbors search(Vector<char[]> data, int i, int j) {
			
		 Neighbors neighbor = new Neighbors();
		 neighbor.setExists(false);
         List<Indexes> index = this.calculateIndexof(data, i, j);
         List<Indexes> neighbors =new ArrayList<Indexes>();
         for (Indexes indexes : index) {
			if(Character.compare(data.get(i)[j], data.get(indexes.getPositionI())[indexes.getPositionJ()])== 0) {
				neighbor.setExists(true);
				neighbors.add(indexes);
			}
			
		}
        neighbor.setIndexlist(neighbors);
		return neighbor;
	}

	@Override
	public List<Indexes> calculateIndexof(Vector<char[]> data, int i, int j) {
		
		List<Indexes> index = new ArrayList<Indexes>();
		Integer maxIndex = data.size();
		index.add(new Indexes(i-1, j-1,maxIndex,Direction.DIAGONAL_P_UP));
		index.add(new Indexes(i-1, j,maxIndex,Direction.VERTICAL_UP));
		index.add(new Indexes(i-1, j+1,maxIndex,Direction.DIAGONAL_I_UP));
		index.add(new Indexes(i, j-1,maxIndex,Direction.HORIZONTAL_LT));
		index.add(new Indexes(i, j+1,maxIndex,Direction.HORIZONTAL_RT));
		index.add(new Indexes(i+1, j-1,maxIndex,Direction.DIAGONAL_I_DW));
		index.add(new Indexes(i+1, j,maxIndex,Direction.VERTICAL_DW));
		index.add(new Indexes(i+1, j+1,maxIndex,Direction.DIAGONAL_P_DW));
		
        Iterator<Indexes> it = index.iterator();
			while (it.hasNext()) {
			    if (it.next().InvalidIndexes()) {
			        it.remove();
			    }
			}
			
		return index;
	}
	

}
