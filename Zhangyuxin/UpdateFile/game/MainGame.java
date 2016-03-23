package game;

import java.util.ArrayList;
import java.util.Collections;

import gameBoard.*;
import pawn.*;
import tile.*;
import token.*;

public class MainGame {

		//This class contains main function of the game
		//Include create gameboard, create pawn, 
		private static int length = 7;
		private  Boardpoint[][] _gameBoard;
		private Tile _freetile;
		
		//these two index remember where last insertion occurs, 
		//to avoid a reinsertion in the same place
		private int lastPosition_x = 7;
		private int lastPosition_y = 7;
		private static Pawn[] _pawnlist ;
		private static int currentPlayer = 0;
		
		public MainGame(){
			
		}
		
		public void initializaition(){
			createPawn
		}
		
		/**this method creates all four pawns**/
		public void createPawn(){
			//this array stores 4 pawn, red[3,3], yellow[3,5], blue[5,3], white[5,5]
			//also we can use linked list instead of array
			_pawnlist = new Pawn[4];
			
			int cardnum[] = generateXuniqueNumber(4, 21);
			
			_pawnlist[0] = new Pawn("red", 2, 2, cardnum[0]);
			_pawnlist[1] = new Pawn("yellow", 2, 4, cardnum[1]);
			_pawnlist[2] = new Pawn("blue", 4, 2, cardnum[2]);
			_pawnlist[3] = new Pawn("white", 4, 4, cardnum[3]);
		}
		
