package code.Parent;

import java.util.ArrayList;

import code.Pawn.Pawn;

public abstract class Tile {
	private ArrayList<String> _direction;
	private ArrayList<String> _identityDirection;
	private String _n;
	private String _e;
	private String _s;
	private String _w;
	private boolean _hasPawn;
	private Pawn _player;
	private String _color;
	private boolean _hasToken;
	private int x;
	private int y;
	
	

	public Tile() {

	}

	public void initializeDirectionalIdentity() {

	}

	public void initializeDirectionArray() {

	}

	public boolean hasDirection(String direction) {

		return false;
	}

	public void rotateClockwise() {

	}
	public void rotateClockwiseTwoTimes() {

	}
	public void rotateClockwiseThreeTimes() {

	}

}
