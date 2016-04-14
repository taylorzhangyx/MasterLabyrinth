package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;
import pawn.Pawn;

public class PawnMovingButtonHandler implements ActionListener{
	Board _board;
	FrameTest _frameTest;
	Pawn _pawn;
	String _direction;
	
	PawnMovingButtonHandler(Board board, FrameTest frameTest, Pawn pawn, String direction){
		_board = board;
		_frameTest = frameTest;
		_pawn = pawn;
		_direction = direction;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(_board.moveOneStep(_direction, _pawn)){
			_frameTest.checkPickUpTokenButton();
			_frameTest.checkEndTurnButton();
			_frameTest.update();
			System.out.println(_pawn.getXpos());
			System.out.println(_pawn.getYpos());
		}
	}
}
