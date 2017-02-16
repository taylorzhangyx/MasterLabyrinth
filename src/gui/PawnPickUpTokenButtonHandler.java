package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;
import pawn.Pawn;

public class PawnPickUpTokenButtonHandler implements ActionListener{
	Board _board;
	MainFrame _frame;
	Pawn _pawn;
	
	/*
	 * Constructor for PawnPickUpTokenButtonHandler
	 * 
	 */
	PawnPickUpTokenButtonHandler(Board board, MainFrame frame, Pawn pawn){
		_board = board;
		_frame = frame;
		_pawn = pawn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = _pawn.getXpos();
		int y = _pawn.getYpos();
		_board._gameBoard[x][y].pickUpToken(_pawn);
		_frame.incrementNextToken();
		_frame.updateScore();
		_frame.update();
		_frame._gbp.enableInsertionButton();
		_frame._gfp.disablePawnMovingButtons();
		_frame.nextPawn();
	}
}
