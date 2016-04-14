package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;
import pawn.Pawn;

public class PawnPickUpTokenButtonHandler implements ActionListener{
	Board _board;
	FrameTest _frameTest;
	Pawn _pawn;
	
	PawnPickUpTokenButtonHandler(Board board, FrameTest frameTest, Pawn pawn){
		_board = board;
		_frameTest = frameTest;
		_pawn = pawn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = _pawn.getXpos();
		int y = _pawn.getYpos();
		_board._gameBoard[x][y].pickUpToken(_pawn);
		_frameTest.updateScore();
		_frameTest.update();
	}
}