		//get unique number from 1 to x
		private int[] generateXuniqueNumber(int n, int x){
			int uniqueint[] = new int[n];
			ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=1; i<=x; i++) {
	            list.add(new Integer(i));
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<n; i++) {
	            uniqueint[i] = list.get(i);
	        }
	        return uniqueint;
		}
		
		public void oneSetpMovement(String toward){
			switch (toward.toUpperCase()){
				case "N":
					if(_pawnlist[currentPlayer].getXpos() < 6){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos()+1 ][ _pawnlist[currentPlayer].getYpos()].isSopen()){
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
							_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos()+1, _pawnlist[currentPlayer].getYpos());
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
						}
					}
				break;
				case "E":
					if(_pawnlist[currentPlayer].getYpos() < 6){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()+1].isSopen()){
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
							_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos(), _pawnlist[currentPlayer].getYpos()+1);
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
						}
					}
				break;
				case "S":
					if(_pawnlist[currentPlayer].getXpos() >0){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isSopen()){
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
							_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos()-1, _pawnlist[currentPlayer].getYpos());
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
						}
					}
				break;
				case "W":
					if(_pawnlist[currentPlayer].getYpos() >0){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()-1].isSopen()){
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
							_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos(), _pawnlist[currentPlayer].getYpos()-1);
							_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
						}
					}
				break;
				default:
					break;
				}
			}
		
		
		
		//this will be the method that creates the first board
		public void createGameBoard(){
			_gameBoard = new Boardpoint[7][7]; 
		
			// This creates the 4 corner pieces
			_gameBoard[0][0].assigntile(new TwoDirectionTile(1));
			_gameBoard[0][6].assigntile(new TwoDirectionTile(2));
			_gameBoard[6][6].assigntile(new TwoDirectionTile(3));
			_gameBoard[6][0].assigntile(new TwoDirectionTile(0));

			// This creates the 2 top row fixed pieces
			_gameBoard[0][2].assigntile(new ThreeDirectionTile(2));
			_gameBoard[0][4].assigntile(new ThreeDirectionTile(2));

			// This creates the 2nd row fixed pieces
			_gameBoard[2][0].assigntile(new ThreeDirectionTile(1));
			_gameBoard[2][2].assigntile(new ThreeDirectionTile(1));
			_gameBoard[2][4].assigntile(new ThreeDirectionTile(2));
			_gameBoard[2][6].assigntile(new ThreeDirectionTile(3));

			// This creates the 4th row fixed pieces
			_gameBoard[4][0].assigntile(new ThreeDirectionTile(1));
			_gameBoard[4][2].assigntile(new ThreeDirectionTile(0));
			_gameBoard[4][4].assigntile(new ThreeDirectionTile(3));
			_gameBoard[4][6].assigntile(new ThreeDirectionTile(3));

			// This creates the 6th row fixed pieces
			_gameBoard[6][2].assigntile(new ThreeDirectionTile(0));
			_gameBoard[6][4].assigntile(new ThreeDirectionTile(0));
			// System.out.println("1");
			
			//these variables hold the amount of tiles left over
					int _twoDirectionLeft = 14;
					int _oppositeDirectionLeft = 13;
					int _threeDirectionLeft = 7;
					
					//fills every place in the array with a different tile
					for (int i = 0; i < MainGame.length; i++) {
						for (int j = 0; j < MainGame.length; j++) {
							if (_gameBoard[i][j].isnull()) {
								// System.out.println("2");
								int _twoDir = 0;
								int _oppDir = 1;
								int _threeDir = 2; 
								int x = (int) (Math.random() * 4);
								int randomTile = randomTile();
								//while there is an empty place in the gameBoard, make a random tile, check if that tile
								//is free to be used, and fill the spot in the array
								while (_gameBoard[i][j].isnull()) {

									if (randomTile == _twoDir) {
										if (_twoDirectionLeft > 0) {
											_gameBoard[i][j].assigntile(new TwoDirectionTile(x));

											_twoDirectionLeft--;

										} else {
											randomTile = randomTile();
										}

									} else if (randomTile == _oppDir) {
										if (_oppositeDirectionLeft > 0) {

											_gameBoard[i][j].assigntile(new OppositeDirectionTile(x%2));
											_oppositeDirectionLeft--;
										} else {
											randomTile = randomTile();
										}
									}

									else if (randomTile == _threeDir) {
										if (_threeDirectionLeft > 0) {
											_gameBoard[i][j].assigntile(new ThreeDirectionTile(x));
											_threeDirectionLeft--;
										} else {
											randomTile = randomTile();
										}
									}
								}
							}
						}
					}
					
					//This free tile will be passed off to the player to begin the game
					//int freeTile;
					
					if(_twoDirectionLeft == 1){
						int x = (int) (Math.random() * 4);
						_freetile = new TwoDirectionTile(x);
					}
					else if(_oppositeDirectionLeft ==1){
						int x = (int) (Math.random() * 4);
						_freetile = new OppositeDirectionTile(x%2);
					}
					else if (_threeDirectionLeft == 1){
						int x = (int) (Math.random() * 4);
						_freetile = new ThreeDirectionTile(x);
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
		
		
		public static void main(String[] args) {
					
			
		}
			
	// method to randomize the tiles, returns an int that is mapped to a tile.
		private static int randomTile() {
			int randomTile = (int) (Math.random() * 3);
			return randomTile;
		}
		
		/**void InsertTile(int i,int j)**/
		/**This method used to insert a tile into a board at location [i,j]
		 * When runs correctly, it prints the new board
		 * when error occurs, it print out the error**/
		public void InsertTile(int insert_i,int insert_j){
			
			Boardpoint TEMP = new Boardpoint();
			boolean valide = false; //indicate the insertion is valid, used to print out a new board
			//check i and j is on the board
			if(insert_i>=0 && insert_i<=6 && insert_j >= 0 && insert_j <= 6){
			//checks if it's the same position as last insersion
				if( (insert_i != lastPosition_x) || (insert_j != lastPosition_y) ){
					//check if it's a valid position to insert
					
					//insertion occurred at top row
					if((insert_i == 0) && (insert_j == 1 || insert_j == 3 || insert_j == 5)){
						valide = true;
						//move point downward						
						TEMP = _gameBoard[6][insert_j];
						_gameBoard[6][insert_j] = _gameBoard[5][insert_j];
						_gameBoard[5][insert_j] = _gameBoard[4][insert_j];
						_gameBoard[4][insert_j] = _gameBoard[3][insert_j];
						_gameBoard[3][insert_j] = _gameBoard[2][insert_j];
						_gameBoard[2][insert_j] = _gameBoard[1][insert_j];
						_gameBoard[1][insert_j] = _gameBoard[0][insert_j];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);	
						_freetile = TEMP.currenttile();
						
						//change pawn's position if this pawn on the changing line
						for(/*for all pawn*/){
							Pawn TEMP = /*current pawn*/;
							if((TEMP.getYpos() ==1) || (TEMP.getYpos()==3) || (TEMP.getYpos()==5)){
								TEMP.setPos(TEMP.getXpos()+1, TEMP.getYpos());
							}
						}
					}
					//insertion occurred at bottom row
					else if((insert_i == 6) && (insert_j == 1 || insert_j == 3 || insert_j == 5)){
						valide = true;
						//move point upward
						TEMP = _gameBoard[0][insert_j];
						_gameBoard[0][insert_j] = _gameBoard[1][insert_j];
						_gameBoard[1][insert_j] = _gameBoard[2][insert_j];
						_gameBoard[2][insert_j] = _gameBoard[3][insert_j];
						_gameBoard[3][insert_j] = _gameBoard[4][insert_j];
						_gameBoard[4][insert_j] = _gameBoard[5][insert_j];
						_gameBoard[5][insert_j] = _gameBoard[6][insert_j];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);
						_freetile = TEMP.currenttile();
						
						//change pawn's position if this pawn on the changing line
						for(/*for all pawn*/){
							Pawn TEMP = /*current pawn*/;
							if((TEMP.getYpos() ==1) || (TEMP.getYpos()==3) || (TEMP.getYpos()==5)){
								TEMP.setPos(TEMP.getXpos()-1, TEMP.getYpos());
							}
						}
					}
					//insertion occurred at left column
					else if((insert_j == 0) && (insert_i == 1 || insert_i == 3 || insert_i == 5)){
						valide = true;
						//move point rightward
						TEMP = _gameBoard[insert_i][6];
						_gameBoard[insert_i][6] = _gameBoard[insert_i][5];
						_gameBoard[insert_i][5] = _gameBoard[insert_i][4];
						_gameBoard[insert_i][4] = _gameBoard[insert_i][3];
						_gameBoard[insert_i][3] = _gameBoard[insert_i][2];
						_gameBoard[insert_i][2] = _gameBoard[insert_i][1];
						_gameBoard[insert_i][1] = _gameBoard[insert_i][0];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);	
						_freetile = TEMP.currenttile();
						
						//change pawn's position if this pawn on the changing line
						for(/*for all pawn*/){
							Pawn TEMP = /*current pawn*/;
							if((TEMP.getXpos() ==1) || (TEMP.getXpos()==3) || (TEMP.getXpos()==5)){
								TEMP.setPos(TEMP.getXpos(), TEMP.getYpos()+1);
							}
						}
					}
					//insertion occurred at right column
					else if((insert_j == 6) && (insert_i == 1 || insert_i == 3 || insert_i == 5)){
						valide = true;
						//move point leftward
						TEMP = _gameBoard[insert_i][0];
						_gameBoard[insert_i][0] = _gameBoard[insert_i][1];
						_gameBoard[insert_i][1] = _gameBoard[insert_i][2];
						_gameBoard[insert_i][2] = _gameBoard[insert_i][3];
						_gameBoard[insert_i][3] = _gameBoard[insert_i][4];
						_gameBoard[insert_i][4] = _gameBoard[insert_i][5];
						_gameBoard[insert_i][5] = _gameBoard[insert_i][6];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);	
						_freetile = TEMP.currenttile();
						
						//change pawn's position if this pawn on the changing line
						for(/*for all pawn*/){
							Pawn TEMP = /*current pawn*/;
							if((TEMP.getXpos() ==1) || (TEMP.getXpos()==3) || (TEMP.getXpos()==5)){
								TEMP.setPos(TEMP.getXpos(), TEMP.getYpos()-1);
							}
						}
					}
					else {
						System.out.println("Error: Invalid position! \n");
					}
					
					if(valide == true){
						lastPosition_x = insert_i;
						lastPosition_y = insert_j;
					}
				}
				else{
					System.out.println("Error: The same as last position! \n");
				}
				
			}
			else{
				System.out.println("Error: Out of boundary! \n");
			}
		}
		
		/**Used to print out all the information out
		 * including all board point, tile direction, pawn location, token**/
		public void printALL(){
			//print board out
			for(int i = 0; i < MainGame.length ; i++){
				for(int j = 0 ; j < MainGame.length ; j++){
					System.out.printf("[%d,%d]", i , j);
					_gameBoard[i][j].printPoint();
					System.out.printf("\t");
				}
				System.out.printf("\n");
			}
			//print free tile
			System.out.printf("Free Tile: ");
			_freetile.showDirection();
			//print pawn info
			/**this area need more work**/
			
		}

}
