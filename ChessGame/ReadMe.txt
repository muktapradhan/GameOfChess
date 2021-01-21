This program represents Chess game
Input given is the type of piece and the cell on which that piece is 
Output - all the possible moves for that piece

Classes:
Game: Main application class which takes the piece type and cell number as input
Board: represents the Chess board. It has methods to find cells surrounding particular cell.
Cell: Represents particular cell.
Piece : Interface representing any piece on chess board
King, Queen, Rook, Horse, Bishop, Pawn - classes implementing Piece
PieceFactory: Factory class for creating Piece objects
ChessTester: class for testing different flows using JUnit 

Libraries added for Junit : junit-4.13.1.jar
			    hamcrest-core-1.3.jar 