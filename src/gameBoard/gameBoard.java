package gameBoard;

import java.util.ArrayList;

public class gameBoard {
	// int param = 7;

	/// Delete this class tile, and import the one that Chris, Wilson made
	public class tile {
		// String name;
		// boolean a;

		public tile() {
			// this.name = name;
			// this.a = a;
			// }
		}
	}
	/////////////

	// public void createBoard() {
	public static void main(String[] args) {
		int param = 7;
		
		
		
		ArrayList<tile> column = new ArrayList<tile>();
		ArrayList<ArrayList<tile>> board = new ArrayList<ArrayList<tile>>();
		for (int x = 0; x < param; x++) {
			for (int y = 0; y < param; y++) {
				board.add(column);
			}
		}

		System.out.println(board.size());

		// }
	}
}
