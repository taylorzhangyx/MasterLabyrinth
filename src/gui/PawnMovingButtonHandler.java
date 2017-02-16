package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;
import pawn.Pawn;

public class PawnMovingButtonHandler implements ActionListener{
	Board _board;
	MainFrame _frame;
	Pawn _pawn;
	String _direction;
	/*
	 * Constructor for PawnMovingButtonHandler
	 */
	PawnMovingButtonHandler(Board board, MainFrame frame, Pawn pawn, String direction){
		_board = board;
		_frame = frame;
		_pawn = pawn;
		_direction = direction;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(_board.moveOneStep(_direction, _pawn)){
			_frame.checkPickUpTokenButton();
			_frame.checkEndTurnButton();
			_frame.update();
			System.out.println(_pawn.getXpos());
			System.out.println(_pawn.getYpos());
		}
	}
}
