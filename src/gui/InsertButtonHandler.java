package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import board.Board;

/**
 * 
 * @author Yuxin Zhang
 * @update 上午10:40:052017年2月16日2017
 */
public class InsertButtonHandler implements ActionListener{
	private Board _board;
	private MainFrame _frame;
	private int _row;
	private int _column;
	public InsertButtonHandler(Board board, MainFrame frameTest, int row , int column) {
		_board = board;
		_frame = frameTest;
		_row = row;
		_column = column;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		_board.InsertTile(_row, _column, _board._freetile);
		//check the shiftsuccess in board, if true, do the next step
		//other wise, do nothing
		if(_board.ShiftingSuccess){
			_frame.update();
			_frame._gbp.disableInsertionButton();
			_frame._gfp.enablePawnMovingButtons();
			//reset ShiftingSuccess to false
			_board.ShiftingSuccess = false;
		}
		
	}

}
