package token;

public class Token {
	final int _tokenValue; // this should never be modified
	private boolean _isPicked;
	private int _xPos;
	private int _yPos;

	public Token(int tokenValue) {
		_tokenValue = tokenValue;
		_isPicked = true;

	}

	public int getTokenValue() {
		return _tokenValue;
	}

	public void changeXpos(int x) {
		_xPos = x;
	}

	public void changeYpos(int y) {
		_yPos = y;
	}

	public void showyourself() {
		System.out.println("Token" + _tokenValue);
	}

	public boolean isPicked() {
		return _isPicked;
	}

}
