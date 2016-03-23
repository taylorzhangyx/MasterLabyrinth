package board;

import java.util.ArrayList;
import java.util.Collections;
import pawn.*;
import tile.*;
import token.*;

public class Board {
	private Tile _tile;

	public static int length = 7;
	public Board[][] _gameBoard;
	public Tile _freetile;
	private int lastPosition_x = 7; // index to remember where the last
									// insertion occurred
	private int lastPosition_y = 7;// index to remember where the last insertion
									// occurred

	/*
	 * Method that creates the first board. uses an Array of Array of type tile.
	 * the fixed pieces are created first, then the other randomized tiles are
	 * created. Then the 2D array is iterated over and the starting positions
	 * are set. Finally the extra tile that the first player gets is returned.
	 * 
	 * 
	 */
	public Tile createGameBoard() {
		_gameBoard = new Board[7][7];
		// Using a compass rose to define directions
		// N is 0
		// E is 1
		// S is 2
		// W is 3

		// This creates the 4 corner pieces
		_gameBoard[0][0].assigntile(new TwoDirectionTile(1, 2));
		_gameBoard[0][6].assigntile(new TwoDirectionTile(2, 3));
		_gameBoard[6][6].assigntile(new TwoDirectionTile(0, 3));
		_gameBoard[6][0].assigntile(new TwoDirectionTile(0, 1));

		// This creates the 2 top row fixed pieces
		_gameBoard[0][2].assigntile(new ThreeDirectionTile(1, 2, 3));
		_gameBoard[0][4].assigntile(new ThreeDirectionTile(1, 2, 3));

		// This creates the 2nd row fixed pieces
		_gameBoard[2][0].assigntile(new ThreeDirectionTile(0, 1, 2));
		_gameBoard[2][2].assigntile(new ThreeDirectionTile(0, 1, 2));
		//_gameBoard[2][2].currentTile().setPawns("red");
		_gameBoard[2][4].assigntile(new ThreeDirectionTile(1, 2, 3));
		_gameBoard[2][6].assigntile(new ThreeDirectionTile(0, 2, 3));

		// This creates the 4th row fixed pieces
		_gameBoard[4][0].assigntile(new ThreeDirectionTile(0, 1, 2));
		_gameBoard[4][2].assigntile(new ThreeDirectionTile(0, 1, 3));
		_gameBoard[4][4].assigntile(new ThreeDirectionTile(0, 2, 3));
		_gameBoard[4][6].assigntile(new ThreeDirectionTile(0, 2, 3));

		// This creates the 6th row fixed pieces
		_gameBoard[6][2].assigntile(new ThreeDirectionTile(0, 1, 3));
		_gameBoard[6][4].assigntile(new ThreeDirectionTile(0, 1, 3));
		// System.out.println("1");

		// these variables hold the amount of tiles left over
		int _twoDirectionLeft = 14;
		int _oppositeDirectionLeft = 13;
		int _threeDirectionLeft = 7;

		// fills every (empty) place in the array with a different, randomized
		// tile
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (_gameBoard[i][j].isnull()) {
					// System.out.println("2");
					int _twoDir = 0;
					int _oppDir = 1;
					int _threeDir = 2;

					int[] XYZ = generateXuniqueNumber(3, 4);

					int x = XYZ[0];
					int y = XYZ[1];
					int z = XYZ[2];

					int randomTile = randomTile();

					// while there is an empty place in the gameBoard, make a
					// random tile, check if that tile
					// is free to be used, and fill the spot in the array
					while (_gameBoard[i][j].isnull()) {

						if (randomTile == _twoDir) {
							if (_twoDirectionLeft > 0) {
								_gameBoard[i][j].assigntile(new TwoDirectionTile(x, y));

								_twoDirectionLeft--;

							} else {
								randomTile = randomTile();
							}

						} else if (randomTile == _oppDir) {
							if (_oppositeDirectionLeft > 0) {

								_gameBoard[i][j].assigntile(new OppositeDirectionTile(x, y));
								_oppositeDirectionLeft--;
							} else {
								randomTile = randomTile();
							}
						}

						else if (randomTile == _threeDir) {
							if (_threeDirectionLeft > 0) {
								_gameBoard[i][j].assigntile(new ThreeDirectionTile(x, y, z));
								_threeDirectionLeft--;
							} else {
								randomTile = randomTile();
							}
						}
					}
				}
			}
		}

		// loop to iterate over the entire board and set the tile's current
		// position
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				currentTile().setCoordinates(i, j);
			}
		}
		//make the pawns on the board
		Pawn pawn1 = new Pawn("red", 2, 2, 0);
		Pawn pawn2 = new Pawn("yellow", 2, 4, 0);
		Pawn pawn3 = new Pawn("blue", 4, 2, 0);
		Pawn pawn4 = new Pawn("white", 2, 2, 0);
		//_gameBoard[2][2].
		// This free tile will be passed off to the player to begin the game
		if (_twoDirectionLeft == 1) {

			_freetile = new TwoDirectionTile(0, 1);
		} else if (_oppositeDirectionLeft == 1) {

			_freetile = new OppositeDirectionTile(0, 2);
		} else if (_threeDirectionLeft == 1) {

			_freetile = new ThreeDirectionTile(0, 1, 2);
		}
		// This is the tile the first player gets
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
	/*
	 * // TODO EDIT THIS public Board() { _istoken = false; _reachable = false;
	 * _haspawn = false; _currentPawnNum = 0; }
	 */

	// This method assign the _newtile to _tile
	public void assigntile(Tile _newtile) {
		_tile = _newtile;
	}

	// This method checks if this tile has value
	public boolean isnull() {
		return _tile == null;
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
	/*
	 * // Method to print the values of objects on a tile public void
	 * printPoint() { _tile.showDirection(); if (_istoken) { System.out.println(
	 * " "); _token.showyourself(); } if (_haspawn) { System.out.println(
	 * " Pawn: "); System.out.println(_pawn.getColor()); } }
	 * 
	 * public void pawnMoveAway() { _currentPawnNum--; if (_currentPawnNum <= 0)
	 * { _haspawn = false; } }
	 * 
	 * public void pawnMoveIn() { _currentPawnNum++; _haspawn = true; }
	 */

	/** Tile currentTile() **/
	/** This method gives the tile info on this board point **/
	public Tile currentTile() {
		return _tile;
	}

	/*
	 * InsertTile method that inserts a tile onto the board. First it checks if
	 * the insertion is valid, then it checks if it's the same position as last
	 * insertion as last time. Then it replaces the tiles one by one.
	 * 
	 */
	public Tile InsertTile(int insert_i, int insert_j, Tile tileInserted) {
		// checks if its on the board
		if (insert_i >= 0 && insert_i <= 6 && insert_j >= 0 && insert_j <= 6)

		{
			// check if it's a valid position to insert
			if ((insert_i != lastPosition_x) || (insert_j != lastPosition_y)) {

				// insertion occurred at top row ;// move point downward
				if ((insert_i == 0) && (insert_j == 1 || insert_j == 3 || insert_j == 5)) {
					_freetile = _gameBoard[6][insert_j].currentTile();
					_gameBoard[6][insert_j].assigntile(_gameBoard[5][insert_j].currentTile());
					_gameBoard[5][insert_j].assigntile(_gameBoard[4][insert_j].currentTile());
					_gameBoard[4][insert_j].assigntile(_gameBoard[3][insert_j].currentTile());
					_gameBoard[3][insert_j].assigntile(_gameBoard[2][insert_j].currentTile());
					_gameBoard[2][insert_j].assigntile(_gameBoard[1][insert_j].currentTile());
					_gameBoard[1][insert_j].assigntile(_gameBoard[0][insert_j].currentTile());
					_gameBoard[0][insert_j].assigntile(tileInserted);

				} // left side insertion
				else if ((insert_j == 0) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
					_freetile = _gameBoard[insert_i][6].currentTile();
					_gameBoard[insert_i][6].assigntile(_gameBoard[insert_i][5].currentTile());
					_gameBoard[insert_i][5].assigntile(_gameBoard[insert_i][4].currentTile());
					_gameBoard[insert_i][4].assigntile(_gameBoard[insert_i][3].currentTile());
					_gameBoard[insert_i][3].assigntile(_gameBoard[insert_i][2].currentTile());
					_gameBoard[insert_i][2].assigntile(_gameBoard[insert_i][1].currentTile());
					_gameBoard[insert_i][1].assigntile(_gameBoard[insert_i][0].currentTile());
					_gameBoard[insert_i][0].assigntile(tileInserted);

				} // right side insertion
				else if ((insert_j == 6) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
					_freetile = _gameBoard[insert_i][0].currentTile();
					_gameBoard[insert_i][0].assigntile(_gameBoard[insert_i][1].currentTile());
					_gameBoard[insert_i][1].assigntile(_gameBoard[insert_i][2].currentTile());
					_gameBoard[insert_i][2].assigntile(_gameBoard[insert_i][3].currentTile());
					_gameBoard[insert_i][3].assigntile(_gameBoard[insert_i][4].currentTile());
					_gameBoard[insert_i][4].assigntile(_gameBoard[insert_i][5].currentTile());
					_gameBoard[insert_i][5].assigntile(_gameBoard[insert_i][6].currentTile());
					_gameBoard[insert_i][6].assigntile(tileInserted);

				} // bottom row insertion
				else if ((insert_i == 6) && (insert_j == 1 || insert_j == 3 || insert_j == 5)) {
					_freetile = _gameBoard[0][insert_j].currentTile();
					_gameBoard[0][insert_j].assigntile(_gameBoard[1][insert_j].currentTile());
					
					_gameBoard[1][insert_j].assigntile(_gameBoard[2][insert_j].currentTile());
					_gameBoard[2][insert_j].assigntile(_gameBoard[3][insert_j].currentTile());
					_gameBoard[3][insert_j].assigntile(_gameBoard[4][insert_j].currentTile());
					_gameBoard[4][insert_j].assigntile(_gameBoard[5][insert_j].currentTile());
					_gameBoard[5][insert_j].assigntile(_gameBoard[6][insert_j].currentTile());
					_gameBoard[6][insert_j].assigntile(tileInserted);

				}
				//resets the tiles locations
				for(int i = 0; i < _gameBoard.length; i++){
					for(int j = 0; j < _gameBoard.length; j++){
						_gameBoard[i][j].currentTile().setCoordinates(i,j);
						if(_gameBoard[i][j].currentTile().hasPawn()){
							
							
						}
					}
				}
				
				
				
				
				
				// if the freetile has a pawn on it, then copy that value(s)
				// over to the opposite
				// side, then delete it
				if (_freetile.hasPawn()) {
					ArrayList<String> temp = _freetile.pawnsOnTile();
					for(int i = 0; i<temp.size(); i++){
					_gameBoard[insert_i][insert_j].currentTile().setPawns(temp.get(i));
					}
					_freetile.erasePawn("red");
					_freetile.erasePawn("yellow");
					_freetile.erasePawn("blue");
					_freetile.erasePawn("white");
				}
				// if the freetile has a token on it, then copy that value over
				// to
				// the opposite side, then delete it from freetile
				if (_freetile.hasToken()) {
					int temp = _freetile.tokenOnTile();
					_freetile.eraseToken();
					_gameBoard[0][insert_j].currentTile().setToken(temp);
				}
				lastPosition_x = insert_i;
				lastPosition_y = insert_j;
			}
		}
		return _freetile;
	}

}