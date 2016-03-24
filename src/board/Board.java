package board;

import java.util.ArrayList;
import java.util.Collections;
import pawn.*;
import tile.*;
import token.*;

public class Board {
	public Tile _tile;

	public static int length = 7;
	public Tile[][] _gameBoard;
	public Tile _freetile;
	private int lastPosition_x = 0; // index to remember where the last
									// insertion occurred
	private int lastPosition_y = 1;// index to remember where the last insertion
									// occurred

	/*
	 * Method that creates the first board. uses an Array of Array of type tile.
	 * the fixed pieces are created first, then the other randomized tiles are
	 * created. Then the 2D array is iterated over and the starting positions
	 * are set. Finally the extra tile that the first player gets is returned.
	 * 
	 * 
	 */
	public void createGameBoard() {
		_gameBoard = new Tile[7][7];
	}

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
		// System.out.println("1");

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
								this.assigntile(i, j, new OppositeDirectionTile(x, y));
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
		Pawn pawn1 = new Pawn("red", 2, 2, 0);
		Pawn pawn2 = new Pawn("yellow", 2, 4, 0);
		Pawn pawn3 = new Pawn("blue", 4, 2, 0);
		Pawn pawn4 = new Pawn("white", 2, 2, 0);
		// _gameBoard[2][2].
		// This free tile will be passed off to the player to begin the game
		if (_twoDirectionLeft == 1) {

			_freetile = new TwoDirectionTile(0, 1);
		} else if (_oppositeDirectionLeft == 1) {

			_freetile = new OppositeDirectionTile(0, 2);
		} else if (_threeDirectionLeft == 1) {

			_freetile = new ThreeDirectionTile(0, 1, 2);
		}
		// resets the tiles locations
		for (int i = 0; i < _gameBoard.length; i++) {
			for (int j = 0; j < _gameBoard.length; j++) {
				_gameBoard[i][j].setCoordinates(i, j);

			}
		}
		return _freetile;

	}

	// get unique number from 1 to x
	private int[] generateXuniqueNumber(int n, int x) {
		int uniqueInt[] = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= x; i++) {
			list.add(new Integer(i));
		}
		Collections.shuffle(list);
		for (int i = 0; i < n; i++) {
			uniqueInt[i] = list.get(i);
		}
		return uniqueInt;
	}

	// method to randomize the tiles, returns an int that is mapped to a tile.
	// 0 is twoDirection, 1 is opposite direction, 2 is three direction
	private static int randomTile() {
		int randomTile = (int) (Math.random() * 3);
		return randomTile;
	}

	// This method assign the _newtile to _tile
	public void assigntile(int x, int y, Tile _newtile) {
		_gameBoard[x][y] = _newtile;
	}

	// This method checks if this tile has value
	public boolean isnull() {
		return this == null;
	}

	// Method to check if the North Direction in the path is available
	public boolean isNopen() {
		return _tile.isNopen(); // method uses a different class' method with
								// the same name
	}

	// Method to check if the East Direction in the path is available
	public boolean isEopen() {
		return _tile.isEopen();// method uses a different class' method with the
								// same name
	}

	// Method to check if the South Direction in the path is available
	public boolean isSopen() {
		return _tile.isSopen();// method uses a different class' method with the
								// same name
	}

	// Method to check if the West Direction in the path is available
	public boolean isWopen() {
		return _tile.isWopen();// method uses a different class' method with the
								// same name
	}

	/** Tile currentTile() **/
	/** This method gives the tile info on this board point **/
	public Tile currentTile() {
		return _tile;
	}

	/*
	 * InsertTile method that inserts a tile onto the board. First it checks if
	 * the insertion is valid, then it checks if it's the same position as last
	 * insertion as last time. Then it replaces the tiles one by one by first
	 * copying the farthest tile in the row/column, then shifting the tile
	 * objects by one space. Then the tile to be inserted "tileInserted" is
	 * placed into the empty spot.
	 * 
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
						this.assigntile(i, insert_j, this.currentTile());
					}
					this.assigntile(0, insert_j, tileInserted);

				} // insertion occurred at left side, shift tiles right
				else if ((insert_j == 0) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
					_freetile = _gameBoard[insert_i][6];
					for (int j = 6; j > 0; j--) {
						this.assigntile(insert_i, j, this.currentTile());
					}
					this.assigntile(insert_i, 0, tileInserted);

				} // insertion occurred at right side, shift tiles left
				else if ((insert_j == 6) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
					_freetile = _gameBoard[insert_i][0];
					for (int j = 0; j < 6; j++) {
						this.assigntile(insert_i, j, this.currentTile());
					}
					this.assigntile(insert_i, 6, tileInserted);

				} // insertion happened on the bottom row, shift tiles up
				else if ((insert_i == 6) && (insert_j == 1 || insert_j == 3 || insert_j == 5)) {
					_freetile = _gameBoard[0][insert_j];
					for (int i = 0; i < 6; i++) {
						this.assigntile(insert_j, i, this.currentTile());
					}
					this.assigntile(6, insert_j, tileInserted);

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
/*
	// Constructor for a testing board. It has all 49 places already filled out
		public void boardToBeUsedForTesting() {

			
			Tile[][] _gameTest = new Tile[7][7];
			this.assigntile(0, 0, new ThreeDirectionTile(1, 2, 3));
			this.assigntile(0, 1, new ThreeDirectionTile(1, 2, 3));
			this.assigntile(0, 2, new ThreeDirectionTile(1, 2, 3));
			this.assigntile(0, 3, new ThreeDirectionTile(1, 2, 3));
			this.assigntile(0, 4, new ThreeDirectionTile(1, 2, 3));
			this.assigntile(0, 5, new ThreeDirectionTile(1, 2, 3));
			this.assigntile(0, 6, new ThreeDirectionTile(1, 2, 3));

			this.assigntile(1, 0, new ThreeDirectionTile(0, 1, 2));
			this.assigntile(1, 1, new ThreeDirectionTile(0, 1, 2));
			this.assigntile(1, 2, new ThreeDirectionTile(0, 1, 2));
			this.assigntile(1, 3, new ThreeDirectionTile(0, 1, 2));
			this.assigntile(1, 4, new ThreeDirectionTile(0, 1, 2));
			this.assigntile(1, 5, new ThreeDirectionTile(0, 1, 2));
			this.assigntile(1, 6, new ThreeDirectionTile(0, 1, 2));

			this.assigntile(2, 0, new TwoDirectionTile(1, 2));
			this.assigntile(2, 1, new TwoDirectionTile(1, 2));
			this.assigntile(2, 2, new TwoDirectionTile(1, 2));
			this.assigntile(2, 3, new TwoDirectionTile(1, 2));
			this.assigntile(2, 4, new TwoDirectionTile(1, 2));
			this.assigntile(2, 5, new TwoDirectionTile(1, 2));
			this.assigntile(2, 6, new TwoDirectionTile(1, 2));

			this.assigntile(3, 0, new OppositeDirectionTile(1, 3));
			this.assigntile(3, 1, new OppositeDirectionTile(1, 3));
			this.assigntile(3, 2, new OppositeDirectionTile(1, 3));
			this.assigntile(3, 3, new OppositeDirectionTile(1, 3));
			this.assigntile(3, 4, new OppositeDirectionTile(1, 3));
			this.assigntile(3, 5, new OppositeDirectionTile(1, 3));
			this.assigntile(3, 6, new OppositeDirectionTile(1, 3));

			this.assigntile(4, 0, new ThreeDirectionTile(0, 1, 3));
			this.assigntile(4, 1, new ThreeDirectionTile(0, 1, 3));
			this.assigntile(4, 2, new ThreeDirectionTile(0, 1, 3));
			this.assigntile(4, 3, new ThreeDirectionTile(0, 1, 3));
			this.assigntile(4, 4, new ThreeDirectionTile(0, 1, 3));
			this.assigntile(4, 5, new ThreeDirectionTile(0, 1, 3));
			this.assigntile(4, 6, new ThreeDirectionTile(0, 1, 3));

			this.assigntile(5, 0, new TwoDirectionTile(2, 3));
			this.assigntile(5, 1, new TwoDirectionTile(2, 3));
			this.assigntile(5, 2, new TwoDirectionTile(2, 3));
			this.assigntile(5, 3, new TwoDirectionTile(2, 3));
			this.assigntile(5, 4, new TwoDirectionTile(2, 3));
			this.assigntile(5, 5, new TwoDirectionTile(2, 3));
			this.assigntile(5, 6, new TwoDirectionTile(2, 3));

			this.assigntile(6, 0, new OppositeDirectionTile(0, 2));
			this.assigntile(6, 1, new OppositeDirectionTile(0, 2));
			this.assigntile(6, 2, new OppositeDirectionTile(0, 2));
			this.assigntile(6, 3, new OppositeDirectionTile(0, 2));
			this.assigntile(6, 4, new OppositeDirectionTile(0, 2));
			this.assigntile(6, 5, new OppositeDirectionTile(0, 2));
			this.assigntile(6, 6, new OppositeDirectionTile(0, 2));

		}*/

}