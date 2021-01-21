package com.chess.entities;

import java.util.List;

public interface Piece {
	List<Cell> findPossibleMoves(Cell cell);
}
