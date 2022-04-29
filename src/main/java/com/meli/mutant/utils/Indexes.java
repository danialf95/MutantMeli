package com.meli.mutant.utils;

import com.meli.mutant.enums.Direction;

public class Indexes {

	
	
	Integer PositionI;
	Integer PositionJ;
	Integer MaxIndex;
    Direction Direction; 
	
    
    public Indexes ()
    {
    	
    }
	public Indexes(Integer positionI, Integer positionJ,Integer maxIndex,Direction direction) {
		super();
		PositionI = positionI;
		PositionJ = positionJ;
		MaxIndex =  maxIndex;
		Direction = direction;
	}
	public Integer getPositionI() {
		return PositionI;
	}
	public void setPositionI(Integer positionI) {
		PositionI = positionI;
	}
	public Integer getPositionJ() {
		return PositionJ;
	}
	public void setPositionJ(Integer positionJ) {
		PositionJ = positionJ;
	}
	
	public Direction getDirection() {
		return Direction;
	}
	public void setDirection(Direction direction) {
		Direction = direction;
	}
	
	
	public Integer getMaxIndex() {
		return MaxIndex;
	}
	public void setMaxIndex(Integer maxIndex) {
		MaxIndex = maxIndex;
	}
	public boolean InvalidIndexes() {
		if (this.PositionI <0 ||this.PositionJ <0)	
		{
			return true;
		} else if (this.PositionI >=this.MaxIndex ||this.PositionJ >=this.MaxIndex) {
			return true;
		}else 
		{
		    return false;
		}
	}
}
