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

	public Pawn(String color, int xPos, int yPos, int wand, int _formulaCard) {
		_color = color;
		_x = xPos;
		_y = yPos;
		_score = 0;
		_onBoard = true;
		_myTurn = false;
		_wand = wand;
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
		_x = x;
		_y = y;
	}
	public void setScore(int tokenValue){
		_score = _score + tokenValue;
		//add functionality later that calculates if the token is a part of the secret formula
		
	}
	
	
	
	
}
