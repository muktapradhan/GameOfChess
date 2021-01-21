package com.chess.entities;

import java.util.ArrayList;
import java.util.List;

public class King implements Piece {

	@Override
	public List<Cell> findPossibleMoves(Cell cell) {
		List<Cell> cells = new ArrayList<>();
		cell.findCellOneStepForward().ifPresent(c -> cells.add(c));
		cell.findCellOneStepBackward().ifPresent(c -> cells.add(c));
		cell.findCellOneStepRight().ifPresent(c -> cells.add(c));
		cell.findCellOneStepLeft().ifPresent(c -> cells.add(c));
		cell.findCellOneStepDiagonalBackwardLeft().ifPresent(c -> cells.add(c));
		cell.findCellOneStepDiagonalBackwardRight().ifPresent(c -> cells.add(c));
		cell.findCellOneStepDiagonalForwardLeft().ifPresent(c -> cells.add(c));
		cell.findCellOneStepDiagonalForwardRight().ifPresent(c -> cells.add(c));
		return cells;
	}

}
