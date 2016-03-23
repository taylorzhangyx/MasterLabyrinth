package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import gameBoard.*;
import pawn.*;
import tile.*;
import token.*;

public class MainGame {

		//This class contains main function of the game
		//Include create gameboard, create pawn, 
		private static int length = 7;
		private static  Boardpoint[][] _gameBoard;
		private static Tile _freetile;
		
		//these two index remember where last insertion occurs, 
		//to avoid a reinsertion in the same place
		private static int lastPosition_x = 7;
		private static int lastPosition_y = 7;
		private static Pawn[] _pawnlist ;
		private static int currentPlayer = 0;
		private static String[] direction = {"N","E","S","W"}; //0=N,1=E,2=S,3=W
		
		public MainGame(){
			
		}
		
		public static void initializaition(){
			createGameBoard();
			createPawn();
			
		}
		
		/**this method creates all four pawns**/
		public static void createPawn(){
			//this array stores 4 pawn, red[3,3], yellow[3,5], blue[5,3], white[5,5]
			//also we can use linked list instead of array
			_pawnlist = new Pawn[4];
			
			int cardnum[] = generateXuniqueNumber(4, 21);
			
			_pawnlist[0] = new Pawn("red", 2, 2, cardnum[0]);
			_gameBoard[2][2].pawnMoveIn();
			_pawnlist[1] = new Pawn("yellow", 2, 4, cardnum[1]);
			_gameBoard[2][4].pawnMoveIn();
			_pawnlist[2] = new Pawn("blue", 4, 2, cardnum[2]);
			_gameBoard[4][2].pawnMoveIn();
			_pawnlist[3] = new Pawn("white", 4, 4, cardnum[3]);
			_gameBoard[4][4].pawnMoveIn();
		}
		
