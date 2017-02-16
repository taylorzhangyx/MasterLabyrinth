package token;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This token class construct a token with value and corresponding image
 * @author Yuxin Zhang
 * @time 上午11:34:002017年2月16日2017
 */
public class Token {
	private int _tokenValue; // this should never be modified
	private boolean _isPicked;
	private JLabel _image = new JLabel();

	public Token(int tokenValue) {
		_tokenValue = tokenValue;
		_isPicked = false;
	}

	public int getTokenValue() {
		return _tokenValue;
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
	 * extract Image on the token
	 * 
	 * @return get current icon on this Token
	 */
	public JLabel getImage(){
		return _image;
	}

}
