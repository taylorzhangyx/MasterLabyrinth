package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import pawn.Pawn;

public class FrameTest {
	public static GameFunctionPanel _gfp;
	public static GameBoardPanel _gbp;
	private static ArrayList<JButton> _gfpb;
	private static JFrame jfr;
	//current player
	private static ArrayList<Pawn> _pawnlist;
	public static Pawn _pawn;
	private static int _pawnNumber;
	private static int _currentPawnNum;
	
	//store pawn coordinates to avoid land on the same starting place
	private int _pawn_x;
	private int _pawn_y;
	//remember token serials to keep picking up a token that is in order
	private int _nextToken;

		public FrameTest(String[] names){
			
			_gbp = new GameBoardPanel(names);
			
			//store how many pawns on the board
			_pawnNumber = names.length;
			//stores current pawn index
			_currentPawnNum = 0;
			//store all the pawn info into list
			setPawnList(names);
			//when initialize, set pawn to the first player
			_pawn = _pawnlist.get(_currentPawnNum);
			//remeber the pawn coordinates
			_pawn_x = _pawn.getXpos();
			_pawn_y = _pawn.getYpos();
			//pass current pawn info to game function panel
			_gfp = new GameFunctionPanel(_pawn);
			
			//Initialize next expected token value
			_nextToken = 1;
			
			jfr = new JFrame();
			jfr.setLayout(new BorderLayout(5,5));
			jfr.setSize(1302, 925);
			jfr.add(_gbp, BorderLayout.CENTER);
			jfr.add(_gfp, BorderLayout.EAST);
			jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jfr.setLocationRelativeTo(null);
			jfr.setVisible(true);
			jfr.setResizable(false);
			_gfpb = _gfp.getButtons();
			
			//adds functionality to the insert buttons
			_gbp.getButtons().get(0).addActionListener(new InsertButtonHandler(_gbp._board, this, 0, 1));
			_gbp.getButtons().get(1).addActionListener(new InsertButtonHandler(_gbp._board, this, 0, 3));
			_gbp.getButtons().get(2).addActionListener(new InsertButtonHandler(_gbp._board, this, 0, 5));
			_gbp.getButtons().get(3).addActionListener(new InsertButtonHandler(_gbp._board, this, 1, 6));
			_gbp.getButtons().get(4).addActionListener(new InsertButtonHandler(_gbp._board, this, 3, 6));
			_gbp.getButtons().get(5).addActionListener(new InsertButtonHandler(_gbp._board, this, 5, 6));
			_gbp.getButtons().get(6).addActionListener(new InsertButtonHandler(_gbp._board, this, 6, 1));
			_gbp.getButtons().get(7).addActionListener(new InsertButtonHandler(_gbp._board, this, 6, 3));
			_gbp.getButtons().get(8).addActionListener(new InsertButtonHandler(_gbp._board, this, 6, 5));
			_gbp.getButtons().get(9).addActionListener(new InsertButtonHandler(_gbp._board, this, 1, 0));
			_gbp.getButtons().get(10).addActionListener(new InsertButtonHandler(_gbp._board, this, 3, 0));
			_gbp.getButtons().get(11).addActionListener(new InsertButtonHandler(_gbp._board, this, 5, 0));
			
			//adds functionality to the moving pawn buttons
			_gfpb.get(1).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"N"));
			_gfpb.get(3).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"W"));
			_gfpb.get(4).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"S"));
			_gfpb.get(5).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"E"));
			
			//adds functionality to pick up token method
			_gfpb.get(0).addActionListener(new PawnPickUpTokenButtonHandler(_gbp._board,this,_pawn));
			//adds functionality to end the turn button
			_gfpb.get(2).addActionListener(new PawnEndTurnHandler(this,_pawn));
			
			//adds functionality to the rotate buttons
			_gfpb.get(6).addActionListener(new RotateCounterClockwiseButtonHandler(_gbp._board,this));
			_gfpb.get(7).addActionListener(new RotateClockwiseButtonHandler(_gbp._board,this));
			_gfp.disablePawnMovingButtons();			
		}
		

	private void setPawnList(String[] names) {
		_pawnlist = new ArrayList<Pawn>();
			switch (names.length){
			case 4:
				_pawnlist.add(_gbp._board.getPawn("red"));
				_pawnlist.add(_gbp._board.getPawn("yellow"));
				_pawnlist.add(_gbp._board.getPawn("blue"));
				_pawnlist.add(_gbp._board.getPawn("white"));
				break;
			case 3:
				_pawnlist.add(_gbp._board.getPawn("red"));
				_pawnlist.add(_gbp._board.getPawn("yellow"));
				_pawnlist.add(_gbp._board.getPawn("blue"));
				break;
			case 2:
				_pawnlist.add(_gbp._board.getPawn("red"));
				_pawnlist.add(_gbp._board.getPawn("yellow"));
				break;
				
			}
		}


	public static void update() {
		
		for (int i=0; i<7;i++){
			for(int o = 0;o<7;o++){
				//clear all components on the JLabel
				_gbp.getLabels().get(7*i+o).removeAll();
				
				_gbp.getLabels().get(7*i+o).setIcon(_gbp._board._gameBoard[i][o].getIcon());
				_gbp.getLabels().get(7*i+o).add(GameBoardPanel.setPawnAndTokenImageOnTile(i,o));
				_gbp.getLabels().get(7*i+o).validate();
				_gbp.getLabels().get(7*i+o).repaint();
				
			}
		}
		
		_gbp._board._freetile.refreshImage();
		_gfp.freeTile.setIcon(_gbp._board._freetile.getIcon());
	}
	
	
	
	public void nextPawn() {
		//change to next index
		_currentPawnNum++;
		//if current pawn number overflow, reset this number
		if(_currentPawnNum == _pawnNumber){_currentPawnNum = 0;}
		_pawn = _pawnlist.get(_currentPawnNum);
		_gfp.switchPawn(_pawn);
		_pawn_x = _pawn.getXpos();
		_pawn_y = _pawn.getYpos();
		refreshPanwMovingButton();
	}


	public void updateScore() {
		_gfp.setScore();
		
	}
	
	private void refreshPanwMovingButton(){
		//remove action listener inside the 6 buttons
		for(int i = 0; i<6; i++){
			this._gfpb.get(i).removeActionListener(_gfpb.get(i).getActionListeners()[0]);
		}

		//add new listener to buttons
		_gfpb.get(1).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"N"));
		_gfpb.get(2).addActionListener(new PawnEndTurnHandler(this,_pawn));
		_gfpb.get(3).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"W"));
		_gfpb.get(4).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"S"));
		_gfpb.get(5).addActionListener(new PawnMovingButtonHandler(_gbp._board,this,_pawn,"E"));
		_gfpb.get(0).addActionListener(new PawnPickUpTokenButtonHandler(_gbp._board,this,_pawn));
		
		
	}
	
	public void checkPickUpTokenButton(){
		
	}
	
	public void checkEndTurnButton(){
		if(_pawn.getXpos()==_pawn_x && _pawn.getYpos()==_pawn_y){
			_gfpb.get(2).setEnabled(false);
		}
		else{
			_gfpb.get(2).setEnabled(true);
		}
	}
}
