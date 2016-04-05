package board;

import java.util.ArrayList;
import java.util.Collections;
import pawn.*;
import tile.*;
import token.*;

public class Board {
	private Pawn _pawn1;
	private Pawn _pawn2;
	private Pawn _pawn3;
	private Pawn _pawn4;
	public static int length = 7;
	public Tile[][] _gameBoard;
	public Tile _freetile;
	private boolean ShiftingSuccess = false;
	private int lastPosition_x = 0; // index to remember where the last
									// insertion occurred
	private int lastPosition_y = 0;// index to remember where the last insertion
									// occurred

	/**
	 *
	 * Method that creates the first board. uses an Array of Array of type tile.
	 */

	public Pawn getPawn(String s) {

		switch (s.toLowerCase()) {
		case "red":
			return _pawn1;
		case "yellow":
			return _pawn2;
		case "blue":
			return _pawn3;
		case "white":
			return _pawn4;

		}
		return _pawn1;
	}

	public void createGameBoard() {
		_gameBoard = new Tile[7][7];
	}

	public Tile[][] gameBoard() {
		return _gameBoard;
	}

	/**
	 * The fixed pieces are created first, then the other randomized tiles are
	 * created. Then the 2D array is iterated over and the starting positions
	 * are set. If we run out of a certain type of tile, because we have a
	 * limited supply of certain tiles, we need a while loop to run through the
	 * same x and y index to populate the location with a tile that we can use.
	 * We created the four pawns in this method with defined colors, x location,
	 * y location, and formula cards. Currently, the formula cards are useless.
	 * Finally the extra tile that the first player gets is returned.
	 * 
	 * @return Tile, the extra tile that the first player gets is returned.
	 */

