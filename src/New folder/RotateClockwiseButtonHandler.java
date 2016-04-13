package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;

public class RotateClockwiseButtonHandler implements ActionListener {
	private FrameTest _frameTest;
	private Board _board;

	public RotateClockwiseButtonHandler(Board board, FrameTest frameTest) {
		_frameTest = frameTest;
		_board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_board._freetile.rotateClockwise();
		_frameTest.update();
	}
}
