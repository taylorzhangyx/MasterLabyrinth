package code.model;

import java.util.ArrayList;
import java.util.Collections;

import code.model.Token;

/**
 * The player class holds common instance variables and methods that create the
 * player and define the player's functionality
 * 
 * @author Weijin,Ken,Ian (3-17-16)
 * @author Ian,Ken 04-10-16
 *
 */
public class Player {

	/**
	 * static final int value that stores the maximum number of players during a
	 * game. It is final because the max# can not change
	 */
	public static final int maxNumberOfPlayers = 4;

	/**
	 * a String array holding the valid colors for the game
	 */
	public static final String[] _validColors = new String[] { "Tan", "Blue", "Red", "White" };

	/**
	 * true if player has shifted this turn; false otherwise
	 */
	private boolean _hasInsertedThisTurn;
	public boolean _hasUsedWandThisTurn;

	/**
	 * true if player has moved this turn; false otherwise
	 */
	private boolean _hasMovedThisTurn;
	
	private int[] _formula;

	/**
	 * String holding the current color of the player
	 */
	private String _color;

	/**
	 * reference to the AbstractTile on which this player currently resides
	 */
	private AbstractTile _currentTile;

	/**
	 * reference to the gameboard object with which this player is associated
	 */
	private GameBoard _gb;
	
	

	/**
	 * ArrayList of Tokens; the tokens that this player has collected
	 */
	private ArrayList<Token> _myTokens; // arraylist of player-owned tokens
										// (picked up)

	/**
	 * Name of the human who controls this player/pawn
	 */
	private String _playerName;

	/**
	 * Current score of the player
	 */
	private int _score; // sum of token values
	
	private int _magicWand;
	

	/**
	 * The constructor Player assigns the instance variable _color to the String
	 * c
	 * 
	 * @param c
	 *            is the color of the player
	 * @author Weijin,Ken,Ian
	 */
	public Player(String c) {
		_color = c;
		_myTokens = new ArrayList<Token>();
		_score = 0;
		_magicWand = 3;
	}
	
	public int getMagicWandCount(){
		return _magicWand;
	}
	
	public void decMagicWandCount(){
		_magicWand = _magicWand-1;
	}
	
	/**
	 * This method assigns the value gb, an reference to the Gameboard object,
	 * to the instance variable _gb. This allows for accessability of Gameboard
	 * public methods in the Player class so the players can call methods on the
	 * gameboard
	 * 
	 * @param gb
	 *            a refeence to the gameboard
	 * @author Weijin, Ken, Ian
	 */
	public void setGameBoard(GameBoard gb) {
		_gb = gb;
	}

	/**
	 * This method is a getter that returns the color
	 * 
	 * @return _color the color as a String of the player
	 * @author Weijin, Ken, Ian
	 */
	public String getColor() {
		return _color;
	}

	/**
	 * This method sets the current tile
	 * 
	 * @param at
	 *            is a tile that is set as the current tile
	 * @author Weijin, Ken, Ian
	 * @author Ian, Satya 04-10-16
	 */
	public void setCurrentTile(AbstractTile at) {
		_currentTile = at;
	}

	/**
	 * This method is a getter that returns the current tile
	 * 
	 * @return _currentTile the current tile on which this player resides
	 * @author Weijin, Ken, Ian
	 */
	public AbstractTile getCurrentTile() {
		return _currentTile;
	}
	
	public void setTurn(boolean b){
		_hasMovedThisTurn = b;
	}

	
	
	/*
	 * Formula card the player is assigned
	 * 
	 */


	

	
		/*
		 * setter method for Formula
		 * 
		 */
		
	/*
	 * Assign a random formula card to the player based on the random number generated
	 */
	
	
		/**
		 * Gets an array with size of n in the range from 0 to x-1
		 * 
		 * @param n
		 *            the number of unique numbers you want
		 * @param x
		 *            range from 0 to x-1
		 * @return an integer array in the size of n contains n unique number range
		 *         from 0 to x-1
		 */
		
	
	
	public void assignFormula(){
		int[] randomFormula = generateXuniqueNumber(21, 21);
		//Player1.setFormula(assignFormula(randomFormula[0]));
		//Player2.setFormula(assignFormula(randomFormula[1]));
		//Player3.setFormula(assignFormula(randomFormula[2]));
		//Player4.setFormula(assignFormula(randomFormula[3]));
	}
	
	public void setFormula(int[] formula){
		_formula = formula;
	}
	/**
	 * This method tells you if you can insert a tile.
	 * 
	 * @param insertShiftableTileAtTileNumberPosition
	 *            this is the tile that is going to be inserted.
	 * @return _gb.checkIfInsertShiftableTileLegal(insertionTile); this returns
	 *         a a true or false value if the tile can be inserted into the
	 *         board
	 * @author Weijin, Ken, Ian
	 * @author Ian, Ken 04-10-16
	 */
	public boolean insertShiftableTile(int insertShiftableTileAtTileNumberPosition) {
		boolean canInsert = false;
		if (!_hasInsertedThisTurn) {
			canInsert = _gb.checkIfInsertShiftableTileLegal(insertShiftableTileAtTileNumberPosition);
			if (canInsert) {
				_hasInsertedThisTurn = true;
			}
		}
		return canInsert;
	}

