package gameBoard;

import tile.Tile;
import tile.TwoDirectionTile;

import java.util.ArrayList;
import tile.Tile;
import tile.OppositeDirectionTile;
import tile.ThreeDirectionTile;

//This class is for the creation of the gameBoard.
public class gameBoard {
	
	private static int length;
	private  Tile[][] _gameBoard;
	
	public gameBoard(){
		_gameBoard = new Tile[7][7]; 
	
		// This creates the 4 corner pieces
		_gameBoard[0][0] = new TwoDirectionTile(1, 2);
		_gameBoard[0][6] = new TwoDirectionTile(3, 2);
		_gameBoard[6][0] = new TwoDirectionTile(0, 1);
		_gameBoard[6][6] = new TwoDirectionTile(1, 3);

		// This creates the 2 top row fixed pieces
		_gameBoard[0][2] = new ThreeDirectionTile(1, 2, 3);
		_gameBoard[0][4] = new ThreeDirectionTile(1, 2, 3);

		// This creates the 2nd row fixed pieces
		_gameBoard[2][0] = new ThreeDirectionTile(0, 1, 2);
		_gameBoard[2][2] = new ThreeDirectionTile(0, 1, 2);
		_gameBoard[2][4] = new ThreeDirectionTile(1, 2, 3);
		_gameBoard[2][6] = new ThreeDirectionTile(0, 2, 3);

		// This creates the 4th row fixed pieces
		_gameBoard[4][0] = new ThreeDirectionTile(0, 1, 2);
		_gameBoard[4][2] = new ThreeDirectionTile(0, 1, 3);
		_gameBoard[4][4] = new ThreeDirectionTile(0, 2, 3);
		_gameBoard[4][6] = new ThreeDirectionTile(0, 2, 3);

		// This creates the 6th row fixed pieces
		_gameBoard[6][2] = new ThreeDirectionTile(0, 1, 3);
		_gameBoard[6][4] = new ThreeDirectionTile(0, 1, 3);
		// System.out.println("1");
		
		//these variables hold the amount of tiles left over
				int _twoDirectionLeft = 14;
				int _oppositeDirectionLeft = 13;
				int _threeDirectionLeft = 7;
				
				//fills every place in the array with a different tile
				for (int i = 0; i < _gameBoard.length; i++) {
					for (int j = 0; j < gameBoard.length; j++) {
						if (_gameBoard[i][j] == null) {
							// System.out.println("2");
							int _twoDir = 0;
							int _oppDir = 1;
							int _threeDir = 2; 
							int x = (int) (Math.random() * 4);
							int y = (int) (Math.random() * 4);
							int z = (int) (Math.random() * 4);
							int randomTile = randomTile();
							//while there is an empty place in the gameBoard, make a random tile, check if that tile
							//is free to be used, and fill the spot in the array
							while (_gameBoard[i][j] == null) {

								if (randomTile == _twoDir) {
									if (_twoDirectionLeft > 0) {
										_gameBoard[i][j] = new TwoDirectionTile(x, y);

										_twoDirectionLeft--;

									} else {
										randomTile = randomTile();
									}

								} else if (randomTile == _oppDir) {
									if (_oppositeDirectionLeft > 0) {

										_gameBoard[i][j] = new OppositeDirectionTile(x, y);
										_oppositeDirectionLeft--;
									} else {
										randomTile = randomTile();
									}
								}

								else if (randomTile == _threeDir) {
									if (_threeDirectionLeft > 0) {
										_gameBoard[i][j] = new ThreeDirectionTile(x, y, z);
										_threeDirectionLeft--;
									} else {
										randomTile = randomTile();
									}
								}
							}
						}
					}
				}
				
				//This will be passed off to the player to begin the game
				int freeTile;
				if(_twoDirectionLeft == 1){
					freeTile = 0;
				}
				else if(_oppositeDirectionLeft ==1){
					freeTile = 1;
				}
				else if (_threeDirectionLeft == 1){
					freeTile = 2;
				}
				/*
				int num = 0;
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard.length; j++) {
						System.out.println("#" + num + " " + gameBoard[i][j]);
						num++;
					}
				}*/
				//System.out.println(_twoDirectionLeft);
				//System.out.println(_oppositeDirectionLeft);
				//System.out.println(_threeDirectionLeft);
			}
	
	//this will be the method that creates the first board
	public void createGameBoard(){
		
	}
	public static void main(String[] args) {
		// public gameBoard() {
		
		// creates a new 2D array board object
		

		
		
	}
		
// method to randomize the tiles, returns an int that is mapped to a tile.
	private static int randomTile() {
		int randomTile = (int) (Math.random() * 3);
		return randomTile;
	}
	public void InsertTile(int i,int j){
		for(int e = 0; e<_gameBoard[i].length;e++){
			_gameBoard[i][j+6-e]=_gameBoard[i][j+5-e];
        
            _gameBoard[i][j] = new ThreeDirectionTile(0, 1, 2);	
            
            //so this is the insertion code, but i didnt finish it because i dont know how to finish it. 
            //bascially the idea is let the tile before equals to the current tile, then put in a new random tile in the front or end.
		
				
		}	
			
	     for(int p = 0; p<_gameBoard[j].length;p++){
		    _gameBoard[i+6-p][j]=_gameBoard[i+5-p+1][j];
		}
	}

}