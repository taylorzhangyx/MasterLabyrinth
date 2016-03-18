package token;

public class Token {
	final int _tokenValue; //this should never be modified
	private boolean _isPicked;
	
	/****************************************************/
	//once the board is initialized, the token is moving with tile, specifically BoardPoint
	//I doubt if we need to use x y in token to show position again
	/****************************************************/
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
	
	public void showyourself(){
		System.out.println("Token" + _tokenValue);
	}
}
