package tile;

/* 
 * This class is a sub class of Tile. It has a constructor method to 
 * create a 3 direction tile, and getter/setter methods to return/modify
 * values of objects in this class
 * 
 * 
 * */
public class ThreeDirectionTile extends Tile {
	private boolean _n;
	private boolean _e;
	private boolean _s;
	private boolean _w;

	// Constructor for ThreeDirectionTile that takes in 3 arguments for
	// which directions the tile has available. Initially the directions are set to 
	//false and the method initialization is invoked to set specific values to true
	public ThreeDirectionTile(int x, int y, int z) {
		_n = false;
		_e = false;
		_s = false;
		_w = false;
		initialization(x);
		initialization(y);
		initialization(z);

	}

	// method to initialize direction of tile
	public void initialization(int d) {
		// d represents the direction of this tile
		switch (d) {
		case 0:
			_n = true;
			break;
		case 1:
			_e = true;
			break;
		case 2:
			_s = true;

			break;
		case 3:
			_w = true;
			break;
		default:
			break;
		}
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

	// Rotates tile piece around 2 clockwise
	public void rotateClockwiseTwoTimes() {
		rotateClockwise();
		rotateClockwise();
	}

	// rotates tile piece around clockwise 3 times
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
}