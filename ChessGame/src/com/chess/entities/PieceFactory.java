package com.chess.entities;

public class PieceFactory {
	public static Piece getPiece(String pieceType) {
		if(pieceType.equalsIgnoreCase("King"))
			return new King();
		else if(pieceType.equalsIgnoreCase("Queen"))
			return new Queen();
		else if(pieceType.equalsIgnoreCase("Bishop"))
			return new Bishop();
		else if(pieceType.equalsIgnoreCase("Rook"))
			return new Rook();
		else if(pieceType.equalsIgnoreCase("Horse"))
			return new Horse();
		else if(pieceType.equalsIgnoreCase("Pawn"))
			return new Pawn();
		else 
			throw new IllegalArgumentException("Piece Type is not valid");
	}
}
