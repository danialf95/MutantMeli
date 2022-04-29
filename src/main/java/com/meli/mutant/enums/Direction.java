package com.meli.mutant.enums;

public enum Direction {
	
	DIAGONAL_P_UP(1),
	VERTICAL_UP(2),
	DIAGONAL_I_UP(3),
	HORIZONTAL_LT(4),
	HORIZONTAL_RT(5),
	DIAGONAL_I_DW(6),
	VERTICAL_DW(7),
	DIAGONAL_P_DW(8);

	
    private final int value;

    private Direction(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Direction find(int value) {
        for (Direction dir : Direction.values())
            if (dir.value == value) return dir;

        return null;
    }

}
