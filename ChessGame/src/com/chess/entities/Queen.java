package com.chess.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Queen implements Piece {

	@Override
	public List<Cell> findPossibleMoves(Cell cell) {
		List<Cell> cells = new ArrayList<>();
		cells.addAll(cell.findVerticalCells());
		cells.addAll(cell.findHorizontalCells());
		cells.addAll(cell.findDiagonalCells());
		return cells;
	}
}
