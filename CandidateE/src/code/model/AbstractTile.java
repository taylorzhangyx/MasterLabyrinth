package code.model;

import java.util.ArrayList;



import code.model.Token;

/**
 * This class is an abstract tile class that holds the common
 * instance variables and methods of the MoveableTile and
 * FixedTile classes. 
 * 
 * @author Satya, Ian (03-15-16)
 * @update By Yuxin Zhang (04-29-16) add _tileType and _orientation
 */

public abstract class AbstractTile {
	
	/**
	 * reference to ArrayList of players currently on this tile
	 */
	protected ArrayList<Player> _players;
	
	/**
	 * reference to token object currently on this tile (if any).
	 */
	protected Token _token;
	
	/**
	 * Int value (1 or 0) corresponding to top connecting edge of the tile. 
	 * 1 if it connects and 0 if it does not.
	 */
	protected int _top;
	
	/**
	 * Int value (1 or 0) corresponding to bottom connecting edge of the tile.
	 * 1 if it connects and 0 if it does not.
	 */
	protected int _bottom;
	
	/**
	 * Int value (1 or 0) corresponding to the right connecting edge of the tile. 
	 * 1 if it connects and 0 if it does not.
	 */
	protected int _right;
	
	/**
	 * Int value (1 or 0) corresponding to bottom connecting edge of the tile.
	 * 1 if it connects and 0 if it does not.
	 */
	protected int _left;
	
	/**
	 * true if this tile has had directions set, false if not
	 */
	protected boolean _initialized;
	
	protected String _tileType;
	
	protected int _orientation;
	
	//protected int _rotationTotal;
	
	/**
	 * Parameterless constructor of AbstractTile class. Assigns newly created ArrayList of type
	 * Player to _players instance variable.
	 * @author Satya, Ian (03-15-16)
	 */
	public AbstractTile(){
		_players = new ArrayList<Player>();
		_initialized = false;
	}
	
	/**
	 * Constructor of AbstractTile class with String identity as parameter.  The constructor
	 * calls the setDirections method and initializes the _top, _bottom, _right, and _left
	 * instance variables each with either a 0 or 1, depending on the String input.  Assigns newly created ArrayList of type
	 * Player to _players instance variable.  
	 * 
	 * @param identity the capital letter ("T", "L", or "I") corresponding to the connections
	 * a tile has. These letters represent the closest approximation to the connections the tile
	 * has based on the letter's visual appearance (e.g., a "T"-tile has 3 connections, just as
	 * a T has three points, two on top edge and on at bottom.
	 * 
	 * @author Ian, Satya 03-15-16
	 */
	public AbstractTile(String identity){
		_players = new ArrayList<Player>();
		_tileType = identity;
		if (identity == "T"){
			setDirections(1,0,1,1);
			_orientation = 2;
		}
		if (identity == "L"){
			setDirections(1,0,0,1);
			_orientation = 3;
		}
		if (identity == "I"){
			setDirections(0,0,1,1);
			_orientation =1;
		}
	}
	
