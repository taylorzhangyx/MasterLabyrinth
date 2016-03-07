package tile;

import java.util.ArrayList;

public abstract class Tile {
	private ArrayList<String> _direction;
	private ArrayList<String> _identityDirection;
	private String _n;
	private String _e;
	private String _s;
	private String _w;

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

}
