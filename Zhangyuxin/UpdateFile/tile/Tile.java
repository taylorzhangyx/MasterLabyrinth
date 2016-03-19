package tile;

import java.util.ArrayList;


import pawn.Pawn;

public abstract class Tile {
	private boolean _n;
	private boolean _e;
	private boolean _s;
	private boolean _w;
	//private boolean _hasPawn;
	//private Pawn _player;
	private String _color;
	//private boolean _hasToken;
	//private int x;
	//private int y;
	
	

	public Tile() {
		_n = false;
		_e = false;
		_s = false;
		_w = false;

	}

	public void initializeDirectionalIdentity() {

	}

	public void initializeDirectionArray() {

	}
	
	public boolean isNopen(){
		return _n;
	}
	public boolean isEopen(){
		return _e;
	}
	public boolean isSopen(){
		return _s;
	}
	public boolean isWopen(){
		return _w;
	}
	
	/*************************************************************/
	/*************************************************************/
	/******The following methods are the same in all tile class, maybe we can use only one in the tile?******/
	/******Cause the other three are extends. However I don't know how to do this******/
	/******Change it and make it simple, if you can******/
	/*************************************************************/
	/*************************************************************/
	
	/**void showDirection()**/
	/**This function gives the current status of this tile, output as String, in the form of **/
	/**"[N 'status'] [E 'status'] [S 'status'] [W 'status'] " where status replaced by false/true**/
	public void showDirection() {
		System.out.println("[N " + _n + "] [E " + _e + "] [S " + _s +"] [W " + _w);
		
	}
	
	/**void rotateClockwise()**/
	/**This function rotate this tile by one step clockwise**/
	public void rotateClockwise(){
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
	
	/**void rotate anticlockwiseClockwise()**/
	/**This function rotate this tile by one step anticlockwise**/
	public void rotateAntiClockwise(){
		boolean TEMP;
		TEMP = _e;
		_e = _s;
		_s = _w;
		_w = _n;
		_n = TEMP;		
	}
	
	public void rotateAntiClockwiseTwoTimes() {
		rotateAntiClockwise();
		rotateAntiClockwise();
	}
	public void rotateAntiClockwiseThreeTimes() {
		rotateAntiClockwise();
		rotateAntiClockwise();
		rotateAntiClockwise();
	}

}
