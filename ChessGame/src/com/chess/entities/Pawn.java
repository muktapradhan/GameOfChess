package com.chess.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pawn implements Piece {

	@Override
	public List<Cell> findPossibleMoves(Cell cell) {
		List<Cell> cells = new ArrayList<>();
		cell.findCellOneStepForward().ifPresent(c -> cells.add(c));
			
		return cells;
	}
}
