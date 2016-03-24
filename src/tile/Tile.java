package tile;

import java.util.ArrayList;

import pawn.Pawn;
import token.Token;

public abstract class Tile {

	protected boolean _n;
	protected boolean _e;
	protected boolean _s;
	protected boolean _w;
	protected boolean _hasPawn;
	protected int _numOfPawns;
	protected boolean _hasToken;
	protected int _tokenOnTile;
	protected int _x;
	protected int _y;
	ArrayList<String> pawnsOnTile = new ArrayList<String>(4);

	public Tile() {
		_n = false;
		_e = false;
		_s = false;
		_w = false;
		_hasPawn = false;
		// _pawnColors = null;
		_hasToken = false;
		_tokenOnTile = 0;
	}
	
	// getter method that returns if a tile has a pawn on it
	public boolean hasPawn() {
		return _hasPawn;
	}

	// getter method that returns how many pawns a tile has on it
	public int numOfPawns() {
		return pawnsOnTile.size();
	}

	// getter method that returns an array of String that lists the pawns on the
	// tile
	public ArrayList<String> pawnsOnTile() {
		return pawnsOnTile;
	}

	// Setter method that adds a pawn to the tile, sets true
	public void setPawns(String pawn) {
		pawnsOnTile.add(pawn);
		_hasPawn = true;
	}
//Setter method to erase a pawn off of a tile
	public void erasePawn(String pawn) {
		pawnsOnTile.remove(pawn);
		if(pawnsOnTile.size() == 0){
			_hasPawn = false;
		}
	}

	// Getter method that returns if a tile has a token on it
	public boolean hasToken() {
		return _hasToken;
	}

	// Getter method that returns the value of the token on the tile
	public int tokenOnTile() {
		return _tokenOnTile;
	}

	// Setter method that sets the value of the token on the tile, sets true
	public void setToken(int token) {
		_hasToken = true;
		_tokenOnTile = token;
	}

	public void eraseToken() {
		_hasToken = false;
		_tokenOnTile = 0;
	}

	// Method that returns a boolean array of the tile it is called on
	public boolean[] tileOrientation() {
		boolean[] orientation = new boolean[4];
		orientation[0] = _n;
		orientation[1] = _e;
		orientation[2] = _s;
		orientation[3] = _w;
		return orientation;
	}

	public boolean isNopen() {
		return _n;
	}

	public boolean isEopen() {
		return _e;
	}

	public boolean isSopen() {
		return _s;
	}

	public boolean isWopen() {
		return _w;
	}

	/** void showDirection() **/

	/**
	 * This function gives the current status of this tile, output as String, in
	 * the form of
	 **/
	/**
	 * "[N 'status'] [E 'status'] [S 'status'] [W 'status'] " where status
	 * replaced by false/true
	 **/
	public void showDirection() {
		System.out.println("[N " + _n + "] [E " + _e + "] [S " + _s + "] [W " + _w);

	}

	///// TODO
	public void setCoordinates(int x, int y) {
		_x = x;
		_y = y;
	}

	/** void rotateClockwise() **/
	/** This function rotate this tile by one step clockwise **/
	public void rotateClockwise() {
		boolean TEMP;
		TEMP = _w;
		_w = _s;
		_s = _e;
		_e = _n;
		_n = TEMP;
	}

	public void rotateClockwiseTwoTimes() {
		rotateClockwise();
		rotateClockwise();
	}

	public void rotateClockwiseThreeTimes() {
		rotateClockwise();
		rotateClockwise();
		rotateClockwise();
	}

	/** void rotate anticlockwiseClockwise() **/
	/** This function rotate this tile by one step counterclockwise **/
	public void rotateCounterClockwise() {
		boolean TEMP;
		TEMP = _e;
		_e = _s;
		_s = _w;
		_w = _n;
		_n = TEMP;
	}

	public void rotateCounterClockwiseTwoTimes() {
		rotateCounterClockwise();
		rotateCounterClockwise();
	}

	public void rotateCounterClockwiseThreeTimes() {
		rotateCounterClockwise();
		rotateCounterClockwise();
		rotateCounterClockwise();
	}

	public boolean[] hasNeighbor() {
		boolean[] neighbor = new boolean[4];
		// if()

		return null;
	}
	
	
	
	
	
	
	
	
	
	
	

}
