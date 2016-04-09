package tile;

import javax.swing.ImageIcon;

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
		
		//the sum of 0,1,2,3 is fixed which is equal to 6, 
		//if three of them are passed to x,y,z
		//the remainder 6-x-y-z will give the direction that will not open
		setImage(6-x-y-z);

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
	
/**
 * This method used to set image for three direction tile 
 * @param n indicate which direction is remained to be closed
 */
	private void setImage(int n){
		switch(n){
		case 0:
			_image.setIcon(new ImageIcon(getClass().getResource("/image/tile/T123.png")));
			break;
		case 1:
			_image.setIcon(new ImageIcon(getClass().getResource("/image/tile/T023.png")));
			break;
		case 2:
			_image.setIcon(new ImageIcon(getClass().getResource("/image/tile/T013.png")));
			break;
		case 3:
			_image.setIcon(new ImageIcon(getClass().getResource("/image/tile/T012.png")));
			break;
		}
	}

	
}