		//get unique number from 1 to x
		private static int[] generateXuniqueNumber(int n, int x){
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
		
		public static boolean oneSetpMovement(String toward){
			switch (toward.toUpperCase()){
				case "N":
					if(_pawnlist[currentPlayer].getXpos() > 0){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isReachable() && _gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()].isNopen()){
							if(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isSopen()){
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
								_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos()-1, _pawnlist[currentPlayer].getYpos());
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
								return true;
							}
						}
					}
					return false;
				case "E":
					if(_pawnlist[currentPlayer].getYpos() < 6){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()+1].isReachable() && _gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()].isEopen()){
							if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()+1].isWopen()){
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
								_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos(), _pawnlist[currentPlayer].getYpos()+1);
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
								return true;
							}
						}
					}
					return false;
				case "S":
					if(_pawnlist[currentPlayer].getXpos() <6){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos()+1 ][ _pawnlist[currentPlayer].getYpos()].isReachable() && _gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()].isSopen()){					
							if(_gameBoard[_pawnlist[currentPlayer].getXpos()+1 ][ _pawnlist[currentPlayer].getYpos()].isNopen()){
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
								_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos()+1, _pawnlist[currentPlayer].getYpos());
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
								return true;
							}
						}
					}
					return false;
				case "W":
					if(_pawnlist[currentPlayer].getYpos() >0){
						if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()-1].isReachable() && _gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()].isWopen()){					
							if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()-1].isEopen()){
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
								_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos(), _pawnlist[currentPlayer].getYpos()-1);
								_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
								return true;
							}
						}
					}
					return false;
				default:
					return false;
				}
			}
	
		
		//this will be the method that creates the first board
		public static void createGameBoard(){
			_gameBoard = new Boardpoint[7][7]; 
			for (int i = 0; i<7 ; i++){
				for (int j = 0; j < 7; j++){
					_gameBoard[i][j] = new Boardpoint();
				}
			}
		
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
			initializaition();
			printALL();			
			Scanner scanIn = new Scanner(System.in);
			int commandint = 999;
			
			/**choose player section**/
			while(commandint != 9){
				System.out.println("Please choose your player. \n 0 is red, \n 1 is yellow,\n 2 is blue, \n3 is white.\n");
				System.out.println("Once you finish, type 9");
				
				commandint = scanIn.nextInt();
				if(commandint >=0 && commandint <=3){
					_pawnlist[commandint].setOnBoard();
					System.out.printf("Pawn %d : %s is online!", commandint, _pawnlist[commandint].getColor());					
				}
				else if(commandint == 9){
					System.out.println("Choosing Pawn Finish!");
				}
				else {
					System.out.println("Are you kidding me? Wrong Number!");
				}
			}
			
			while(commandint != 100){
				int shift_x = 0;
				int shift_y = 0;
				
				for(int i=0;i<4;i++){
					if(_pawnlist[i].isOnBoard()){
						_pawnlist[i].isMyTurn();
						/**shifting tile part**/
						do{
						System.out.printf("Pawn %d: %s, it's your turn to insert tile \n", i, _pawnlist[i].getColor());
						
						System.out.println("First type the insert location index X:");
						shift_x = scanIn.nextInt();
						System.out.println("Then type the insert location index Y:");
						shift_y = scanIn.nextInt();}
						while(!InsertTile(shift_x, shift_y));
						printALL();	
						/**moving pawn part**/
						System.out.printf("Pawn %d: %s, it's your turn to insert tile \n", i, _pawnlist[i].getColor());
						System.out.printf("Please type, N means up, E means right, S means down, W means left, END means finish moving\n");
						
						for(int n = 0; n < MainGame.length ; n++){
							for(int j = 0 ; j < MainGame.length ; j++){
									_gameBoard[n][j].resetReachable();
							}
						}
						String commandstr = new String();
						while(!commandstr.equals("END")){							
							commandstr = scanIn.nextLine();
							if(oneSetpMovement(commandstr)){
								System.out.println("Move Success!");
								printALL();
								_pawnlist[i].printPawn();
								}
							else{
								System.out.println("Move failed!");
							}
						}
						printALL();		
						_pawnlist[i].notMyTurn();
					}							
				}
				System.out.println("This round is over, what to continue? If you want to EXIT, type 100");
				commandint = scanIn.nextInt();
			
			}
			System.out.println("Game Stop!");
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
		public static boolean InsertTile(int insert_i,int insert_j){
			
			Boardpoint TEMP = new Boardpoint();
			Tile _TEMPtile ;
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
						_TEMPtile = TEMP.currenttile();
						_gameBoard[6][insert_j] = _gameBoard[5][insert_j];
						_gameBoard[5][insert_j] = _gameBoard[4][insert_j];
						_gameBoard[4][insert_j] = _gameBoard[3][insert_j];
						_gameBoard[3][insert_j] = _gameBoard[2][insert_j];
						_gameBoard[2][insert_j] = _gameBoard[1][insert_j];
						_gameBoard[1][insert_j] = _gameBoard[0][insert_j];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);
						_freetile = _TEMPtile;
						
						//change pawn's position if this pawn on the changing line
						for(int i = 0; i < 4 ; i++){
							Pawn TEMP1 = _pawnlist[i];
							if( TEMP1.isOnBoard()){
								if((TEMP1.getYpos() ==1) || (TEMP1.getYpos()==3) || (TEMP1.getYpos()==5)){
									TEMP1.setPos(TEMP1.getXpos()+1, TEMP1.getYpos());
								}
							}
						}
					}
					//insertion occurred at bottom row
					else if((insert_i == 6) && (insert_j == 1 || insert_j == 3 || insert_j == 5)){
						valide = true;
						//move point upward
						TEMP = _gameBoard[0][insert_j];
						_TEMPtile = TEMP.currenttile();
						_gameBoard[0][insert_j] = _gameBoard[1][insert_j];
						_gameBoard[1][insert_j] = _gameBoard[2][insert_j];
						_gameBoard[2][insert_j] = _gameBoard[3][insert_j];
						_gameBoard[3][insert_j] = _gameBoard[4][insert_j];
						_gameBoard[4][insert_j] = _gameBoard[5][insert_j];
						_gameBoard[5][insert_j] = _gameBoard[6][insert_j];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);
						_freetile = _TEMPtile;
						
						//change pawn's position if this pawn on the changing line
						for(int i = 0; i < 4 ; i++){
							Pawn TEMP1 = _pawnlist[i];
							if( TEMP1.isOnBoard()){
								if((TEMP1.getYpos() ==1) || (TEMP1.getYpos()==3) || (TEMP1.getYpos()==5)){
									TEMP1.setPos(TEMP1.getXpos()-1, TEMP1.getYpos());
								}
							}
						}
					}
					//insertion occurred at left column
					else if((insert_j == 0) && (insert_i == 1 || insert_i == 3 || insert_i == 5)){
						valide = true;
						//move point rightward
						TEMP = _gameBoard[insert_i][6];
						_TEMPtile = TEMP.currenttile();
						_gameBoard[insert_i][6] = _gameBoard[insert_i][5];
						_gameBoard[insert_i][5] = _gameBoard[insert_i][4];
						_gameBoard[insert_i][4] = _gameBoard[insert_i][3];
						_gameBoard[insert_i][3] = _gameBoard[insert_i][2];
						_gameBoard[insert_i][2] = _gameBoard[insert_i][1];
						_gameBoard[insert_i][1] = _gameBoard[insert_i][0];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);	
						_freetile = _TEMPtile;
						
						//change pawn's position if this pawn on the changing line
						for(int i = 0; i < 4 ; i++){
							Pawn TEMP1 = _pawnlist[i];
							if( TEMP1.isOnBoard()){
								if((TEMP1.getXpos() ==1) || (TEMP1.getXpos()==3) || (TEMP1.getXpos()==5)){
									TEMP1.setPos(TEMP1.getXpos(), TEMP1.getYpos()+1);
								}
							}
						}
					}
					//insertion occurred at right column
					else if((insert_j == 6) && (insert_i == 1 || insert_i == 3 || insert_i == 5)){
						valide = true;
						//move point leftward
						TEMP = _gameBoard[insert_i][0];
						_TEMPtile = TEMP.currenttile();
						_gameBoard[insert_i][0] = _gameBoard[insert_i][1];
						_gameBoard[insert_i][1] = _gameBoard[insert_i][2];
						_gameBoard[insert_i][2] = _gameBoard[insert_i][3];
						_gameBoard[insert_i][3] = _gameBoard[insert_i][4];
						_gameBoard[insert_i][4] = _gameBoard[insert_i][5];
						_gameBoard[insert_i][5] = _gameBoard[insert_i][6];
						//copy everything except tile from pushed-out point to inserting point
						_gameBoard[insert_i][insert_j] = TEMP;
						_gameBoard[insert_i][insert_j].assigntile(_freetile);	
						_freetile = _TEMPtile;
						
						//change pawn's position if this pawn on the changing line
						for(int i = 0; i < 4 ; i++){
							Pawn TEMP1 = _pawnlist[i];
							if( TEMP1.isOnBoard()){
								if((TEMP1.getXpos() ==1) || (TEMP1.getXpos()==3) || (TEMP1.getXpos()==5)){
									TEMP1.setPos(TEMP1.getXpos(), TEMP1.getYpos()-1);
								}
							}
						}
					}
					else {
						System.out.println("Error: Invalid position! \n");
					}
					
					if(valide == true){
						lastPosition_x = insert_i;
						lastPosition_y = insert_j;
						return true;
					}
					else{
						return false;
					}
				}
				else{
					System.out.println("Error: The same as last position! \n");
					return false;
				}
				
			}
			else{
				System.out.println("Error: Out of boundary! \n");
				return false;
			}
		}
		
		/**Used to print out all the information out
		 * including all board point, tile direction, pawn location, token**/
		public static void printALL(){
			//print board out
			for(int i = 0; i < MainGame.length ; i++){
				for(int j = 0 ; j < MainGame.length ; j++){
					System.out.printf("[%d,%d]", i , j);
					_gameBoard[i][j].printPoint();
					
					System.out.printf("\t");
				}
				System.out.printf("\n");
			}
			//print pawn
			for(int i = 0; i<4; i++){
				System.out.printf("%d ",i);
				_pawnlist[i].printPawn();
			}
			//print free tile
			System.out.printf("Free Tile: ");
			_freetile.showDirection();
			System.out.printf("\n");
		}
}
