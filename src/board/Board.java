package board;

import java.util.ArrayList;
import java.util.Collections;
import pawn.*;
import tile.*;
import token.*;

public class Board {
	private Tile _tile;
	private boolean _istoken;
	private Token _token;
	private boolean _reachable;
	private boolean _haspawn;
	private int _currentPawnNum;
	private Pawn _pawn;
	public static int length = 7;
	private Board[][] _gameBoard;
	private Tile _freetile;
	private int lastPosition_x = 7; // index to remember where the last
									// insertion occurred
	private int lastPosition_y = 7;// index to remember where the last insertion
									// occurred
	private static int currentPlayer = 0;

	/*
	 * Method that creates the first board.
	 * uses an Array of Array of type tile.
	 * the fixed pieces are created first, 
	 * then the other randomized tiles are created.
	 * Then the 2D array is iterated over and
	 * the starting positions are set. 
	 * Finally the extra tile that the first player 
	 * gets is returned.
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
		
					int[] XYZ = generateXuniqueNumber(3,4);
					
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

		// This free tile will be passed off to the player to begin the game
		// int freeTile;
		if (_twoDirectionLeft == 1) {

			_freetile = new TwoDirectionTile(0, 1);
		} else if (_oppositeDirectionLeft == 1) {

			_freetile = new OppositeDirectionTile(0, 2);
		} else if (_threeDirectionLeft == 1) {

			_freetile = new ThreeDirectionTile(0, 1, 2);
		}
		//This is the tile the first player gets
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
	//0 is twoDirection, 1 is opposite direction, 2 is three direction
	private static int randomTile() {
		int randomTile = (int) (Math.random() * 3);
		return randomTile;
	}

	// TODO EDIT THIS
	public Board() {
		_istoken = false;
		_reachable = false;
		_haspawn = false;
		_currentPawnNum = 0;
	}

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

	// Method to print the values of objects on a tile
	public void printPoint() {
		_tile.showDirection();
		if (_istoken) {
			System.out.println(" ");
			_token.showyourself();
		}
		if (_haspawn) {
			System.out.println(" Pawn: ");
			System.out.println(_pawn.getColor());
		}
	}

	public void pawnMoveAway() {
		_currentPawnNum--;
		if (_currentPawnNum <= 0) {
			_haspawn = false;
		}
	}

	public void pawnMoveIn() {
		_currentPawnNum++;
		_haspawn = true;
	}

	/** Tile currentTile() **/
	/** This method gives the tile info on this board point **/
	public Tile currentTile() {
		return _tile;
	}



/// **void InsertTile(int i,int j)**/
// **This method used to insert a tile into a board at location [i,j]
// * When runs correctly, it prints the new board
// * when error occurs, it print out the error**/
/*
public void InsertTile(int insert_i, int insert_j) {

	Boardpoint TEMP = new Boardpoint();
	boolean valide = false; // indicate the insertion is valid, used to
							// print out a new board
	// check i and j is on the board
	if (insert_i >= 0 && insert_i <= 6 && insert_j >= 0 && insert_j <= 6) {
		// checks if it's the same position as last insertion
		if ((insert_i != lastPosition_x) || (insert_j != lastPosition_y)) {
			// check if it's a valid position to insert

			// insertion occurred at top row
			if ((insert_i == 0) && (insert_j == 1 || insert_j == 3 || insert_j == 5)) {
				valide = true;
				// move point downward
				TEMP = _gameBoard[6][insert_j];
				_gameBoard[6][insert_j] = _gameBoard[5][insert_j];
				_gameBoard[5][insert_j] = _gameBoard[4][insert_j];
				_gameBoard[4][insert_j] = _gameBoard[3][insert_j];
				_gameBoard[3][insert_j] = _gameBoard[2][insert_j];
				_gameBoard[2][insert_j] = _gameBoard[1][insert_j];
				_gameBoard[1][insert_j] = _gameBoard[0][insert_j];
				// copy everything except tile from pushed-out point to
				// inserting point
				_gameBoard[insert_i][insert_j] = TEMP;
				_gameBoard[insert_i][insert_j].assigntile(_freetile);
				_freetile = TEMP.currenttile();
				/*
				 * //change pawn's position if this pawn on the changing
				 * line for(for all pawn){ Pawn TEMP = ; if((TEMP.getYpos()
				 * ==1) || (TEMP.getYpos()==3) || (TEMP.getYpos()==5)){
				 * TEMP.setPos(TEMP.getXpos()+1, TEMP.getYpos()); } }
				 
			}
			// insertion occurred at bottom row
			else if ((insert_i == 6) && (insert_j == 1 || insert_j == 3 || insert_j == 5)) {
				valide = true;
				// move point upward
				TEMP = _gameBoard[0][insert_j];
				_gameBoard[0][insert_j] = _gameBoard[1][insert_j];
				_gameBoard[1][insert_j] = _gameBoard[2][insert_j];
				_gameBoard[2][insert_j] = _gameBoard[3][insert_j];
				_gameBoard[3][insert_j] = _gameBoard[4][insert_j];
				_gameBoard[4][insert_j] = _gameBoard[5][insert_j];
				_gameBoard[5][insert_j] = _gameBoard[6][insert_j];
				// copy everything except tile from pushed-out point to
				// inserting point
				_gameBoard[insert_i][insert_j] = TEMP;
				_gameBoard[insert_i][insert_j].assigntile(_freetile);
				_freetile = TEMP.currenttile();
				/*
				 * //change pawn's position if this pawn on the changing
				 * line for(){ Pawn TEMP = ; if((TEMP.getYpos() ==1) ||
				 * (TEMP.getYpos()==3) || (TEMP.getYpos()==5)){
				 * TEMP.setPos(TEMP.getXpos()-1, TEMP.getYpos()); } }
				 
			}
			// insertion occurred at left column
			else if ((insert_j == 0) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
				valide = true;
				// move point rightward
				TEMP = _gameBoard[insert_i][6];
				_gameBoard[insert_i][6] = _gameBoard[insert_i][5];
				_gameBoard[insert_i][5] = _gameBoard[insert_i][4];
				_gameBoard[insert_i][4] = _gameBoard[insert_i][3];
				_gameBoard[insert_i][3] = _gameBoard[insert_i][2];
				_gameBoard[insert_i][2] = _gameBoard[insert_i][1];
				_gameBoard[insert_i][1] = _gameBoard[insert_i][0];
				// copy everything except tile from pushed-out point to
				// inserting point
				_gameBoard[insert_i][insert_j] = TEMP;
				_gameBoard[insert_i][insert_j].assigntile(_freetile);
				_freetile = TEMP.currenttile();
				/*
				 * //change pawn's position if this pawn on the changing
				 * line for(){ Pawn TEMP = ; if((TEMP.getXpos() ==1) ||
				 * (TEMP.getXpos()==3) || (TEMP.getXpos()==5)){
				 * TEMP.setPos(TEMP.getXpos(), TEMP.getYpos()+1); } }
				 
			}
			// insertion occurred at right column
			else if ((insert_j == 6) && (insert_i == 1 || insert_i == 3 || insert_i == 5)) {
				valide = true;
				// move point leftward
				TEMP = _gameBoard[insert_i][0];
				_gameBoard[insert_i][0] = _gameBoard[insert_i][1];
				_gameBoard[insert_i][1] = _gameBoard[insert_i][2];
				_gameBoard[insert_i][2] = _gameBoard[insert_i][3];
				_gameBoard[insert_i][3] = _gameBoard[insert_i][4];
				_gameBoard[insert_i][4] = _gameBoard[insert_i][5];
				_gameBoard[insert_i][5] = _gameBoard[insert_i][6];
				// copy everything except tile from pushed-out point to
				// inserting point
				_gameBoard[insert_i][insert_j] = TEMP;
				_gameBoard[insert_i][insert_j].assigntile(_freetile);
				_freetile = TEMP.currenttile();
				
				 * //change pawn's position if this pawn on the changing
				 * line for(){ Pawn TEMP = ; if((TEMP.getXpos() ==1) ||
				 * (TEMP.getXpos()==3) || (TEMP.getXpos()==5)){
				 * TEMP.setPos(TEMP.getXpos(), TEMP.getYpos()-1); } }
				 
			} else {
				System.out.println("Error: Invalid position! \n");
			}

			if (valide == true) {
				lastPosition_x = insert_i;
				lastPosition_y = insert_j;
			}
		} else {
			System.out.println("Error: The same as last position! \n");
		}

	} else {
		System.out.println("Error: Out of boundary! \n");
	}
} */
}