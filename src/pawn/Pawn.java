package pawn;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class for the Pawn that the player will use.
 * @edit Yuxin Zhang Feb.2017
 * @author Aaron Schwab, Samuel White
 * 
 */
public class Pawn {
	private String _color;
	private String _name;
	private boolean _onBoard;
	private boolean _myTurn;
	private int _score;
	private int _x;
	private int _y;
	private int _wand;
	private int _formulaCard;
//	private static Pawn[] _pawnlist;
	private JLabel _image = new JLabel();

	/*
	 * Constructor for a Pawn.
	 * 
	 * @param color, xPos, yPos, _score, _onBoard,_myTurn _formulaCard
	 * 
	 */
	public Pawn(String color, int xPos, int yPos, int _formulaCard) {
		_color = color.toLowerCase();
//		ADD NAME TO THIS PAWN SO THAT EACH PAWN HAS NAME TO DISPLAY
		_name = color.toLowerCase();
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
	
	/**
	 * 
	 * @return
	 */
	public JLabel getImage(){
		return _image;
	}

	public String getName() {
		return _name;
	}
	
	public void setName(String name){
		_name = name;
	}
}
