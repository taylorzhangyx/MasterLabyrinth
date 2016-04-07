package tile;

/**
 * This class is a sub class of Tile. It has a constructor method to 
 * create a two direction tile, and getter/setter methods to return/modify
 * values of objects in this class
 */
public class TwoDirectionTileActural extends Tile {

	public TwoDirectionTileActural(int x) {
		_n = false;
		_e = false;
		_s = false;
		_w = false;
		initialization(x);
	}

	/**
	 * This method accepts one integer represents the type of this tile
	 * 0 represents, N & E is open, 1 represents, E & S is open, 2 represents, S & W is open
	 * 2 represents, S & W is open, 3 represents, W & N is open
	 * 
	 * @param d the type you want to define
	 */
	public void initialization(int d) {
//		d represents the type of this tile
		// 	d = 0 represents, N & E is open
		//	d = 1 represents, E & S is open
		//	d = 2 represents, S & W is open
		//	d = 3 represents, W & N is open
		switch (d){
			case 0:
				_n = true;
				_e = true;
				_s = false;
				_w = false;
				break;
			case 1:
				_n = false;
				_e = true;
				_s = true;
				_w = false;
				break;
			case 2:
				_n = false;
				_e = false;
				_s = true;
				_w = true;
				break;
			case 3:
				_n = true;
				_e = false;
				_s = false;
				_w = true;
				break;
			default:
				break;
		}
	}


	

}
