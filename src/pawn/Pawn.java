package pawn;

import java.util.ArrayList;

import java.util.Collections;
import tile.*;

public class Pawn {
	private String _color;
	private boolean _onBoard;
	private boolean _myTurn;
	private int _score;
	private int _x;
	private int _y;
	private int _wand;
	private int _formulaCard;
	private static Pawn[] _pawnlist;

	public Pawn(String color, int xPos, int yPos, int _formulaCard) {
		_color = color;
		_x = xPos;
		_y = yPos;
		_score = 0;
		_onBoard = false;
		_myTurn = false;
		
		//the number of wand is fixed at the beginning of game, which is initialized as 3
		_wand = 3;
	}

	
	public void createPawn() {
		_pawnlist = new Pawn[4];

		int cardNum[] = generateXuniqueNumber(4, 21);

		_pawnlist[0] = new Pawn("red", 3, 3, cardNum[0]);
		_pawnlist[1] = new Pawn("yellow", 3, 5, cardNum[1]);
		_pawnlist[2] = new Pawn("blue", 5, 3, cardNum[2]);
		_pawnlist[3] = new Pawn("white", 5, 5, cardNum[3]);
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
	
	
	public void initializaition() {
		createPawn();
	}
	
	
	public String getColor() {

		return _color;
	}
	public boolean isOnBoard(){
		return _onBoard;
	}
	public boolean myTurn(){
		return _myTurn;
	}
	public int getScore(){
		return _score;
	}
	public int getXpos(){
		return _x;
	}
	public int getYpos(){
		return _y;
	}
	public int getWandLeft(){
		return _wand;
	}
	public int getFormulaCard(){
		return _formulaCard;
	}
	public boolean useWand(){
		if(_wand >0){
			_wand = _wand -1;
			return true;
		}
		else {return false;}
	}
	public void setPos(int x,int y){
		if(x<0){x=6;}
		if(x>6){x=0;}
		if(y<0){y=6;}
		if(y>6){y=0;}
		_x = x;
		_y = y;
	}
	public void setScore(int tokenValue){
		_score = _score + tokenValue;
		//add functionality later that calculates if the token is a part of the secret formula
		
	}
	
	/*
	public class movePawn {
		*
		 * NEEDS TO BE WORKED ON !!!!
		 * 
		 * 
		 *  
		 
		public boolean moveOneStep(Tile currentTile) {
			
			boolean[] neighborList = currentTile.hasNeighbor();
			
			
			return false;
		}*/
	
		
}
