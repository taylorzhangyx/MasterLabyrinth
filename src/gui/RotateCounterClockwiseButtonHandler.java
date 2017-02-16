package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;

public class RotateCounterClockwiseButtonHandler implements ActionListener {
	private MainFrame _frame;
	private Board _board;
/*
 * Constructor for RotateCounterClockwiseButtonHandler
 */
	public RotateCounterClockwiseButtonHandler(Board board, MainFrame frame) {
		_frame = frame;
		_board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_board._freetile.rotateCounterClockwise();
		_frame.update();
	}

}
