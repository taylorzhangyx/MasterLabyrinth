package token;

public class Token {
	final int _tokenValue; //this should never be modified
	private boolean _isPicked;
	private int _xPos;
	private int _yPos;

	public Token(int tokenValue,int x, int y){
		_tokenValue = tokenValue;
		_isPicked = false;
		_xPos = x;
		_yPos = y;
		
	}
	
	public void pickTokenUp(){
		_isPicked = true;	
	}
	public void changeXpos(int x){
		_xPos = x;
	}
	public void changeYpos(int y){
		_yPos = y;
	}
}
