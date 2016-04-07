package tile;

import java.util.ArrayList;

import pawn.Pawn;
import token.Token;

/**
 * This class is the parent class called Tile. It has a constructor method to
 * set references to the instance variables. It has booleans that tell us if the
 * tile has a pawn, token, and its directions. There are instance variables of
 * type integer to keep track of the number of pawns and the token number. The
 * tile class also has x and y positions.
 */
public abstract class Tile {

	protected boolean _n;
	protected boolean _e;
	protected boolean _s;
	protected boolean _w;
	protected Token _token;
	protected boolean _hasPawn;
	protected int _numOfPawns;
	protected boolean _hasToken;
	protected int _tokenOnTile;
	protected int _x;
	protected int _y;
	private ArrayList<String> pawnsOnTile;
	

	/**
	 * This is the constructor of the tile class. It assigns values to the
	 * instance variables.
	 * 
	 */
	public Tile() {
		pawnsOnTile = new ArrayList<String>(4);
		_n = false;
		_e = false;
		_s = false;
		_w = false;
		_hasPawn = false;
		// _pawnColors = null;
		_hasToken = false;
		_tokenOnTile = 0;
		_numOfPawns = 0;
		_x = 0;
		_y = 0;
	}

	/**
	 * Getter method that returns a boolean indicating if a tile has a pawn on
	 * it.
	 * 
	 * @return Boolean is true if tile has pawn. False otherwise.
	 */
	public boolean hasPawn() {
		return _hasPawn;
	}

	/**
	 * Getter method that returns how many pawns a tile has on it.
	 * 
	 * @return int which represents how many pawns are on the tile.
	 */
	public int numOfPawns() {
		return pawnsOnTile.size();
	}

	/**
	 * Getter method that returns an arraylist of string that contains the color
	 * strings of the pawn.
	 * 
	 * @return ArrayList<String> an arraylist that has color strings
	 *         representing the pawns.
	 */

	public ArrayList<String> pawnsOnTile() {
		return pawnsOnTile;
	}

	/**
	 * Setter method that adds a pawn to the tile, sets _hasPawn to true.
	 * 
	 * @param pawn
	 *            a color string that represents the pawn.
	 */
	public void setPawns(String pawn) {
		pawnsOnTile.add(pawn.toLowerCase());
		_hasPawn = true;
	}

	/**
	 * Setter method to erase a pawn off of a tile. Sets the _hasPawn as false
	 * if the pawnsOnTile arraylist is empty.
	 * 
	 * @param pawn
	 *            a color string that represents the pawn.
	 */
	public void erasePawn(String pawn) {

		pawnsOnTile.remove(pawn.toLowerCase());
		if (pawnsOnTile.size() == 0) {
			_hasPawn = false;
		}
	}

	/**
	 * Getter method that checks if the tile has a token.
	 * 
	 * @return boolean which tells us if the tile has a token.
	 */
	public boolean hasToken() {
		return _hasToken;
	}

	/**
	 * Getter method that returns the value of the token on the tile.
	 * 
	 * @return int value representing the value of the token.
	 */
	public int tokenOnTile() {
		return _tokenOnTile;
	}

	/**
	 * Setter method that sets the value of the token on the tile, sets the has
	 * token boolean to true.
	 * 
	 * @param token
	 *            sets the token on the tile to the integer in the parameter.
	 */
	public void setToken(int tokenValue) {
		_hasToken = true;
		_token = new Token(tokenValue);
	}

	public Token getToken() {
		return _token;
	}

	/**
	 * Setter method that sets the value of the token to 0 and the boolean of
	 * the has token to false.
	 * 
	 */
	public void eraseToken() {
		_hasToken = false;
		_tokenOnTile = 0;
	}

	/**
	 * This method gives situation of N direction in this tile
	 * 
	 * @return boolean true means N is open, false otherwise
	 */
	public boolean isNopen() {
		return _n;
	}

	/**
	 * This method gives situation of E direction in this tile
	 * 
	 * @return boolean true means E is open, false otherwise
	 */
	public boolean isEopen() {
		return _e;
	}

	/**
	 * This method gives situation of S direction in this tile
	 * 
	 * @return boolean true means S is open, false otherwise
	 */
	public boolean isSopen() {
		return _s;
	}

	/**
	 * This method gives situation of W direction in this tile
	 * 
	 * @return boolean true means W is open, false otherwise
	 */
	public boolean isWopen() {
		return _w;
	}

	/**
	 * USED IN DEBUGGING Print out current direction of this tile
	 * 
	 */
	public void showDirection() {
		System.out.println("[N " + _n + "] [E " + _e + "] [S " + _s + "] [W " + _w);

	}

	/**
	 * This method returns an array of boolean that contains direction of N, E,
	 * S, W, respectively
	 * 
	 * @return boolean[] size of 4 indicate the directions of current tile, N,
	 *         E, S, W
	 */
	public boolean[] tileOrientation() {
		boolean[] orientation = new boolean[4];
		orientation[0] = _n;
		orientation[1] = _e;
		orientation[2] = _s;
		orientation[3] = _w;
		return orientation;
	}
	
	
	/**
	 * Store current location of this tile.
	 * 
	 * @param x
	 *            the row index of this tile
	 * @param y
	 *            the column index of this tile
	 */
	public void setCoordinates(int x, int y) {
		_x = x;
		_y = y;
	}

	/**
	 * this method returns the x index of current location of this tile
	 * 
	 * @return
	 */
	public int getX() {
		return _x;
	}

	/**
	 * this method returns the y index of current location of this tile
	 * 
	 * @return
	 */
	public int getY() {
		return _y;
	}

	/**
	 * This function rotates the tile clockwise
	 * 
	 * @return void
	 */
	public void rotateClockwise() {
		boolean TEMP;
		TEMP = _w;
		_w = _s;
		_s = _e;
		_e = _n;
		_n = TEMP;
	}

	/**
	 * This function rotates the tile counterclockwise
	 *
	 * @return void
	 */
	public void rotateCounterClockwise() {
		boolean TEMP;
		TEMP = _e;
		_e = _s;
		_s = _w;
		_w = _n;
		_n = TEMP;
	}

	/*
	 * Picks up a token off of a tile if it is available, changes the player's
	 * score, and removes token from tile
	 * 
	 * @parameter p , pawn that represents the player that is picking up the
	 * token
	 * 
	 * @return void
	 */
	public void pickUpToken(Pawn p) {
		if (this.hasToken()) {
			p.setScore(this.getToken().getTokenValue());
			this.eraseToken();
		}
	}

}
