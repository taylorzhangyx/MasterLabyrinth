package gameBoard;

import tile.*;
import pawn.*;
import token.*;


public class Boardpoint {
	private Tile _tile;
	private boolean _istoken;
	private Token _token;
	private boolean _reachable;
	
	public Boardpoint(){
		_istoken = false;
		_reachable = false;		
	}
	
	/**void assigntile (Tile _newtile)**/
	/**This method assign the _newtile to _tile**/
	public void assigntile (Tile _newtile){
		_tile = _newtile;
	}
	
	/**boolean isnull ()**/
	/**This method checks if this tile has value**/
	public boolean isnull (){
		return _tile == null;
	}
	
	public void printPoint(){
		_tile.showDirection();
		if (_istoken){
			System.out.println(" ");
			_token.showyourself();
		}
	}
}
