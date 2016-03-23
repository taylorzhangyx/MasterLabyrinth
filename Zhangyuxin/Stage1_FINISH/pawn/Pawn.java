package pawn;

public class Pawn {
	private String _color;
	private boolean _onBoard;
	private boolean _myTurn;
	private int _score;
	private int _x;
	private int _y;
	private int _wand;
	private int _formulaCard;

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

	public String getColor() {

		return _color;
	}
	public boolean isOnBoard(){
		return _onBoard;
	}
	public boolean myTurn(){
		return _myTurn;
	}
	public void isMyTurn(){
		_myTurn = true;
	}
	public void notMyTurn(){
		_myTurn = false;
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
	
	public void setOnBoard(){
		_onBoard = true;
	}
	public void setScore(int tokenValue){
		_score = _score + tokenValue;
		//add functionality later that calculates if the token is a part of the secret formula
		
	}
	public void printPawn(){
		
		System.out.printf("%s [%d,%d] wand:%d score:%d formularcard:%d isYourTurn:" + _myTurn +"\n", _color,_x,_y,_wand,_score,_formulaCard);
		
	}
		
}
