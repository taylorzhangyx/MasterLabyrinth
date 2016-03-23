package gameBoard;

import tile.*;
import pawn.*;
import token.*;


public class Boardpoint {
	private Tile _tile;
	private boolean _istoken;
	private Token _token;
	private boolean _reachable;
	private boolean _haspawn;
	private int _currentPawnNum ;
	//private Pawn _pawn;
	
	public Boardpoint(){
		_istoken = false;
		_reachable = false;	
		_haspawn = false;
		_currentPawnNum =0;
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
	
	public boolean isNopen(){
		return _tile.isNopen();
	}
	public boolean isEopen(){
		return _tile.isEopen();
	}
	public boolean isSopen(){
		return _tile.isSopen();
	}
	public boolean isWopen(){
		return _tile.isWopen();
	}
	
	public void printPoint(){
		_tile.showDirection();
		
		if (_istoken){
			System.out.println(" ");
			_token.showyourself();
		}
		if(_haspawn){
			System.out.printf(" PawnNum: %d" , _currentPawnNum);		
		}
		System.out.printf(" Reachable: "+ _reachable);
		
	}
	public void pawnMoveAway(){
		_currentPawnNum--;
		_reachable = false;
		if(_currentPawnNum<=0){
		_haspawn = false;}
		//_pawn = null;
	}
	
	public void pawnMoveIn(){
		_currentPawnNum++;
		_haspawn = true;
		//_pawn = null;
	}
	
	public boolean isReachable(){
		return _reachable;
	}
	
	/**
	 * 
	 **/
	public void resetReachable(){
		_reachable = true;
	}
	
	/**Tile currenttile()**/
	/**This method gives the tile info on this board point**/
	public Tile currenttile(){
		return _tile;
	}
}
