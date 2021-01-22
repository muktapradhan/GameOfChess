package com.chess;

import java.util.List;
import java.util.Optional;

import com.chess.entities.Board;
import com.chess.entities.Cell;
import com.chess.entities.Piece;
import com.chess.entities.PieceFactory;

public class Game {

	public static void main(String args[]) {
		System.out.println("Enter type of piece - (King, Queen, Bishop, Horse, Rook, Pawn)");
		
		String typeOfPiece = System.console().readLine();
		System.out.println("Enter cell number");
		String cellDetails = System.console().readLine();
		List<Cell> cells = getPossibleMoves(typeOfPiece, cellDetails);
		System.out.println("Possible moves are:");
		cells.forEach(System.out::println);
		
	}
	/**
	 * Get possible moves for a particular type of piece and cell 
	 * @param typeOfPiece
	 * @param cellDetails
	 * @return
	 */
	public static List<Cell> getPossibleMoves(String typeOfPiece, String cellDetails) {
		Piece piece = PieceFactory.getPiece(typeOfPiece);
		Optional<Cell> cell = findCellFromCellDetails(cellDetails);
		List<Cell> cells = piece.findPossibleMoves(cell.get());
		return cells;
	}
	/** 
	 * Finds particular cell from the cell string while validating whether the cell string is proper
	 * @param cellDetails
	 * @return
	 */
	public static Optional<Cell> findCellFromCellDetails(String cellDetails) {
		int row;
		int column;
		if(cellDetails.length()==2) {
			column = cellDetails.substring(0,1).toUpperCase().charAt(0);
			System.out.println(column);
			row = Integer.parseInt(cellDetails.substring(1,2));
			if(column<65 || column> 72 || row<1 || row>8 ) {
				throw new IllegalArgumentException("Cell number is not valid");
			}
			
			
		} else {
			throw new IllegalArgumentException("Cell number is not valid");
		}
		Optional<Cell> cell = Board.getInstance().getCell(row, column);
		return cell;
	}
}
