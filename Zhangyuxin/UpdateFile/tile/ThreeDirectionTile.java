package tile;

public class ThreeDirectionTile extends Tile {
	//private ArrayList<String> _direction;
	//private ArrayList<String> _identityDirection;
	private boolean _n;
	private boolean _e;
	private boolean _s;
	private boolean _w;

	public ThreeDirectionTile(int x) {
		initialization(x);
		//rotateClockwiseThreeTimes();
		//System.out.println(_identityDirection);
		
	}

	public void initialization(int x) {
			//	x represents the type of this tile
			// 	x = 0 represents, W & N & E is open
			//	x = 1 represents, N & E & S is open
			//	x = 2 represents, E & S & W is open
			//	x = 3 represents, S & W & N is open
		switch (x){
			case 0:
				_n = true;
				_e = true;
				_s = false;
				_w = true;
				break;
			case 1:
				_n = true;
				_e = true;
				_s = true;
				_w = false;
				break;
			case 2:
				_n = false;
				_e = true;
				_s = true;
				_w = true;
				break;
			case 3:
				_n = true;
				_e = false;
				_s = true;
				_w = true;
				break;
			default:
				break;
		}
	}
	

	/**void showDirection()**/
	/**This function gives the current status of this tile, output as String, in the form of **/
	/**"[N 'status'] [E 'status'] [S 'status'] [W 'status'] " where status replaced by false/true**/
	public void showDirection() {
		System.out.println("[N " + _n + "] [E " + _e + "] [S " + _s +"] [W " + _w);
		
	}
	
	/**void rotateClockwise()**/
	/**This function rotate this tile by one step clockwise**/
	public void rotateClockwise(){
		boolean TEMP;
		TEMP = _w;
		_w = _s;
		_s = _e;
		_e = _n;
		_n = TEMP;		
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
	
	/**void rotate anticlockwiseClockwise()**/
	/**This function rotate this tile by one step anticlockwise**/
	public void rotateAntiClockwise(){
		boolean TEMP;
		TEMP = _e;
		_e = _s;
		_s = _w;
		_w = _n;
		_n = TEMP;		
	}
	
	public void rotateAntiClockwiseTwoTimes() {
		rotateAntiClockwise();
		rotateAntiClockwise();
	}
	public void rotateAntiClockwiseThreeTimes() {
		rotateAntiClockwise();
		rotateAntiClockwise();
		rotateAntiClockwise();
	}
}