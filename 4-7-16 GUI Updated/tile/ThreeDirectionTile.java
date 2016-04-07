package tile;

/**
 * This class is a sub class of Tile. It has a constructor method to 
 * create a 3 direction tile, and getter/setter methods to return/modify
 * values of objects in this class
 * 
 * 
 * */
public class ThreeDirectionTile extends Tile {
	
	/**
	 * This method Constructor for ThreeDirectionTile that takes in 3 arguments to
	 * open three directions. Initially the directions are set to 
	 * false and the method initialization is invoked to set specific values to true
	 * 
	 * @param x one direction you want to open
	 * @param y one direction you want to open
	 * @param z one direction you want to open
	 */
	public ThreeDirectionTile(int x, int y, int z) {
		_n = false;
		_e = false;
		_s = false;
		_w = false;
		initialization(x);
		initialization(y);
		initialization(z);

	}

	/**
	 * This method accepts one integer and opens the direction that the integer represents
	 * 0 means open north, 1 means open east, 2 means open south, 3 means open west
	 * 
	 * @param d the direction you want to open
	 */
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



	
}
