package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pawn.Pawn;

/**
 * 
 * @author Yuxin Zhang
 * @update 上午10:40:302017年2月16日2017
 */
public class MainFrame {
	public GameFunctionPanel _gfp;
	public GameBoardPanel _gbp;
	public Pawn _pawn;
	
	private ArrayList<JButton> _gfpb;
	private JFrame jfr;
	// current player
	private ArrayList<Pawn> _pawnlist;
	private int _pawnNumber;
	private int _currentPawnNum;
	private static final int startPawn = 0, startToken = 1;

	// store pawn coordinates to avoid land on the same starting place
	private int _pawn_x;
	private int _pawn_y;
	
	// remember token serials to keep picking up a token that is in order
	private int _nextToken;

	/**
	 * Based on given string build the data structure and the window
	 * @param names
	 */
	public MainFrame(String[] names) {

		//initialize game board panel
		init_gbp(names);
		
		// store how many pawns on the board
		_pawnNumber = names.length;
		// stores current pawn index
		_currentPawnNum = startPawn;
		// store all the pawn info into list
		setPawnList(names);
		
		//Initialize pawn
		initPawn(_currentPawnNum);

		// Initialize next expected token value
		_nextToken = startToken;
		
		//Initialize game function panel
		init_gfp();
		
		//build main frame
		buildWindow();
	}