	public Tile populateBoard() {
		// Using a compass rose to define directions
		// N is 0
		// E is 1
		// S is 2
		// W is 3

		// This creates the 4 corner pieces

		this.assigntile(0, 0, new TwoDirectionTile(1, 2));
		this.assigntile(0, 6, new TwoDirectionTile(2, 3));
		this.assigntile(6, 6, new TwoDirectionTile(0, 3));
		this.assigntile(6, 0, new TwoDirectionTile(0, 1));

		// This creates the 2 top row fixed pieces
		this.assigntile(0, 2, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(0, 4, new ThreeDirectionTile(1, 2, 3));

		// This creates the 2nd row fixed pieces
		this.assigntile(2, 0, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(2, 2, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(2, 4, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(2, 6, new ThreeDirectionTile(0, 2, 3));

		// This creates the 4th row fixed pieces
		this.assigntile(4, 0, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(4, 2, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(4, 4, new ThreeDirectionTile(0, 2, 3));
		this.assigntile(4, 6, new ThreeDirectionTile(0, 2, 3));

		// This creates the 6th row fixed pieces
		this.assigntile(6, 2, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(6, 4, new ThreeDirectionTile(0, 1, 3));

		// these variables hold the amount of tiles left over
		int _twoDirectionLeft = 14;
		int _oppositeDirectionLeft = 13;
		int _threeDirectionLeft = 7;

		// fills every (empty) place in the array with a different, randomized
		// tile
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

				if (_gameBoard[i][j] == null) {

					// System.out.println("2");
					int _twoDir = 0;
					int _oppDir = 1;
					int _threeDir = 2;
					// generates an array of ints that are unique so they can be
					// used to set the directions
					int[] XYZ = generateXuniqueNumber(3, 4);

					int x = XYZ[0];
					int y = XYZ[1];
					int z = XYZ[2];

					int randomTile = randomTile();

					// while there is an empty place in the gameBoard, make a
					// random tile, check if that tile is free to be used, and
					// fill the spot in the array
					while (_gameBoard[i][j] == null) {

						if (randomTile == _twoDir) {
							if (_twoDirectionLeft > 0) {
								// the current object is assigned the value of a
								// randomized twoDirectionTile
								this.assigntile(i, j, new TwoDirectionTile(x, y));

								_twoDirectionLeft--;

							} else {
								randomTile = randomTile();
							}

						} else if (randomTile == _oppDir) {
							if (_oppositeDirectionLeft > 0) {
								// the current object is assigned the value of a
								// randomized OppositeDirectionTile
								this.assigntile(i, j, new OppositeDirectionTile(x));
								_oppositeDirectionLeft--;
							} else {
								randomTile = randomTile();
							}
						}

						else if (randomTile == _threeDir) {
							if (_threeDirectionLeft > 0) {
								// the current object is assigned the value of a
								// randomized ThreeDirectionTile
								this.assigntile(i, j, new ThreeDirectionTile(x, y, z));
								_threeDirectionLeft--;
							} else {
								randomTile = randomTile();
							}
						} else {
							randomTile = randomTile();
						}
					}
				}
			}
		}

		// make the pawns on the board
		_pawn1 = new Pawn("red", 2, 2, 0);
		_pawn2 = new Pawn("yellow", 2, 4, 0);
		_pawn3 = new Pawn("blue", 4, 2, 0);
		_pawn4 = new Pawn("white", 2, 2, 0);
		// set the pawns on corresponding tile
		_gameBoard[2][2].setPawns("red");
		_gameBoard[2][4].setPawns("yellow");
		_gameBoard[4][2].setPawns("blue");
		_gameBoard[4][4].setPawns("white");

		// This free tile will be passed off to the player to begin the game
		if (_twoDirectionLeft == 1) {

			_freetile = new TwoDirectionTile(0, 1);
		} else if (_oppositeDirectionLeft == 1) {

			_freetile = new OppositeDirectionTile(0);
		} else if (_threeDirectionLeft == 1) {

			_freetile = new ThreeDirectionTile(0, 1, 2);
		}
		// resets the tiles locations
		for (int i = 0; i < _gameBoard.length; i++) {
			for (int j = 0; j < _gameBoard.length; j++) {
				_gameBoard[i][j].setCoordinates(i, j);

			}
		}
		_freetile = new TwoDirectionTile(2, 3);
		return _freetile;

	}

	/*
	 * Generate the 21 unique tokens that will go on the board
	 * 
	 * @return tokenArray, an int[]
	 * 
	 */
	public int[] uniqueTokens() {
		int[] tokenArray = new int[21];
		int[] temp = generateXuniqueNumber(26, 26);
		int j = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0 && temp[i] != 21 && temp[i] != 22 && temp[i] != 23 && temp[i] != 24) {
				tokenArray[j] = temp[i];
				j++;
			}
		}
		return tokenArray;
	}

	/*
	 * Adds initial tokens to board. The indexes of tokenToAdded are mapped to
	 * the indexes of the correct starting board indexes.
	 * 
	 * @return void
	 */

	public void addTokensToBoard() {
		int[] tokensToBeAdded = uniqueTokens();
		_gameBoard[1][1].setToken(tokensToBeAdded[0]);
		_gameBoard[1][2].setToken(tokensToBeAdded[1]);
		_gameBoard[1][3].setToken(tokensToBeAdded[2]);
		_gameBoard[1][4].setToken(tokensToBeAdded[3]);
		_gameBoard[1][5].setToken(tokensToBeAdded[4]);
		_gameBoard[2][1].setToken(tokensToBeAdded[5]);
		_gameBoard[2][3].setToken(tokensToBeAdded[6]);
		_gameBoard[2][5].setToken(tokensToBeAdded[7]);
		_gameBoard[3][1].setToken(tokensToBeAdded[8]);
		_gameBoard[3][2].setToken(tokensToBeAdded[9]);
		_gameBoard[3][3].setToken(tokensToBeAdded[10]);
		_gameBoard[3][4].setToken(tokensToBeAdded[11]);
		_gameBoard[3][5].setToken(tokensToBeAdded[12]);
		_gameBoard[4][1].setToken(tokensToBeAdded[13]);
		_gameBoard[4][3].setToken(tokensToBeAdded[14]);
		_gameBoard[4][5].setToken(tokensToBeAdded[15]);
		_gameBoard[5][1].setToken(tokensToBeAdded[16]);
		_gameBoard[5][2].setToken(tokensToBeAdded[17]);
		_gameBoard[5][3].setToken(tokensToBeAdded[18]);
		_gameBoard[5][4].setToken(tokensToBeAdded[19]);
		_gameBoard[5][5].setToken(tokensToBeAdded[20]);

	}

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
	 * This method is used to randomize an integer, which is used to randomize a
	 * tile in another method. It returns an integer that is mapped to a tile. 0
	 * is twoDirection, 1 is opposite direction, 2 is three direction.
	 * 
	 * @return int Returns an integer that is mapped to a tile in another
	 *         method.
	 */
	private static int randomTile() {
		int randomTile = (int) (Math.random() * 3);
		return randomTile;
	}

	/**
	 * This method assigns a tile to the x and y index of the _gameBoard 2D
	 * array.
	 * 
	 * @param x
	 *            The row index of the 2D array.
	 * @param y
	 *            The column index of the 2D array.
	 * @param _newtile
	 *            The tile that you want to set at the position.
	 */
	public void assigntile(int x, int y, Tile _newtile) {
		_gameBoard[x][y] = _newtile;
	}

	/**
	 * This method checks if this tile has a set reference
	 * 
	 * @param x
	 *            The row index of the 2D array.
	 * @param y
	 *            The column index of the 2D array.
	 * @return boolean to see if the position has an unset reference.
	 */
	public boolean isnull(int x, int y) {

		return _gameBoard[x][y] == null;
	}

	/**
	 * Method to check if the North direction in the path is available at
	 * location x and y.
	 * 
	 * @return boolean true if open. false otherwise.
	 */
	public boolean isNopen(int x, int y) {
		return _gameBoard[x][y].isNopen(); // method uses a different class'
											// method with
		// the same name
	}

	/**
	 * Method to check if the East direction in the path is available at
	 * location x and y.
	 * 
	 * @return boolean true if open. false otherwise.
	 */

	public boolean isEopen(int x, int y) {
		return _gameBoard[x][y].isEopen();// method uses a different class'
											// method with the
		// same name
	}

	/**
	 * Method to check if the South direction in the path is available at
	 * location x and y.
	 * 
	 * @return boolean true if open. false otherwise.
	 */

	public boolean isSopen(int x, int y) {
		return _gameBoard[x][y].isSopen();// method uses a different class'
											// method with the
		// same name
	}

	/**
	 * Method to check if the West direction in the path is available at
	 * location x and y.
	 * 
	 * @return boolean true if open. false otherwise.
	 */

	public boolean isWopen(int x, int y) {
		return _gameBoard[x][y].isWopen();// method uses a different class'
											// method with the
		// same name
	}

	/**
	 * Method to check if the tile at location x and y has pawn.
	 * 
	 * @return boolean true if has. false otherwise.
	 */
	public boolean hasPawn(int x, int y) {
		return _gameBoard[x][y].hasPawn();
	}

	/**
	 * Method to check if the tile at location x and y has pawn.
	 * 
	 * @return boolean true if has. false otherwise.
	 */
	public ArrayList<String> pawnsOnTile(int x, int y) {
		return _gameBoard[x][y].pawnsOnTile();
	}

	/**
	 * This method loops through the 2D array and assigns new x and y
	 * coordinates.
	 */
	public void setCoordinates() {
		for (int i = 0; i < _gameBoard.length; i++) {
			for (int j = 0; j < _gameBoard.length; j++) {
				_gameBoard[i][j].setCoordinates(i, j);

			}
		}
	}

	/**
	 * InsertTile method that inserts a tile onto the board. First it checks if
	 * the insertion is valid, then it checks if it's the same position as last
	 * insertion as last time. Then it replaces the tiles one by one by first
	 * copying the farthest tile in the row/column that is opposite of the point
	 * of insertion, then shifting the tile objects by one space. Then the tile
	 * to be inserted "tileInserted" is placed into the empty spot. We also
	 * check to see if the free tile has a token or multiple pawns. The pawn and
	 * token data of the free tile is copied to the tileInserted tile.
	 * 
	 * @param insert_i
	 *            is the x index.
	 * @param insert_j
	 *            is the y index.
	 * @param tileInserted
	 *            original free tile that was inserted.
	 * @return _freeTile, Type Tile that will be passed to the user.
	 */
	public Tile InsertTile(int insert_i, int insert_j, Tile tileInserted) {
		// checks if its on the board
		if (insert_i >= 0 && insert_i <= 6 && insert_j >= 0 && insert_j <= 6)

		{
			// check if it's a valid position to insert
			if ((insert_i != lastPosition_x) || (insert_j != lastPosition_y)) {

				// insertion occurred at top row, shift tiles downward
				if ((insert_i == 0) && (insert_j == 1 || insert_j == 3 || insert_j == 5)) {
					_freetile = _gameBoard[6][insert_j];

					for (int i = 6; i > 0; i--) {
						this.assigntile(i, insert_j, _gameBoard[i - 1][insert_j]);
					}
					this.assigntile(0, insert_j, tileInserted);
					ShiftingSuccess = true;

				} // insertion occurred at left side, shift tiles right
				else if ((insert_j == 0) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
					_freetile = _gameBoard[insert_i][6];
					for (int j = 6; j > 0; j--) {
						this.assigntile(insert_i, j, _gameBoard[insert_i][j - 1]);
					}
					this.assigntile(insert_i, 0, tileInserted);
					ShiftingSuccess = true;

				} // insertion occurred at right side, shift tiles left
				else if ((insert_j == 6) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
					_freetile = _gameBoard[insert_i][0];
					for (int j = 0; j < 6; j++) {
						this.assigntile(insert_i, j, _gameBoard[insert_i][j + 1]);
					}
					this.assigntile(insert_i, 6, tileInserted);
					ShiftingSuccess = true;

				} // insertion happened on the bottom row, shift tiles up
				else if ((insert_i == 6) && (insert_j == 1 || insert_j == 3 || insert_j == 5)) {
					_freetile = _gameBoard[0][insert_j];
					for (int i = 0; i < 6; i++) {
						this.assigntile(i, insert_j, _gameBoard[i + 1][insert_j]);
					}
					this.assigntile(6, insert_j, tileInserted);
					ShiftingSuccess = true;

				}
				// resets the tiles locations
				for (int i = 0; i < _gameBoard.length; i++) {
					for (int j = 0; j < _gameBoard.length; j++) {
						_gameBoard[i][j].setCoordinates(i, j);

					}
				}

				// if the freetile has a pawn on it, then copy that value(s)
				// over to the opposite side, then delete it
				if (_freetile.hasPawn()) {
					ArrayList<String> temp = _freetile.pawnsOnTile();
					for (int i = 0; i < temp.size(); i++) {
						_gameBoard[insert_i][insert_j].setPawns(temp.get(i));

					}

					_freetile.erasePawn("red");
					_freetile.erasePawn("yellow");
					_freetile.erasePawn("blue");
					_freetile.erasePawn("white");
				}

				updatePawnXYPosition();
				// if the freetile has a token on it, then copy that value over
				// to the opposite side, then delete it from freetile
				if (_freetile.hasToken()) {
					int temp = _freetile.tokenOnTile();
					_freetile.eraseToken();
					_gameBoard[insert_i][insert_j].setToken(temp);

				}
				lastPosition_x = insert_i;
				lastPosition_y = insert_j;

			} // else{return _freetile;}
		}
		// else{return _freetile;}
		return _freetile;
	}

	public Tile getFreeTile() {
		return _freetile;
	}

	/**
	 * This method loops through the 2D array and updates all the pawns location
	 * 
	 * @return void
	 */

	public void updatePawnXYPosition() {
		// go through the whole board
		for (int i = 0; i < 7; i++) {
			for (int o = 0; o < 7; o++) {
				// check if it has pawn
				if (_gameBoard[i][o].hasPawn()) {
					// store the pawns into temp
					ArrayList<String> temp = _gameBoard[i][o].pawnsOnTile();
					// match pawns to update location for every pawn in the
					// arraylist
					for (int k = 0; k < temp.size(); k++) {
						switch (temp.get(k)) {
						case "red":
							_pawn1.setCoordinates(i, o);
						case "yellow":
							_pawn2.setCoordinates(i, o);
						case "blue":
							_pawn3.setCoordinates(i, o);
						case "white":
							_pawn4.setCoordinates(i, o);
						}
					}
				}
			}
		}
	}

	/**
	 * accept the current pawn you want to move and the direction you want to
	 * move to returns a boolean indicate the success or failure
	 * 
	 * @param direction
	 *            the direction want to move to
	 * @param movingPawn
	 *            the current pawn you are moving
	 * @return boolean indicate the success of moving
	 */
	public boolean moveOneStep(String direction, Pawn movingPawn) {
		// store x, y position of moving pawn
		int x = movingPawn.getXpos();
		int y = movingPawn.getYpos();
		// check the direction the pawn want to move
		if (direction.toLowerCase().equals("n")) {
			// check if the pawn on the top
			if (x != 0) {
				// check if N is open on the tile that the pawn is on
				if (_gameBoard[x][y].isNopen()) {
					// check if S is open on the tile that the pawn wants to
					// move
					if (_gameBoard[x - 1][y].isSopen()) {
						// add pawn to new tile
						_gameBoard[x - 1][y].setPawns(movingPawn.getColor());
						// erase pawn from old tile
						_gameBoard[x][y].erasePawn(movingPawn.getColor());
						// update pawn position
						updatePawnXYPosition();
						return true;
					}
				}
			}
		}
		// check the direction the pawn want to move
		if (direction.toLowerCase().equals("e")) {
			// check if the pawn on the right side
			if (y != 6) {
				// check if E is open on the tile that the pawn is on
				if (_gameBoard[x][y].isEopen()) {
					// check if W is open on the tile that the pawn wants to
					// move
					if (_gameBoard[x][y + 1].isWopen()) {
						// add pawn to new tile
						_gameBoard[x][y + 1].setPawns(movingPawn.getColor());
						// erase pawn from old tile
						_gameBoard[x][y].erasePawn(movingPawn.getColor());
						// update pawn position
						updatePawnXYPosition();
						return true;
					}

				}
			}
		}
		// check the direction the pawn want to move
		if (direction.toLowerCase().equals("s")) {
			// check if the pawn on the bottom
			if (x != 6) {
				// check if S is open on the tile that the pawn is on
				if (_gameBoard[x][y].isSopen()) {
					// check if N is open on the tile that the pawn wants to
					// move
					if (_gameBoard[x + 1][y].isNopen()) {
						// add pawn to new tile
						_gameBoard[x + 1][y].setPawns(movingPawn.getColor());
						// erase pawn from old tile
						_gameBoard[x][y].erasePawn(movingPawn.getColor());
						// update pawn position
						updatePawnXYPosition();
						return true;
					}
				}
			}
		}
		// check the direction the pawn want to move
		if (direction.toLowerCase().equals("w")) {
			// check if the pawn on the left side
			if (y != 0) {
				// check if W is open on the tile that the pawn is on
				if (_gameBoard[x][y].isWopen()) {
					// check if E is open on the tile that the pawn wants to
					// move
					if (_gameBoard[x][y - 1].isEopen()) {
						// add pawn to new tile
						_gameBoard[x][y - 1].setPawns(movingPawn.getColor());
						// erase pawn from old tile
						_gameBoard[x][y].erasePawn(movingPawn.getColor());
						// update pawn position
						updatePawnXYPosition();
						return true;
					}

				}
			}
		}
		return false;
	}

	/**
	 * This method is used only to test the shift method and one step movement
	 * method.
	 * 
	 * @return void
	 */
	public void populateTestBoard() {

		this.assigntile(0, 0, new TwoDirectionTile(1, 2));
		this.assigntile(0, 6, new TwoDirectionTile(2, 3));
		this.assigntile(6, 6, new TwoDirectionTile(0, 3));
		this.assigntile(6, 0, new TwoDirectionTile(0, 1));

		// This creates the 2 top row fixed pieces
		this.assigntile(0, 2, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(0, 4, new ThreeDirectionTile(1, 2, 3));

		// This creates the 2nd row fixed pieces
		this.assigntile(2, 0, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(2, 2, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(2, 4, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(2, 6, new ThreeDirectionTile(0, 2, 3));

		// This creates the 4th row fixed pieces
		this.assigntile(4, 0, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(4, 2, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(4, 4, new ThreeDirectionTile(0, 2, 3));
		this.assigntile(4, 6, new ThreeDirectionTile(0, 2, 3));

		// This creates the 6th row fixed pieces
		this.assigntile(6, 2, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(6, 4, new ThreeDirectionTile(0, 1, 3));

		this.assigntile(0, 1, new OppositeDirectionTile(0));
		this.assigntile(0, 3, new OppositeDirectionTile(0));
		this.assigntile(0, 5, new OppositeDirectionTile(0));

		this.assigntile(1, 0, new OppositeDirectionTile(1));
		this.assigntile(1, 1, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(1, 2, new OppositeDirectionTile(1));
		this.assigntile(1, 3, new ThreeDirectionTile(0, 2, 3));
		this.assigntile(1, 4, new OppositeDirectionTile(0));
		this.assigntile(1, 5, new ThreeDirectionTile(0, 2, 3));
		this.assigntile(1, 6, new TwoDirectionTile(2, 3));

		this.assigntile(2, 1, new OppositeDirectionTile(1));
		this.assigntile(2, 3, new OppositeDirectionTile(1));
		this.assigntile(2, 5, new OppositeDirectionTile(1));

		this.assigntile(3, 0, new TwoDirectionTile(2, 3));
		this.assigntile(3, 1, new OppositeDirectionTile(0));
		this.assigntile(3, 2, new OppositeDirectionTile(0));
		this.assigntile(3, 3, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(3, 4, new TwoDirectionTile(1, 2));
		this.assigntile(3, 5, new TwoDirectionTile(0, 1));
		this.assigntile(3, 6, new ThreeDirectionTile(0, 2, 3));

		this.assigntile(4, 1, new TwoDirectionTile(0, 1));
		this.assigntile(4, 3, new OppositeDirectionTile(1));
		this.assigntile(4, 5, new TwoDirectionTile(2, 3));

		this.assigntile(5, 0, new TwoDirectionTile(2, 3));
		this.assigntile(5, 1, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(5, 2, new TwoDirectionTile(0, 1));
		this.assigntile(5, 3, new TwoDirectionTile(2, 3));
		this.assigntile(5, 4, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(5, 5, new OppositeDirectionTile(0));
		this.assigntile(5, 6, new TwoDirectionTile(0, 3));

		this.assigntile(6, 1, new TwoDirectionTile(0, 1));
		this.assigntile(6, 3, new TwoDirectionTile(0, 3));
		this.assigntile(6, 5, new TwoDirectionTile(0, 3));

		// make the pawns on the board
		_pawn1 = new Pawn("red", 2, 2, 0);
		_pawn2 = new Pawn("yellow", 2, 4, 0);
		_pawn3 = new Pawn("blue", 4, 2, 0);
		_pawn4 = new Pawn("white", 2, 2, 0);

		// _gameBoard[2][2].setPawns("red");
		// _gameBoard[2][4].setPawns("yellow");
		// _gameBoard[4][2].setPawns("blue");
		// _gameBoard[4][4].setPawns("white");

		_freetile = new TwoDirectionTile(2, 3);
	}

	/**
	 * This method is used only to test one step movement method.
	 * 
	 * @return void
	 */
	public void populateTestBoardAfterMove(String name1, String name2, String name3, String name4) {

		this.assigntile(0, 0, new TwoDirectionTile(1, 2));
		this.assigntile(0, 6, new TwoDirectionTile(2, 3));
		this.assigntile(6, 6, new TwoDirectionTile(0, 3));
		this.assigntile(6, 0, new TwoDirectionTile(0, 1));

		// This creates the 2 top row fixed pieces
		this.assigntile(0, 2, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(0, 4, new ThreeDirectionTile(1, 2, 3));

		// This creates the 2nd row fixed pieces
		this.assigntile(2, 0, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(2, 2, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(2, 4, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(2, 6, new ThreeDirectionTile(0, 2, 3));

		// This creates the 4th row fixed pieces
		this.assigntile(4, 0, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(4, 2, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(4, 4, new ThreeDirectionTile(0, 2, 3));
		this.assigntile(4, 6, new ThreeDirectionTile(0, 2, 3));

		// This creates the 6th row fixed pieces
		this.assigntile(6, 2, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(6, 4, new ThreeDirectionTile(0, 1, 3));

		this.assigntile(0, 1, new OppositeDirectionTile(0));
		this.assigntile(0, 3, new OppositeDirectionTile(0));
		this.assigntile(0, 5, new OppositeDirectionTile(0));

		this.assigntile(1, 0, new OppositeDirectionTile(1));
		this.assigntile(1, 1, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(1, 2, new OppositeDirectionTile(1));
		this.assigntile(1, 3, new ThreeDirectionTile(0, 2, 3));
		this.assigntile(1, 4, new OppositeDirectionTile(0));
		this.assigntile(1, 5, new ThreeDirectionTile(0, 2, 3));
		this.assigntile(1, 6, new TwoDirectionTile(2, 3));

		this.assigntile(2, 1, new OppositeDirectionTile(1));
		this.assigntile(2, 3, new OppositeDirectionTile(1));
		this.assigntile(2, 5, new OppositeDirectionTile(1));

		this.assigntile(3, 0, new TwoDirectionTile(2, 3));
		this.assigntile(3, 1, new OppositeDirectionTile(0));
		this.assigntile(3, 2, new OppositeDirectionTile(0));
		this.assigntile(3, 3, new ThreeDirectionTile(0, 1, 3));
		this.assigntile(3, 4, new TwoDirectionTile(1, 2));
		this.assigntile(3, 5, new TwoDirectionTile(0, 1));
		this.assigntile(3, 6, new ThreeDirectionTile(0, 2, 3));

		this.assigntile(4, 1, new TwoDirectionTile(0, 1));
		this.assigntile(4, 3, new OppositeDirectionTile(1));
		this.assigntile(4, 5, new TwoDirectionTile(2, 3));

		this.assigntile(5, 0, new TwoDirectionTile(2, 3));
		this.assigntile(5, 1, new ThreeDirectionTile(1, 2, 3));
		this.assigntile(5, 2, new TwoDirectionTile(0, 1));
		this.assigntile(5, 3, new TwoDirectionTile(2, 3));
		this.assigntile(5, 4, new ThreeDirectionTile(0, 1, 2));
		this.assigntile(5, 5, new OppositeDirectionTile(0));
		this.assigntile(5, 6, new TwoDirectionTile(0, 3));

		this.assigntile(6, 1, new TwoDirectionTile(0, 1));
		this.assigntile(6, 3, new TwoDirectionTile(0, 3));
		this.assigntile(6, 5, new TwoDirectionTile(0, 3));

		// make the pawns on the board
		_pawn1 = new Pawn(name1, 2, 3, 0);
		_pawn2 = new Pawn(name2, 2, 4, 0);
		_pawn3 = new Pawn(name3, 4, 2, 0);
		_pawn4 = new Pawn(name4, 2, 2, 0);

		_gameBoard[2][3].setPawns(name1);
		_gameBoard[2][4].setPawns(name2);
		_gameBoard[4][2].setPawns(name3);
		_gameBoard[4][4].setPawns(name4);

		_freetile = new TwoDirectionTile(2, 3);
	}

}