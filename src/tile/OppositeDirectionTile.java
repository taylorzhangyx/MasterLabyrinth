package tile;

import java.util.ArrayList;

public class OppositeDirectionTile extends Tile {
	private ArrayList<String> _direction;
	private ArrayList<String> _identityDirection;
	private String _n;
	private String _e;
	private String _s;
	private String _w;

	public OppositeDirectionTile(int x, int y) {
		initializeDirectionArray();
		initializeDirectionalIdentity(x,y);
		

		
		
	}

	public void initializeDirectionalIdentity(int x, int y) {
		_identityDirection = new ArrayList<String>();
		_identityDirection.add(_direction.get(x));
		_identityDirection.add(_direction.get(y));
		
	}
		
		
	
	public 	 void initializeDirectionArray() {

		_direction = new ArrayList<String>();
		_n = "N";
		_e = "E";
		_s = "S";
		_w = "W";
		_direction.add(_n);
		_direction.add(_e);
		_direction.add(_s);
		_direction.add(_w);
		

	}

	public boolean hasDirection(String direction) {
		return false;
	}
	
	public void rotateClockwise(){
		String s = "";
		for(int i = 0; i<_direction.size();i++){
			s = s+(_direction.get(i));}
		s = s.substring(1, 4)+s.substring(0,1);
		_direction.clear();
		for(int j = 0; j<s.length();j++){
			_direction.add(""+s.charAt(j));}
		initializeDirectionalIdentity();
		
		

	}
	public void rotateClockwiseTwoTimes() {
		rotateClockwise();
		rotateClockwise();
	}
	public void rotateClockwiseThreeTimes() {
		rotateClockwise();
		rotateClockwise();
		rotateClockwise();
	
	}
}
