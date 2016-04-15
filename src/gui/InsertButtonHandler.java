package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;

public class InsertButtonHandler implements ActionListener{
	private Board _board;
	private FrameTest _frameTest;
	private int _row;
	private int _column;
	public InsertButtonHandler(Board board, FrameTest frameTest, int row , int column) {
		_board = board;
		_frameTest = frameTest;
		_row = row;
		_column = column;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		_board.InsertTile(_row, _column, _board._freetile);
		//check the shiftsuccess in board, if true, do the next step
		//other wise, do nothing
		if(_board.ShiftingSuccess){
			_frameTest.update();
			_frameTest._gbp.disableInsertionButton();
			_frameTest._gfp.enablePawnMovingButtons();
			//reset ShiftingSuccess to false
			_board.ShiftingSuccess = false;
		}
		
	}

}