	/**
	 * Initiate game function panel
	 * product the panel with buttons, action listeners and set the buttons to start status
	 */
	private void init_gfp() {
		
		// pass current pawn info to game function panel
		_gfp = new GameFunctionPanel(_pawn, _gbp);
		
		//Initialize game function panel button
		_gfpb = _gfp.getButtons();

		// adds functionality to the moving pawn buttons
		_gfpb.get(1).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "N"));
		_gfpb.get(3).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "W"));
		_gfpb.get(4).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "S"));
		_gfpb.get(5).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "E"));

		// adds functionality to pick up token method
		_gfpb.get(0).addActionListener(new PawnPickUpTokenButtonHandler(_gbp._board, this, _pawn));
		
		// adds functionality to end the turn button
		_gfpb.get(2).addActionListener(new PawnEndTurnHandler(this, _pawn));

		// adds functionality to the rotate buttons
		_gfpb.get(6).addActionListener(new RotateCounterClockwiseButtonHandler(_gbp._board, this));
		_gfpb.get(7).addActionListener(new RotateClockwiseButtonHandler(_gbp._board, this));
		
		//disable buttons
		_gfp.disablePawnMovingButtons();
	}

	/**
	 * Initialize the game board panel based on given names
	 * It constructs the board and add multiple action listeners into the panel
	 * 
	 * @param names
	 */
	private void init_gbp(String[] names) {
		_gbp = new GameBoardPanel(names);
		// adds ButtonHandler and actionListeners
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
	}
	
	/**
	 * Initialize the pawn which represents current player
	 * record pawn coordinates
	 * 
	 * @param pawnNum current pawn number
	 */

	private void initPawn(int pawnNum) {
		// when initialize, set pawn to the first player
		_pawn = _pawnlist.get(pawnNum);
		// remember the pawn coordinates
		_pawn_x = _pawn.getXpos();
		_pawn_y = _pawn.getYpos();
	}

	/**
	 * Build the main window, put game board panel in the center, game function panel on the right. Set exit option to EXIT_ON_CLOSE.
	 */
	private void buildWindow() {
		jfr = new JFrame();
		jfr.setLayout(new BorderLayout(5, 5));
		jfr.setSize(1302, 925);
		jfr.add(_gbp, BorderLayout.CENTER);
		jfr.add(_gfp, BorderLayout.EAST);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfr.setLocationRelativeTo(null);
		jfr.setVisible(true);
		jfr.setResizable(false);

	}

	/*
	 * Set the names passed into command line into _pawnlist
	 * 
	 * @return void
	 */
	private void setPawnList(String[] names) {
		_pawnlist = new ArrayList<Pawn>(names.length);
		switch (names.length) {
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

	/*
	 * Updates board
	 * 
	 * @return void
	 */
	public void update() {

		for (int i = 0; i < 7; i++) {
			for (int o = 0; o < 7; o++) {
				
				//extract the corresponding JLabel
				JLabel curr = _gbp.getLabels().get(7 * i + o);
				
				// clear all components on the JLabel
				curr.removeAll();
				curr.setIcon(_gbp._board._gameBoard[i][o].getIcon());
				curr.add(_gbp.setPawnAndTokenImageOnTile(i, o));
				curr.validate();
				curr.repaint();
				
			}
		}
		
		_gbp._board._freetile.refreshImage();
		_gfp.freeTile.setIcon(_gbp._board._freetile.getIcon());
	}

	/*
	 * Sets next pawn,updates pawns, sets position
	 * 
	 * @return void
	 */
	public void nextPawn() {
		// change to next index
		_currentPawnNum++;
		// if current pawn number overflow, reset this number
		if (_currentPawnNum == _pawnNumber) {
			_currentPawnNum = 0;
		}
		
		//switch pawn to next player
		initPawn(_currentPawnNum);
		_gfp.switchPawn(_pawn);
		
		//update buttons
		refreshPawnMovingButton();
	}
/*
 * Update player's score
 * 
 * @return void
 * 
 */
	public void updateScore() {
		_gfp.setScore();

	}
/*
 * Refresh pawn actionListeners, replace with new actionListeners
 * 
 * return void
 */
	private void refreshPawnMovingButton() {
		// remove action listener inside the 6 buttons
		for (int i = 0; i < 6; i++) {
			this._gfpb.get(i).removeActionListener(_gfpb.get(i).getActionListeners()[0]);
		}

		// add new listener to buttons
		_gfpb.get(1).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "N"));
		_gfpb.get(2).addActionListener(new PawnEndTurnHandler(this, _pawn));
		_gfpb.get(3).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "W"));
		_gfpb.get(4).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "S"));
		_gfpb.get(5).addActionListener(new PawnMovingButtonHandler(_gbp._board, this, _pawn, "E"));
		_gfpb.get(0).addActionListener(new PawnPickUpTokenButtonHandler(_gbp._board, this, _pawn));

	}
	
	/*
	 * Checks pickUp token, if current pawn position has a valid token, enable pick up, otherwise, disable
	 * 
	 * @return void
	 */
	public Void checkPickUpTokenButton() {
		int pawn_x = _pawn.getXpos();
		int pawn_y = _pawn.getYpos();

		if (pawn_x == this._pawn_x && pawn_x == this._pawn_y) {
			_gfpb.get(0).setEnabled(false);
		} else if (_gbp._board._gameBoard[pawn_x][pawn_y].hasToken()) {
			if (_nextToken == _gbp._board._gameBoard[pawn_x][pawn_y].getToken().getTokenValue()) {
				_gfpb.get(0).setEnabled(true);
				return null;
			}
		}
		_gfpb.get(0).setEnabled(false);
		return null;
	}
	
	/*
	 * Adds button that player can use to end turn. 
	 * 
	 * @return void
	 */
	public void checkEndTurnButton() {
		if (_pawn.getXpos() == _pawn_x && _pawn.getYpos() == _pawn_y) {
			_gfpb.get(2).setEnabled(false);
		} else {
			_gfpb.get(2).setEnabled(true);
		}
	}
	
	/**
	 * this method is called every time after picking up a token
	 */
	public void incrementNextToken(){
		_nextToken++;
		if(_nextToken==21){
			_nextToken = 25;
		}
		if(_nextToken == 26)
		gameOver();
	}
	
	/**
	 * this method is called after picking up a token to check if it's the end of game
	 * this method will trigger only if no token left 
	 */
	public void gameOver(){
		JFrame over = new JFrame("The End");
		over.setLayout(new GridLayout(0,1));
		Pawn p1 = _gbp._board.getPawn("red");
		Pawn p2 = _gbp._board.getPawn("yellow");
		Pawn p3 = _gbp._board.getPawn("blue");
		Pawn p4 = _gbp._board.getPawn("white");
		
		over.add(new MessagePanel(p1.getName()+ " : " + p1.getScore()));
		over.add(new MessagePanel(p2.getName()+ " : " + p2.getScore()));
		over.add(new MessagePanel(p3.getName()+ " : " + p3.getScore()));
		over.add(new MessagePanel(p4.getName()+ " : " + p4.getScore()));
		
		over.setBounds(300, 300, 200, 200);
		over.setVisible(true);
		over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