	private int[] generateXuniqueNumber(int n, int x) {
		int uniqueInt[] = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		// we start at index 0 because we need integer 0 to be in our integer
		// arraylist

		for (int i = 0; i < x; i++) {
			list.add(new Integer(i));
		}

		Collections.shuffle(list);
		// we store the first n elements in the arraylist in the int array
		for (int i = 0; i < n; i++) {
			uniqueInt[i] = list.get(i);
		}
		return uniqueInt;
	}		
	/**
	 * This method moves a player to the destination the player wants to go It
	 * checks to see if the player can move to the destination then moves the
	 * player,but if it can't it will say that you can't move It finally informs
	 * the gameboard that it has moved, which in turn alerts the GameBoardGUI to
	 * update.
	 * 
	 * @param destinationTileNum
	 *            This is the tile number of the destination tile that the
	 *            player wants to move to
	 * @return canMove which is an if statement that checks if a player can move
	 *         to the destination tile if it can it moves the tile and returns a
	 *         statement that informs the player that his/her pawn has moved,
	 *         like wise if it can't move it returns a statement that informs
	 *         the player that his/her pawn can't be moved to that location
	 * @author Ken, Ian
	 * @author Ian, Satya 04-10-16
	 * @author Ian,Ken 04-10-16
	 */
	public boolean moveToTile(int destinationTileNum) {

		boolean canMove = false;
		if (!_hasMovedThisTurn) {
			AbstractTile destinationTile = _gb.getTileFromTileNumber(destinationTileNum);
			canMove = _gb.checkIfMoveLegal(_currentTile, destinationTile);
			if (canMove) {
				_currentTile.removePlayer(this);
				// _currentTile = destinationTile;
				setCurrentTile(destinationTile);
				_currentTile.addPlayer(this);
				_hasMovedThisTurn = true;
				System.out.println("I can move to tileNum: " + destinationTileNum + " and have thus moved.");
			} else {
				System.out.println("I can't move to tileNum: " + destinationTileNum + " and have not moved.");
			}
			if (canMove) {
				_gb.playerHasAlteredBoard();
			}
		}
		return canMove;
	}

	/**
	 * This method rotates the shiftable tile, which is the only remaining tile
	 * in the MoveableTile Array after populating the game board
	 * 
	 * @param d
	 *            the degree of rotation desired by the player
	 * @return The definition of the shiftable tile, is that it is the only
	 *         remaining element of the MoveableTile Array. The player is always
	 *         free to rotate this tile as long as it is shiftable; thus we
	 *         return true.
	 * @author Ken, Satya
	 */
	public boolean rotateShiftableTile(int d) {
		MoveableTile shiftable = _gb.getMoveableTileArray().get(0);
		shiftable.rotate(d);
		return true;
	}

	// NOTE: THIS METHOD NEEDS TO BE CHANGED (MOST LIKELY)
	/**
	 * This method add the newly picked up Token t to the player's _myTokens
	 * ArrayList
	 * 
	 * @param t
	 *            the token picked up
	 * @author Weijin, Ian 03-18-16
	 * @author Ian, Satya 04-10-16
	 */
	public boolean pickUpToken(Token t) {

		if (!_hasMovedThisTurn) {
			String s = "\t\t\t\tGAME INFO\n\nIt is now " + GameBoard.CURRENTPLAYER.getName() + "'s ("
					+ GameBoard.CURRENTPLAYER.getColor() + " pawn) turn." + "\nCurrent Collectible Token Number: "
					+ _gb.getCurrentTargetTokenValue()
					+ "\n\nYou must first move before picking up a token! Try again!";
			_gb.updateGameFeedBack(s);
		}

		else if (_currentTile != t.getTile()) {
			System.out.println(_currentTile == t.getTile());
			String s = "\t\t\t\tGAME INFO\n\nIt is now " + GameBoard.CURRENTPLAYER.getName() + "'s ("
					+ GameBoard.CURRENTPLAYER.getColor() + " pawn) turn." + "\nCurrent Collectible Token Number: "
					+ _gb.getCurrentTargetTokenValue() + "\n\nThat token is not on your current tile! Try again!";
			_gb.updateGameFeedBack(s);
		}

		else if (_gb.getCurrentTargetToken() != t) {
			String s = "\t\t\t\tGAME INFO\n\nIt is now " + GameBoard.CURRENTPLAYER.getName() + "'s ("
					+ GameBoard.CURRENTPLAYER.getColor() + " pawn) turn." + "\nCurrent Collectible Token Number: "
					+ _gb.getCurrentTargetTokenValue()
					+ "\n\nThis token is not the current collectible token! Try again!";
			_gb.updateGameFeedBack(s);
		}

		if (_hasMovedThisTurn && _gb.getCurrentTargetToken() == t && _currentTile == t.getTile()) {
			System.out.println("It is " + (_currentTile == t.getTile()) + " that my tile is the same as the token's");
			_myTokens.add(t);
			AbstractTile at = t.getTile();
			at.removeToken();
			// t.setTile(null);
			
			if (t.getValue()==_formula[0]||t.getValue()==_formula[1]||t.getValue()==_formula[2]){
				_score = _score + 20;
			}
			_score = _score + t.getValue();
			_gb.toggleNextToken();
			_gb.playerHasAlteredBoard();

			if (t.getValue() != 25) {
				String s = "\t\t\t\tGAME INFO\n\nIt is now " + GameBoard.CURRENTPLAYER.getName() +

				"'s (" + GameBoard.CURRENTPLAYER.getColor() + " pawn) turn." + "\nCurrent Collectible Token Number: "
						+ _gb.getCurrentTargetTokenValue();
				_gb.updateGameFeedBack(s);
			}
			return true;
		}
		return false;

	}

