package tile;

/*
 * This class is a sub class of Tile. It has a constructor method to 
 * create a two direction tile, and getter/setter methods to return/modify
 * values of objects in this class
 */
public class TwoDirectionTile extends Tile {

	public TwoDirectionTile(int x, int y) {
		_n = false;
		_e = false;
		_s = false;
		_w = false;
		initialization(x);
		initialization(y);
	}

	// method to set the direction of the tile
	public void initialization(int d) {
		// d represents the orientation of this tile
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

	/*
	
	public void rotateClockwiseTwoTimes() {
		rotateClockwise();
		rotateClockwise();
	}

	public void rotateClockwiseThreeTimes() {
		rotateClockwise();
		rotateClockwise();
		rotateClockwise();
	}

*/

	/** void rotate anticlockwiseClockwise() **/
	/** This function rotate this tile by one step counter clockwise **/
	public void rotateCounterClockwise() {
		boolean TEMP;
		TEMP = _e;
		_e = _s;
		_s = _w;
		_w = _n;
		_n = TEMP;
	}

	/*
	
	public void rotateCounterClockwiseTwoTimes() {
		rotateCounterClockwise();
		rotateCounterClockwise();
	}

	public void rotateCounterClockwiseThreeTimes() {
		rotateCounterClockwise();
		rotateCounterClockwise();
		rotateCounterClockwise();
	}
	
	*/

}
