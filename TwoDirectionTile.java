package code.Parent;

import java.util.ArrayList;

public class TwoDirectionTile extends Tile {
	private ArrayList<String> _direction;
	private ArrayList<String> _identityDirection;
	private String _n;
	private String _e;
	private String _s;
	private String _w;

	public TwoDirectionTile() {
		initializeDirectionArray();
		initializeDirectionalIdentity();
		
	

	}

	public void initializeDirectionalIdentity() {
		_identityDirection = new ArrayList<String>();
		_identityDirection.add(_direction.get(0));
		_identityDirection.add(_direction.get(1));
		
	}

	public void initializeDirectionArray() {
		_direction = new ArrayList<String>();
		_n = "N";
		_e = "E";
		_s = "S";
		_w = "W";
		_direction.add(_n);
		_direction.add(_e);
		_direction.add(_s);
		_direction.add(_w);
		System.out.println(_direction);

	}

	public boolean hasDirection(String direction) {
		return false;
	}
	
	public void rotateClockwise(){

		String temp = "";
		for (int i  = 0; i<_direction.size(); i++){
			temp = temp + _direction.get(i);
		}
		temp = temp.substring(1, 4)+ temp.substring(0,1);
		_direction.clear();
		for (int k = 0; k<temp.length(); k++){
			_direction.add(""+temp.charAt(k));
		}
		initializeDirectionalIdentity();
		
	}

}