	/**
	 * Flips a token from face down to face up if it is not already face up A
	 * player can only flip a token to face up while standing on the same tile
	 * at which the token is located
	 * 
	 * @author Ian, Satya 04-10-16
	 * @param t
	 */
	// public void flipTokenToFaceUp(Token t){
	//
	//// System.out.println(_gb.getTileNumFromTileReference(_currentTile) + " "
	// +
	//// _gb.getTileNumFromTileReference(t.getTile()));
	// if(_currentTile == t.getTile()/* && !t.isFaceUp()*/){
	// t.flipToFaceUp();
	// _gb.playerHasAlteredBoard();
	// }
	// }

	/**
	 * This method sets players' names
	 * 
	 * @param name
	 * @author Ian, Weijin
	 */
	public void setName(String name) {
		_playerName = name;
	}

	/**
	 * This method gets players' names
	 * 
	 * @return players' names
	 * @author Ian, Weijin
	 */
	public String getName() {
		return _playerName;
	}

	/**
	 * This method returns the score of each player
	 * 
	 * @return the score
	 * @author Ian, Weijin
	 */
	public int getScore() {
		return _score;
	}
	
	/**
	 * This method calculate the final score includes both score and magic wand
	 * @return	integer
	 */
	public int getFinalScore(){
		return _score+3*_magicWand;
	}

	/**
	 * set the score based on score
	 * @param score
	 */
	public void setScore(int score) {
		_score = score;
	}

	/**
	 * 
	 * @return my tokens
	 * @author Ian, Weijin
	 */
	public ArrayList<Token> getTokens() {
		return _myTokens;
	}

	/**
	 * @author satya, Josh
	 */
	public void setTokens(ArrayList<Token> tokens) {
		_myTokens = tokens;
	}

	/**
	 * This method makes sure a player has inserted the tile
	 * 
	 * @return boolean _hasInsertedThisTurn
	 * @author Ian, Ken 04-10-16
	 */
	public boolean getHasInsertedThisTurn() {
		return _hasInsertedThisTurn;
	}

	/**
	 * This method makes sure a player has moved
	 * 
	 * @return boolean _hasMovedThisTurn;
	 * @author Ian, Ken 04-10-16
	 */
	public boolean getHasMovedThisTurn() {
		return _hasMovedThisTurn;
	}

	/**
	 * This method sets boolean _hasInsertedThisTurn and _hasMovedThisTurn to
	 * false
	 * 
	 * @author Ian,Ken 04-10-16
	 */
	public void endMyTurn() {
		_hasInsertedThisTurn = false;
		_hasMovedThisTurn = false;
	}

	/**
	 * This method adds tokens to the player's tokens list
	 * 
	 * @param t
	 *            tokens
	 */
	public void addToken(Token t) {
		_myTokens.add(t);
	}

	public String getCard() {
		
		return ""+_formula[0]+","+_formula[1]+","+_formula[2];
	}

	/**
	 * print all info of this player out as a String
	 * used for saving game
	 * @return String with info of this player
	 */
	public String printInfo() {
		String s = new String();
//		[name, pawn color, wands remaining, secret recipe ingredients, tokens collected]
//		[River,BLUE,3,[3,12,14],[1,3,4,11]]
		s = "[" + _playerName + "," + _color + "," + _magicWand + ",["+ getCard() +"]," + getToken() + "]";
		return s;
	}

	/**
	 * Print all token out
	 * @return
	 */
	private String getToken() {
		String s = new String();
		s += "[";
		for(Token _token : _myTokens){
			s += _token.getValue() + ",";
		}
		//current String = "[Value1,Value2,...ValueN,"
		s += "]"; 
		//current String = "[Value1,Value2,...ValueN,]"
		s.replaceFirst(",", "");
		//current String = "[Value1,Value2,...ValueN]"
		
		return s;
	}
	
	
}
