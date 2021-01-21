package com.chess.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cell {

	private int row;
	private int column;
	public Cell(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	@Override
	public String toString() {
		return "" + (char)column + "" + row ;
	}
	public Optional<Cell> findCellOneStepForward() {
		return Board.getInstance().getCellOneStepForward(row,column);
	}
	public Optional<Cell> findCellOneStepBackward() {
		return Board.getInstance().getCellOneStepBackward(row, column);
	}
	public Optional<Cell> findCellOneStepRight() {
		return Board.getInstance().getCellOneStepRight(row,column);
		
	}
	public Optional<Cell> findCellOneStepLeft() {

		return Board.getInstance().getCellOneStepLeft(row, column);
		
	}
	public Optional<Cell> findCellOneStepDiagonalForwardRight() {
		return Board.getInstance().getCellOneStepDiagonalForwardRight(row, column);
		
	}
	public Optional<Cell> findCellOneStepDiagonalForwardLeft() {
		return Board.getInstance().getCellOneStepDiagonalForwardLeft(row, column);
		
	}
	public Optional<Cell> findCellOneStepDiagonalBackwardRight() {
		return Board.getInstance().getCellOneStepDiagonalBackwardRight(row, column);
		
	}
	public Optional<Cell> findCellOneStepDiagonalBackwardLeft() {
		return Board.getInstance().getCellOneStepDiagonalBackwardLeft(row, column);
		
	}
	/**
	 * find all vertical cells for a particular cell
	 * @return
	 */
	public List<Cell> findVerticalCells() {
		List<Cell> cells = new ArrayList<>();
		Optional<Cell> currentCell = findCellOneStepForward();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepForward();
		}
		currentCell = findCellOneStepBackward();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepBackward();
		}
		return cells;
	}
	/**
	 * find all horizontal cells
	 * @return
	 */
	public List<Cell> findHorizontalCells() {
		List<Cell> cells = new ArrayList<>();
		Optional<Cell> currentCell = findCellOneStepRight();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepRight();
		}
		currentCell = findCellOneStepLeft();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepLeft();
		}
		return cells;
	}
	/** 
	 * Find all diagonal cells
	 * @return
	 */
	public List<Cell> findDiagonalCells() {
		List<Cell> cells = new ArrayList<>();
		Optional<Cell> currentCell = findCellOneStepDiagonalForwardRight();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepDiagonalForwardRight();
		}
		currentCell = findCellOneStepDiagonalForwardLeft();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepDiagonalForwardLeft();
		}
		currentCell = findCellOneStepDiagonalBackwardRight();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepDiagonalBackwardRight();
		}
		currentCell = findCellOneStepDiagonalBackwardLeft();
		while(currentCell.isPresent()) {
			cells.add(currentCell.get());
			currentCell = currentCell.get().findCellOneStepDiagonalBackwardLeft();
		}
		return cells;
	}
	public List<Cell> findTwoAndHalfStepsCells() {
		List<Cell> cells = new ArrayList<>();
		Optional<Cell> currentCell = findCellOneStepForward();
		if(currentCell.isPresent()) {
			currentCell.get().findCellOneStepDiagonalForwardRight().ifPresent(c -> cells.add(c));
			currentCell.get().findCellOneStepDiagonalForwardLeft().ifPresent(c -> cells.add(c));
		}
		currentCell = findCellOneStepRight();
		if(currentCell.isPresent()) {
			currentCell.get().findCellOneStepDiagonalForwardRight().ifPresent(c -> cells.add(c));
			currentCell.get().findCellOneStepDiagonalBackwardRight().ifPresent(c -> cells.add(c));
		}
		currentCell = findCellOneStepBackward();
		if(currentCell.isPresent()) {
			currentCell.get().findCellOneStepDiagonalBackwardLeft().ifPresent(c -> cells.add(c));
			currentCell.get().findCellOneStepDiagonalBackwardRight().ifPresent(c -> cells.add(c));
		}
		currentCell = findCellOneStepLeft();
		if(currentCell.isPresent()) {
			currentCell.get().findCellOneStepDiagonalForwardLeft().ifPresent(c -> cells.add(c));
			currentCell.get().findCellOneStepDiagonalBackwardLeft().ifPresent(c -> cells.add(c));
		}
		return cells;
	}
}
