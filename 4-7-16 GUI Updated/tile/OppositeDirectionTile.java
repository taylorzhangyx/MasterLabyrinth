package tile;

/**
 * This class is a sub class of Tile. It has a constructor method to 
 * create a opposite direction tile, and getter/setter methods to return/modify
 * values of objects in this class
 */
public class OppositeDirectionTile extends Tile {


	/**
	 * constructor OppositeDirectionTile, takes in 1 parameter of type integer
	 * 
	 * @param x integer shows the direction you want to open
	 * 0 or 2 means open north and south, 1 or 3 means open east and west
	 */
	public OppositeDirectionTile(int x) {
		_n = false;
		_e = false;
		_s = false;
		_w = false;
		initialization(x);
	}


	/**
	 * This method accepts one integer and opens the direction that the integer represents
	 * 0 or 2 means open north and south, 1 or 3 means open east and west
	 * 
	 * @param d the direction you want to open
	 */
	private void initialization(int d) {

		switch (d%2) {
		case 0:
			_n = true;
			_s = true;
			break;
		case 1:
			_e = true;
			_w = true;
			break;
		default:
			break;
		}

	}


}
