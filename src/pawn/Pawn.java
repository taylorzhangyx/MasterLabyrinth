package pawn;

import java.util.ArrayList;

import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tile.*;

/**
 * Class for the Pawn that the player will use.
 * 
 *@author Aaron Schwab, Samuel White
 * 
 */
public class Pawn {
	private String _color;
	private boolean _onBoard;
	private boolean _myTurn;
	private int _score;
	private int _x;
	private int _y;
	private int _wand;
	private int _formulaCard;
	private static Pawn[] _pawnlist;
	private JLabel _image = new JLabel();

	/*
	 * Constructor for a Pawn.
	 * 
	 * @param color, xPos, yPos, _score, _onBoard,_myTurn _formulaCard
	 * 
	 */
	public Pawn(String color, int xPos, int yPos, int _formulaCard) {
		_color = color.toLowerCase();
		_x = xPos;
		_y = yPos;
		_score = 0;
		_onBoard = false;
		_myTurn = false;

		// the number of wand is fixed at the beginning of game, which is
		// initialized as 3
		_wand = 3;
		
		//set the image of this pawn, once the color is given, the image is fixed
		String path = new String();
		path = "/image/pawn/pawn" + _color + ".png";
		_image.setIcon(new ImageIcon(getClass().getResource(path)));
	}

	/*
	 * Generates a unique number from 1 to user provided bound. Utilizes an
	 * ArrayList to store values temporarily and then the values are inserted
	 * into an int[] that is then returned
	 * 
	 * @return uniqueInt[]
	 * 
	 */
	// get unique number from 1 to x
	private int[] generateXuniqueNumber(int n, int x) {
		int uniqueInt[] = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= x; i++) {
			list.add(new Integer(i));
		}
		Collections.shuffle(list);
		for (int i = 0; i < n; i++) {
			uniqueInt[i] = list.get(i);
		}
		return uniqueInt;
	}

	/*
	 * Getter method for the current value of the color field
	 * 
	 * @return _color
	 */
	public String getColor() {

		return _color;
	}

	/*
	 * Getter method that says if a pawn in on the board
	 *
	 * 
	 * @return _onBoard
	 */
	public boolean isOnBoard() {
		return _onBoard;
	}

	/*
	 * Getter method that says if the pawn has a turn
	 * 
	 * @return _myTurn
	 */
	public boolean myTurn() {
		return _myTurn;
	}

	/*
	 * Getter method for the current score of a player
	 * 
	 * @return _score
	 * 
	 */
	public int getScore() {
		return _score;
	}

	/*
	 * Getter method for the x position of the pawn on the board
	 * 
	 * 
	 * @return _x
	 */
	public int getXpos() {
		return _x;
	}

	/*
	 * Getter method for the y position of the pawn on the board
	 * 
	 * @return _y
	 * 
	 */
	public int getYpos() {
		return _y;
	}

	/*
	 * Set a pawn's current location
	 * 
	 * 
	 */
	public void setCoordinates(int x, int y) {
		_x = x;
		_y = y;
	}

	/*
	 * Getter method for number of current wands that a player has left
	 * 
	 * @return _wand
	 */
	public int getWandLeft() {
		return _wand;
	}

	/*
	 * Gets the formula card a player was assigned
	 *
	 * @return _formulaCard
	 * 
	 */
	public int getFormulaCard() {
		return _formulaCard;
	}

	/*
	 * Uses a player's wand.
	 * 
	 * @return boolean
	 */
	public boolean useWand() {
		if (_wand > 0) {
			_wand = _wand - 1;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Calculate player's score
	 * 
	 * @return void
	 * 
	 */
	public void setScore(int tokenValue) {
		_score = _score + tokenValue;
		// add functionality later that calculates if the token is a part of the
		// secret formula

	}
	
	public JLabel getImage(){
		return _image;
	}

}
