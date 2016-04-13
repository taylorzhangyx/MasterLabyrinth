package token;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Token {
	final int _tokenValue; // this should never be modified
	private boolean _isPicked;
	private int _xPos;
	private int _yPos;
	private JLabel _image = new JLabel();

	public Token(int tokenValue) {
		_tokenValue = tokenValue;
		_isPicked = false;
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
	
	/**
	 * set image into the JLabel for further use
	 */
	public void setImage(){
		String path = new String();
		path = "/image/token/token" + _tokenValue + ".png";
		_image.setIcon(new ImageIcon(getClass().getResource(path)));
	}
	
	/**
	 * 
	 * @return get current icon on this Token
	 */
	public JLabel getImage(){
		return _image;
	}

}
