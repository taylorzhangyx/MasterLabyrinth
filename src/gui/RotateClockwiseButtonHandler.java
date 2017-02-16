package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;

public class RotateClockwiseButtonHandler implements ActionListener {
	private MainFrame _frame;
	private Board _board;
/*
 * Constructor for RotateClockwiseButtonHandler
 */
	public RotateClockwiseButtonHandler(Board board, MainFrame frame) {
		_frame = frame;
		_board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_board._freetile.rotateClockwise();
		_frame.update();
	}
}