	/**
	 * This method assigns a reference to a Token object to the
	 * instance variable _token. 
	 * 
	 * @param t the reference to a Token object assigned to instance
	 * 			variable _token.
	 *  
	 * @author Satya, Ian (03-15-16)
	 */
	public boolean setToken(Token t){
		if(!this.hasToken()){
			_token = t;
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns a reference to the Token object currently 
	 * residing on this tile.  
	 * 
	 * @return the reference to the Token object on the tile  
	 * 
	 * @author Satya, Ian (03-15-16)
	 */
	public Token getToken(){
		return _token;
	}
	
	/**
	 * This method returns true if the tile currently has a token on it
	 * and false if it does not.  
	 * 
	 * @return 	true if the tile has a token on it and false if it does not
	 *
	 * @author Satya, Ian (03-15-16)
	 */
	public boolean hasToken(){
		return (_token!=null);
	}
	
	/**
	 * Removes the token from this tile (if any) and returns the value of the reference to the token.
	 * @return the reference to the token object on this tile (or null if none)
	 * @author Satya, Ian (03-15-16)
	 */
	public Token removeToken(){
		Token temp = _token;
		_token = null;
		return temp;
	}
	
	/**
	 * This method returns true if the tile currently has at least one player on it
	 * and false if it does not.  
	 * 
	 * @return 	true if the tile has at least one player, false otherwise
	 * 
	 * @author Ken,Weijin,Ian (03-17-16)
	 */
	public boolean hasPlayer(){
		return (_players.size() > 0);
	}
	
	/**
	 * This method assigns to the instance variables _top, _bottom, _left,
	 * and _right values of 1 or 0.  A 1 corresponds to the tile having
	 * a connection on the edge assigned a 1; a 0 corresponds to no
	 * connection on that edge.  Method first checks if the arguments passed
	 * correspond to legal inputs by calling the checkLegalDirectionsInput method.  
	 * 
	 * @param t value of 1 or 0 assigned to _top inst. variable
	 * @param b value of 1 or 0 assigned to _bottom inst. variable
	 * @param l value of 1 or 0 assigned to _left inst. variable
	 * @param r value of 1 or 0 assigned to _right inst. variable
	 * 
	 * @return true if the directions were successfully set for the tile and false if not
	 * 
	 * @author Satya, Ian (03-15-16)
	 * @comment This method is only allowed to run once because of checking of _initializaed
	 */
	public boolean setDirections(int t, int b, int l, int r){
		if(checkLegalDirectionsInput(t,b,l,r) && !_initialized){	
			_top = t;
			_bottom = b; 
			_left = l;
			_right = r;
			_initialized = true;
			return true;
		}
		return false;
	}
	
	
	/**
	 * This method checks if the parameters t, b, l, and r correspond to
	 * a tile in the Master Labyrinth board game.  There are only three types of
	 * tiles: T, L and I, corresponding to three connections, or two either as
	 * a corner or two as a straight connection.  Thus there can be at most three
	 * ones and there must be at least two ones among t, b, l, and r.  The input
	 * is rejected if any of the parameters are any value not equal to 1 or 0.
	 * @param t A 1 (has connection) or 0 (no connection) corresponding to the top connection of the tile
	 * @param b A 1 (has connection) or 0 (no connection) corresponding to the bottom connection of the tile
	 * @param l A 1 (has connection) or 0 (no connection) corresponding to the left connection of the tile
	 * @param r A 1 (has connection) or 0 (no connection) corresponding to the right connection of the tile
	 * @return true if valid input, false if invalid
	 * @author Ian, Satya 03-15-16
	 */
	public boolean checkLegalDirectionsInput(int t, int b, int l, int r) {
		int tot = (t+b+l+r);
		if(tot < 2){return false;}
		if(t==1 && b==1 && l==1 && r==1) {return false;}
		if((t!=0 && t!=1) || (b!=0 && b!=1) || (l!=0 && l!=1) || (r!=0 && r!=1)){
			return false;
		}
		return true;
	}

	/**
	 * This method returns the integer value stored in _top; either a 1 or 0. 
	 * 
	 * @return value of _top, either 1 or 0
	 * 
	 * @author Satya, Ian (03-15-16)
	 */
	public int getTop(){ return _top;}
	
	/**
	 * This method returns the integer value stored in _bottom; either a 1 or 0. 
	 * 
	 * @return value of _bottom, either 1 or 0
	 * 
	 * @author Satya, Ian (03-15-16)
	 */
	public int getBottom(){ return _bottom;}
	
	/**
	 * This method returns the integer value stored in _bottom; either a 1 or 0. 
	 * 
	 * @return value of _bottom, either 1 or 0
	 * 
	 * @author Satya, Ian (03-15-16)
	 */
	public int getLeft(){ return _left;}
	
	/**
	 * This method returns the integer value stored in _bottom; either a 1 or 0. 
	 * 
	 * @return value of _bottom, either 1 or 0
	 * 
	 * @author Satya, Ian (03-15-16)
	 */
	public int getRight(){ return _right;}
	
	
	/**
	 * This method corrects the _top, _bottom, _right, and _left 
	 * variable assignments for rotation of the tile before. The value
	 * r = ( d % 360 ) normalizes the input d to a range of 0 to 359.
	 * If r = 0, there is no rotation; r = 90 or r = -270, correspond
	 * to a counter-clockwise quarter turn, while r = -90 or r = 270,
	 * correspond to clockwise quarter turns; r = 180 or r = -180 
	 * correspond to two quarter turns either clockwise or counterclockwise.
	 * No rotation is performed if r is not in the set {0,90,-90,180,-180,270,-270}.
	 * 
	 * @param d the degree of rotation to be performed out on the tile
	 *
	 * @author Satya, Ian (03-15-16)
	 */
	public void rotate(int d){
		
		int r = d%360;
		if(r==0){} 
		else if(r==90 || r==-270){
			int temp = _right;
			_right = _bottom;
			_bottom = _left;
			_left = _top;
			_top = temp;
			
			//change orientation counter-clockwise rotation
			_orientation = _orientation +4 -1 ;
			if(_tileType.equals("I")){
				_orientation = _orientation%2;
			}
			else{
				_orientation = _orientation%4;
			}
		}
		else if(r==-90 || r==270){
			int temp = _left;
			_left = _bottom;
			_bottom = _right;
			_right = _top;
			_top = temp;
			//change orientation clockwise rotation
			_orientation  += 1 ;
			if(_tileType.equals("I")){
				_orientation = _orientation%2;
			}
			else{
				_orientation = _orientation%4;
			}
		}
		else if(r==180 || r==-180) {
			int temp = _left;
			_left = _right;
			_right = temp;
			temp = _top;
			_top = _bottom;
			_bottom = temp;
			if(_tileType.equals("I")){
//				remains the same
//				_orientation = (_orientation+1)%2;
			}
			else{
				_orientation = (_orientation+2)%4;
			}
		}
		else {} // d%90!=0;
	}
	
	/**
	 * This method adds a player to the _players ArrayList of type Player 
	 * for this tile.
	 * @param p the player to be added
	 * @author Ian, Satya 03-15-16
	 */
	public boolean addPlayer(Player p){
		if(p == null){return false;}
		if(_players.size() < Player.maxNumberOfPlayers){
			_players.add(p);
			return true;
		}
		return false;
		
	}
	
	/**
	 * This method removes the player p from the _players ArrayList of type
	 * Player for this tile.
	 * @param p the player to be removed
	 * @author Ian, Satya 03-15-16
	 */
	public boolean removePlayer(Player p){
		if(_players.contains(p)){
			_players.remove(p);
			return true;
		}	
		return false;
	}
	
	/**
	 * This method returns the _players ArrayList of type Player for this tile.
	 * @return the ArrayList of type Player that stores the players on this tile.
	 * @author Ian, Satya 03-15-16
	 */
	public ArrayList<Player> getPlayers(){
		return _players;
	}
	
	/**
	 * Print all info
	 */
	public String printInfo() {
		String info = new String();
//		[Tile Type Orientation, token value, [Pawn list]]
//		[T0,0,[BLUE,GREEN]]
		info = "["+ printTile() + "," + printToken() + "," + printPlayer() + "]";
		
		
		
		return info;
	}

	private String printToken() {
		if(hasToken()){
			return ""+_token.getValue();
		}
		else{
			return ""+0;
		}
	}

	/**
	 * print out the player info based on Arraylist of String _players
	 * under the format "[ColorPawn1,ColorPawn2,ColorPawn3]"
	 * @return a String contains color lists
	 */
	private String printPlayer() {
		String colorList = new String();
		//The example format [BLUE,GREEN]
		colorList = "[";
		for(Player p : _players){
			colorList += "," + p.getColor().toUpperCase();
		}
		colorList += "]";
		//current String [,BLUE,GREEN]
		colorList = colorList.replaceFirst(",", "");
		//current String [BLUE,GREEN]
		return colorList;
	}

	/**
	 * Print current tile type and orientation based on description in stage 3
	 * @return a String contains tile type and orientation
	 */
	private String printTile() {
		return ""+_tileType+_orientation;
	}
	
} //end class definition

