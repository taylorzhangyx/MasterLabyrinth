package tile;

import java.util.ArrayList;

public class OppositeDirectionTile {
	private ArrayList<String> _direction;
	private ArrayList<String> _identityDirection;
	private String _n;
	private String _e;
	private String _s;
	private String _w;
	public  int TileNum ;

	public OppositeDirectionTile() {
		initializeDirectionArray();
		initializeDirectionalIdentity();
		/*
		System.out.println(_identityDirection);
		rotateClockwise();
		System.out.println(_identityDirection);
		rotateClockwise();
		System.out.println(_identityDirection);
		rotateClockwise();
		System.out.println(_identityDirection);
		*/
		
	}

	public void initializeDirectionalIdentity() {
		_identityDirection = new ArrayList<String>();
		_identityDirection.add(_direction.get(0));
		_identityDirection.add(_direction.get(2));
		
	}
		
		
	
	private void initializeDirectionArray() {

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
		String s = "";
		for(int i = 0; i<_direction.size();i++){
			s = s+(_direction.get(i));}
		s = s.substring(1, 4)+s.substring(0,1);
		_direction.clear();
		for(int j = 0; j<s.length();j++){
			_direction.add(""+s.charAt(j));}
		initializeDirectionalIdentity();
		
		

	}
}
