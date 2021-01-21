package com.chess.test;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chess.Game;
import com.chess.entities.Cell;

import junit.framework.TestCase;

public class ChessTester extends TestCase {
	public ChessTester(String name) {
		super(name);
	}
	public void testCaseForPawn() {
		List<String> expectedList = Arrays.asList("A4");
		String piece = "Pawn";
		String cellDetails = "A3";
		List<Cell> cells = Game.getPossibleMoves(piece, cellDetails);
		List<String> cellStrings = new ArrayList<>();
		cells.forEach(c -> cellStrings.add(c.toString()));
		assertEquals(1,cells.size());
		assertTrue(expectedList.containsAll(cellStrings) && cellStrings.containsAll(expectedList));
	}
	public void testCaseForPawn2() {
		List<String> expectedList = Arrays.asList();
		String piece = "Pawn";
		String cellDetails = "F8";
		List<Cell> cells = Game.getPossibleMoves(piece, cellDetails);
		List<String> cellStrings = new ArrayList<>();
		cells.forEach(c -> cellStrings.add(c.toString()));
		assertTrue(expectedList.size()== cellStrings.size() &&  expectedList.containsAll(cellStrings) && cellStrings.containsAll(expectedList));
	}
	public void testCaseExceptionCase1() {
		String piece = "Pawn";
		String cellDetails = "A9";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Game.getPossibleMoves(piece,cellDetails));
		String expectedMessage = "Cell number is not valid";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage,actualMessage);
	}
	public void testCaseExceptionCase2() {
		String piece = "Kiing";
		String cellDetails = "A1";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Game.getPossibleMoves(piece,cellDetails));
		String expectedMessage = "Piece Type is not valid";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage,actualMessage);
	}
	public void testCaseExceptionCase3() {
		String piece = "Pawn";
		String cellDetails = "I2";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Game.getPossibleMoves(piece,cellDetails));
		String expectedMessage = "Cell number is not valid";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage,actualMessage);
	}
	public void testCaseExceptionCase4() {
		String piece = "Pawn";
		String cellDetails = "A12";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> Game.getPossibleMoves(piece,cellDetails));
		String expectedMessage = "Cell number is not valid";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage,actualMessage);
	}
	
	public void testCaseForKing() {
		List<String> expectedList = Arrays.asList("C6","D6","E6","C5","E5","C4","D4","E4");
		String piece = "King";
		String cellDetails = "D5";
		List<Cell> cells = Game.getPossibleMoves(piece, cellDetails);
		List<String> cellStrings = new ArrayList<>();
		cells.forEach(c -> cellStrings.add(c.toString()));
		assertTrue(cellStrings.size() == expectedList.size() && expectedList.containsAll(cellStrings) && cellStrings.containsAll(expectedList));
	}
	public void testCaseForQueen() {
		List<String> expectedList = Arrays.asList("B1","C1","D1","E1","F1","G1","H1","A2","A3","A4","A5","A6","A7","A8","B2","C3","D4","E5","F6","G7","H8");
		String piece = "Queen";
		String cellDetails = "A1";
		List<Cell> cells = Game.getPossibleMoves(piece, cellDetails);
		List<String> cellStrings = new ArrayList<>();
		cells.forEach(c -> cellStrings.add(c.toString()));
		assertTrue(cellStrings.size() == expectedList.size() && expectedList.containsAll(cellStrings) && cellStrings.containsAll(expectedList));
	}
	public void testCaseForBishop() {
		List<String> expectedList = Arrays.asList("F1","H3","H1","F3","E4","D5","C6","B7","A8");
		String piece = "Bishop";
		String cellDetails = "G2";
		List<Cell> cells = Game.getPossibleMoves(piece, cellDetails);
		List<String> cellStrings = new ArrayList<>();
		cells.forEach(c -> cellStrings.add(c.toString()));
		assertTrue(cellStrings.size() == expectedList.size() && expectedList.containsAll(cellStrings) && cellStrings.containsAll(expectedList));
	}
	public void testCaseForHorse() {
		List<String> expectedList = Arrays.asList("D5","F5","G4","G2","F1","D1","C2","C4");
		String piece = "Horse";
		String cellDetails = "E3";
		List<Cell> cells = Game.getPossibleMoves(piece, cellDetails);
		List<String> cellStrings = new ArrayList<>();
		cells.forEach(c -> cellStrings.add(c.toString()));
		assertTrue(cellStrings.size() == expectedList.size() && expectedList.containsAll(cellStrings) && cellStrings.containsAll(expectedList));
	}
	public void testCaseForRook() {
		List<String> expectedList = Arrays.asList("A8","B8","D8","E8","F8","G8","H8","C1","C2","C3","C4","C5","C6","C7");
		String piece = "Rook";
		String cellDetails = "C8";
		List<Cell> cells = Game.getPossibleMoves(piece, cellDetails);
		List<String> cellStrings = new ArrayList<>();
		cells.forEach(c -> cellStrings.add(c.toString()));
		assertTrue(cellStrings.size() == expectedList.size() && expectedList.containsAll(cellStrings) && cellStrings.containsAll(expectedList));
	}
}
