package game;

import org.junit.Test;

import gameBoard.Boardpoint;
import pawn.Pawn;
import tile.OppositeDirectionTile;
import tile.Tile;

public class Test_maingame {
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
	private static int[] direction = {0,1,2,3}; //0=N,1=E,2=S,3=W
	

@Test public void test01() {
    	/**
    	 * create testing board
    	 * 
    	 */
				
			_gameBoard = new Boardpoint[7][7];
			for (int i = 0; i<7 ; i++){
				for (int j = 0; j < 7; j++){
					_gameBoard[i][j] = new Boardpoint();
					_gameBoard[i][j].assigntile(new OppositeDirectionTile(0));
				}
			}
			_pawnlist = new Pawn[4];			
			
			_pawnlist[0] = new Pawn("red", 2, 2, 111);
			_pawnlist[1] = new Pawn("yellow", 2, 4, 222);
			_pawnlist[2] = new Pawn("blue", 4, 2, 333);
			_pawnlist[3] = new Pawn("white", 4, 4, 444);
	
			if(oneSetpMovement(0)){
				System.out.println("move Sucess!");
			}

}


public static boolean oneSetpMovement(int toward){
	switch (toward){
		case 0:
			System.out.println("case 0 in!");
			if(_pawnlist[currentPlayer].getXpos() > 0){
				System.out.println("first IF!");
				_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].printPoint();
				System.out.println(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isNopen());
				System.out.println(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isEopen());
				System.out.println(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isSopen());
				System.out.println(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isWopen());
				if(_gameBoard[_pawnlist[currentPlayer].getXpos()-1 ][ _pawnlist[currentPlayer].getYpos()].isSopen()){
					System.out.println("second IF!");
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
					_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos()+1, _pawnlist[currentPlayer].getYpos());
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
					return true;
				}
			}
			return false;
		case 1:
			if(_pawnlist[currentPlayer].getYpos() < 6){
				if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()+1].isWopen()){
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
					_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos(), _pawnlist[currentPlayer].getYpos()+1);
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
					return true;
				}
			}
			return false;
		case 2:
			if(_pawnlist[currentPlayer].getXpos() <6){
				if(_gameBoard[_pawnlist[currentPlayer].getXpos()+1 ][ _pawnlist[currentPlayer].getYpos()].isNopen()){
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
					_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos()+1, _pawnlist[currentPlayer].getYpos());
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
					return true;
				}
			}
			return false;
		case 3:
			if(_pawnlist[currentPlayer].getYpos() >0){
				if(_gameBoard[_pawnlist[currentPlayer].getXpos() ][ _pawnlist[currentPlayer].getYpos()-1].isEopen()){
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveAway();
					_pawnlist[currentPlayer].setPos(_pawnlist[currentPlayer].getXpos(), _pawnlist[currentPlayer].getYpos()-1);
					_gameBoard[_pawnlist[currentPlayer].getXpos()][ _pawnlist[currentPlayer].getYpos()].pawnMoveIn();
					return true;
				}
			}
			return false;
		default:
			return false;
		}
	}
}
