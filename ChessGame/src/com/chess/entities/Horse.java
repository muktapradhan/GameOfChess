package com.chess.entities;

import java.util.ArrayList;
import java.util.List;

public class Horse implements Piece {

	@Override
	public List<Cell> findPossibleMoves(Cell cell) {
		List<Cell> cells = new ArrayList<>();
		cells.addAll(cell.findTwoAndHalfStepsCells());
			
		return cells;
	}
}
