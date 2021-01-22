package com.chess.entities;

import java.util.Optional;

public class Board {
	private Cell cells[][] = new Cell[8][8];
	private static Board board;
	private Board() {
		generateCells();
		
	}
	public static Board getInstance() {
		if(board == null) {
			board = new Board();
		}
		return board;
	}
	private void generateCells() {
		for(int i = 0; i< 8; i++) {
			for(int j = 0; j<8; j++) {
				cells[i][j] = new Cell(i+1,j+65);
			}
		}
	}
	public Optional<Cell> getCell(int row, int column) {
		return Optional.of(cells[row-1][column-65]);
	}
	/**
	 * Method to get cell one step forward, returning empty optional if there are no possible moves
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepForward(int row, int column) {
		if(row == 8) 
			return Optional.empty();
		else 
		return getCell(row + 1, column);
	}
	/**
	 * Method to get cell one step backward, returning empty optional if there are no possible moves
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepBackward(int row, int column) {
		if(row == 1) 
			return Optional.empty();
		else
		return getCell(row - 1, column);
	}
	/**
	 * Method to get cell one step to the right, returning empty optional if there are no possible moves
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepRight(int row, int column) {
		if(column == 'H') 
			return Optional.empty();
		else
		return getCell(row, column+1);
	}
	/**
	 * Method to get cell one step to the left, returning empty optional if there are no possible moves
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepLeft(int row, int column) {
		if(column == 'A') 
			return Optional.empty();
		else
		return getCell(row, column-1);
	}
	/**
	 * Method to get cell one step diagonally forward to the right
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepDiagonalForwardRight(int row, int column) {
		if(column == 'H' || row == 8) 
			return Optional.empty();
		else
		return getCell(row + 1, column+1);
	}
	/**
	 * Method to get cell one step diagonally forward to the left
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepDiagonalForwardLeft(int row, int column) {
		if(column == 'A' || row == 8) 
			return Optional.empty();
		else
		return getCell(row + 1, column-1);
	}
	/**
	 * Method to get cell one step diagonally backward to the right
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepDiagonalBackwardRight(int row, int column) {
		if(column == 'H' || row == 1) 
			return Optional.empty();
		else
		return getCell(row - 1, column + 1);
	}
	/**
	 * Method to get cell one step diagonally backward to the left
	 * @param row
	 * @param column
	 * @return
	 */
	public Optional<Cell> getCellOneStepDiagonalBackwardLeft(int row, int column) {
		if(column == 'A' || row == 1) 
			return Optional.empty();
		else
		return getCell(row - 1, column - 1);
	}
}
