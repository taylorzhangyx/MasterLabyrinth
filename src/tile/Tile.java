package tile;

import java.util.ArrayList;

import pawn.Pawn;

public abstract class Tile {
	private boolean _n;
	private boolean _e;
	private boolean _s;
	private boolean _w;
	private String _color;
	private boolean _hasToken;
	private int[] _tokensOnTile;
	
	private int _x;
	private int _y;

	public Tile() {
		_n = false;
		_e = false;
		_s = false;
		_w = false;

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

	/*************************************************************/
	/*************************************************************/
	/******
	 * The following methods are the same in all tile class, maybe we can use
	 * only one in the tile?
	 ******/
	/******
	 * Cause the other three are extends. However I don't know how to do this
	 ******/
	/****** Change it and make it simple, if you can ******/
	/*************************************************************/
	/*************************************************************/

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
	
	
	
	
/////TODO 
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
//if()
	
		return null;
	}

}
