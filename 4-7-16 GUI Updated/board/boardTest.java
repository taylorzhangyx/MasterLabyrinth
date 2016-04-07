package board;

import tile.*;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

public class boardTest {

	@Test
	/*
	 * Test for the populateTestBoard(), makes sure that the method
	 * populateBoard returns a tile that is a subclass of type tile.
	 * 
	 */
	public void populateBoardTest1() {

		Board b = new Board();
		b.createGameBoard();
		b.populateBoard();
		Tile[][] temp = b.gameBoard();
		for (int i = 0; i < 7; i++) {
			for (int o = 0; o < 7; o++) {
				temp[i][o].isEopen();
			}
		}
		assertTrue("", true);
		/*
		 * I did not need to compare anything. As long as my for loop ran
		 * through the whole 2D Array without giving me a null pointer
		 * exception, then the JUnit test passes. We cannot call a method on a
		 * null reference, so If we do not get a null pointer exception, the
		 * populateBoardTest passes.
		 */
	}
	
	
	@Test
		/*
		 * Test for the populateBoard(), makes sure that the method populateBoard
		 * returns a tile that is a subclass of type tile.
		 * 
		 */
		public void populateBoardTest2() {
	
			Board test = new Board();
			test.createGameBoard();
			assertThat(test.populateBoard(), instanceOf(Tile.class));
		}

	@Test
	public void shiftTestForIndex10() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][0].isNopen();
		boolean Eactual = temp[1][0].isEopen();
		boolean Sactual = temp[1][0].isSopen();
		boolean Wactual = temp[1][0].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex11() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[1][1].isNopen();
		boolean Eactual = temp[1][1].isEopen();
		boolean Sactual = temp[1][1].isSopen();
		boolean Wactual = temp[1][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex12() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][2].isNopen();
		boolean Eactual = temp[1][2].isEopen();
		boolean Sactual = temp[1][2].isSopen();
		boolean Wactual = temp[1][2].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex13() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[1][3].isNopen();
		boolean Eactual = temp[1][3].isEopen();
		boolean Sactual = temp[1][3].isSopen();
		boolean Wactual = temp[1][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex14() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][4].isNopen();
		boolean Eactual = temp[1][4].isEopen();
		boolean Sactual = temp[1][4].isSopen();
		boolean Wactual = temp[1][4].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex15() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[1][5].isNopen();
		boolean Eactual = temp[1][5].isEopen();
		boolean Sactual = temp[1][5].isSopen();
		boolean Wactual = temp[1][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex16() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][6].isNopen();
		boolean Eactual = temp[1][6].isEopen();
		boolean Sactual = temp[1][6].isSopen();
		boolean Wactual = temp[1][6].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex30() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[3][0].isNopen();
		boolean Eactual = temp[3][0].isEopen();
		boolean Sactual = temp[3][0].isSopen();
		boolean Wactual = temp[3][0].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex31() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[3][1].isNopen();
		boolean Eactual = temp[3][1].isEopen();
		boolean Sactual = temp[3][1].isSopen();
		boolean Wactual = temp[3][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex32() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[3][2].isNopen();
		boolean Eactual = temp[3][2].isEopen();
		boolean Sactual = temp[3][2].isSopen();
		boolean Wactual = temp[3][2].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex33() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[3][3].isNopen();
		boolean Eactual = temp[3][3].isEopen();
		boolean Sactual = temp[3][3].isSopen();
		boolean Wactual = temp[3][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex34() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[3][4].isNopen();
		boolean Eactual = temp[3][4].isEopen();
		boolean Sactual = temp[3][4].isSopen();
		boolean Wactual = temp[3][4].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex35() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[3][5].isNopen();
		boolean Eactual = temp[3][5].isEopen();
		boolean Sactual = temp[3][5].isSopen();
		boolean Wactual = temp[3][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex36() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = false;
		boolean Nactual = temp[3][6].isNopen();
		boolean Eactual = temp[3][6].isEopen();
		boolean Sactual = temp[3][6].isSopen();
		boolean Wactual = temp[3][6].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex50() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[5][0].isNopen();
		boolean Eactual = temp[5][0].isEopen();
		boolean Sactual = temp[5][0].isSopen();
		boolean Wactual = temp[5][0].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex51() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[5][1].isNopen();
		boolean Eactual = temp[5][1].isEopen();
		boolean Sactual = temp[5][1].isSopen();
		boolean Wactual = temp[5][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex52() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[5][2].isNopen();
		boolean Eactual = temp[5][2].isEopen();
		boolean Sactual = temp[5][2].isSopen();
		boolean Wactual = temp[5][2].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex53() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = false;
		boolean Nactual = temp[5][3].isNopen();
		boolean Eactual = temp[5][3].isEopen();
		boolean Sactual = temp[5][3].isSopen();
		boolean Wactual = temp[5][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex54() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[5][4].isNopen();
		boolean Eactual = temp[5][4].isEopen();
		boolean Sactual = temp[5][4].isSopen();
		boolean Wactual = temp[5][4].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex55() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[5][5].isNopen();
		boolean Eactual = temp[5][5].isEopen();
		boolean Sactual = temp[5][5].isSopen();
		boolean Wactual = temp[5][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void shiftTestForIndex56() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 0, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		;
		boolean Nactual = temp[5][6].isNopen();
		boolean Eactual = temp[5][6].isEopen();
		boolean Sactual = temp[5][6].isSopen();
		boolean Wactual = temp[5][6].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex10() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][0].isNopen();
		boolean Eactual = temp[1][0].isEopen();
		boolean Sactual = temp[1][0].isSopen();
		boolean Wactual = temp[1][0].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex11() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[1][1].isNopen();
		boolean Eactual = temp[1][1].isEopen();
		boolean Sactual = temp[1][1].isSopen();
		boolean Wactual = temp[1][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex12() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][2].isNopen();
		boolean Eactual = temp[1][2].isEopen();
		boolean Sactual = temp[1][2].isSopen();
		boolean Wactual = temp[1][2].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex13() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[1][3].isNopen();
		boolean Eactual = temp[1][3].isEopen();
		boolean Sactual = temp[1][3].isSopen();
		boolean Wactual = temp[1][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex14() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][4].isNopen();
		boolean Eactual = temp[1][4].isEopen();
		boolean Sactual = temp[1][4].isSopen();
		boolean Wactual = temp[1][4].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex15() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[1][5].isNopen();
		boolean Eactual = temp[1][5].isEopen();
		boolean Sactual = temp[1][5].isSopen();
		boolean Wactual = temp[1][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex16() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(1, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;

		boolean Nactual = temp[1][6].isNopen();
		boolean Eactual = temp[1][6].isEopen();
		boolean Sactual = temp[1][6].isSopen();
		boolean Wactual = temp[1][6].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex30() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[3][0].isNopen();
		boolean Eactual = temp[3][0].isEopen();
		boolean Sactual = temp[3][0].isSopen();
		boolean Wactual = temp[3][0].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex31() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[3][1].isNopen();
		boolean Eactual = temp[3][1].isEopen();
		boolean Sactual = temp[3][1].isSopen();
		boolean Wactual = temp[3][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex32() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[3][2].isNopen();
		boolean Eactual = temp[3][2].isEopen();
		boolean Sactual = temp[3][2].isSopen();
		boolean Wactual = temp[3][2].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex33() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[3][3].isNopen();
		boolean Eactual = temp[3][3].isEopen();
		boolean Sactual = temp[3][3].isSopen();
		boolean Wactual = temp[3][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex34() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = false;
		boolean Nactual = temp[3][4].isNopen();
		boolean Eactual = temp[3][4].isEopen();
		boolean Sactual = temp[3][4].isSopen();
		boolean Wactual = temp[3][4].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex35() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[3][5].isNopen();
		boolean Eactual = temp[3][5].isEopen();
		boolean Sactual = temp[3][5].isSopen();
		boolean Wactual = temp[3][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex36() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(3, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[3][6].isNopen();
		boolean Eactual = temp[3][6].isEopen();
		boolean Sactual = temp[3][6].isSopen();
		boolean Wactual = temp[3][6].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex50() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[5][0].isNopen();
		boolean Eactual = temp[5][0].isEopen();
		boolean Sactual = temp[5][0].isSopen();
		boolean Wactual = temp[5][0].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex51() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = false;
		boolean Nactual = temp[5][1].isNopen();
		boolean Eactual = temp[5][1].isEopen();
		boolean Sactual = temp[5][1].isSopen();
		boolean Wactual = temp[5][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex52() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[5][2].isNopen();
		boolean Eactual = temp[5][2].isEopen();
		boolean Sactual = temp[5][2].isSopen();
		boolean Wactual = temp[5][2].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex53() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[5][3].isNopen();
		boolean Eactual = temp[5][3].isEopen();
		boolean Sactual = temp[5][3].isSopen();
		boolean Wactual = temp[5][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex54() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[5][4].isNopen();
		boolean Eactual = temp[5][4].isEopen();
		boolean Sactual = temp[5][4].isSopen();
		boolean Wactual = temp[5][4].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex55() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[5][5].isNopen();
		boolean Eactual = temp[5][5].isEopen();
		boolean Sactual = temp[5][5].isSopen();
		boolean Wactual = temp[5][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void OshiftTestForIndex56() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(5, 6, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		;
		boolean Nactual = temp[5][6].isNopen();
		boolean Eactual = temp[5][6].isEopen();
		boolean Sactual = temp[5][6].isSopen();
		boolean Wactual = temp[5][6].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));

	}

	@Test
	public void CShiftTestForIndex01() {

		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 1, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[0][1].isNopen();
		boolean Eactual = temp[0][1].isEopen();
		boolean Sactual = temp[0][1].isSopen();
		boolean Wactual = temp[0][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex11() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 1, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[1][1].isNopen();
		boolean Eactual = temp[1][1].isEopen();
		boolean Sactual = temp[1][1].isSopen();
		boolean Wactual = temp[1][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex21() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 1, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[2][1].isNopen();
		boolean Eactual = temp[2][1].isEopen();
		boolean Sactual = temp[2][1].isSopen();
		boolean Wactual = temp[2][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex31() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 1, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[3][1].isNopen();
		boolean Eactual = temp[3][1].isEopen();
		boolean Sactual = temp[3][1].isSopen();
		boolean Wactual = temp[3][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex41() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 1, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[4][1].isNopen();
		boolean Eactual = temp[4][1].isEopen();
		boolean Sactual = temp[4][1].isSopen();
		boolean Wactual = temp[4][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex51() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 1, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = false;
		boolean Nactual = temp[5][1].isNopen();
		boolean Eactual = temp[5][1].isEopen();
		boolean Sactual = temp[5][1].isSopen();
		boolean Wactual = temp[5][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex61() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 1, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[6][1].isNopen();
		boolean Eactual = temp[6][1].isEopen();
		boolean Sactual = temp[6][1].isSopen();
		boolean Wactual = temp[6][1].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex03() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 3, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[0][3].isNopen();
		boolean Eactual = temp[0][3].isEopen();
		boolean Sactual = temp[0][3].isSopen();
		boolean Wactual = temp[0][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex13() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 3, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[1][3].isNopen();
		boolean Eactual = temp[1][3].isEopen();
		boolean Sactual = temp[1][3].isSopen();
		boolean Wactual = temp[1][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex23() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 3, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[2][3].isNopen();
		boolean Eactual = temp[2][3].isEopen();
		boolean Sactual = temp[2][3].isSopen();
		boolean Wactual = temp[2][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex33() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 3, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[3][3].isNopen();
		boolean Eactual = temp[3][3].isEopen();
		boolean Sactual = temp[3][3].isSopen();
		boolean Wactual = temp[3][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex43() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 3, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[4][3].isNopen();
		boolean Eactual = temp[4][3].isEopen();
		boolean Sactual = temp[4][3].isSopen();
		boolean Wactual = temp[4][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex53() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 3, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[5][3].isNopen();
		boolean Eactual = temp[5][3].isEopen();
		boolean Sactual = temp[5][3].isSopen();
		boolean Wactual = temp[5][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex63() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 3, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[6][3].isNopen();
		boolean Eactual = temp[6][3].isEopen();
		boolean Sactual = temp[6][3].isSopen();
		boolean Wactual = temp[6][3].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex05() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 5, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[0][5].isNopen();
		boolean Eactual = temp[0][5].isEopen();
		boolean Sactual = temp[0][5].isSopen();
		boolean Wactual = temp[0][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex15() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 5, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[1][5].isNopen();
		boolean Eactual = temp[1][5].isEopen();
		boolean Sactual = temp[1][5].isSopen();
		boolean Wactual = temp[1][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex25() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 5, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[2][5].isNopen();
		boolean Eactual = temp[2][5].isEopen();
		boolean Sactual = temp[2][5].isSopen();
		boolean Wactual = temp[2][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex35() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 5, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = true;
		boolean Nactual = temp[3][5].isNopen();
		boolean Eactual = temp[3][5].isEopen();
		boolean Sactual = temp[3][5].isSopen();
		boolean Wactual = temp[3][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex45() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 5, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = true;
		boolean Eexpected = true;
		boolean Sexpected = false;
		boolean Wexpected = false;
		boolean Nactual = temp[4][5].isNopen();
		boolean Eactual = temp[4][5].isEopen();
		boolean Sactual = temp[4][5].isSopen();
		boolean Wactual = temp[4][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex55() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 5, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which
		// directions
		boolean Nexpected = false;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = true;
		boolean Nactual = temp[5][5].isNopen();
		boolean Eactual = temp[5][5].isEopen();
		boolean Sactual = temp[5][5].isSopen();
		boolean Wactual = temp[5][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	@Test
	public void CShiftTestForIndex65() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(0, 5, b.getFreeTile());
		// the board class has fixed pieces in all 49 positions on the 2D array.
		// I know which tiles have which`
		// directions
		boolean Nexpected = true;
		boolean Eexpected = false;
		boolean Sexpected = true;
		boolean Wexpected = false;
		boolean Nactual = temp[6][5].isNopen();
		boolean Eactual = temp[6][5].isEopen();
		boolean Sactual = temp[6][5].isSopen();
		boolean Wactual = temp[6][5].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}

	private void commonTestCShiftTest(int x, int y, int c, int d, boolean Nexpected, boolean Eexpected, boolean Sexpected,
			boolean Wexpected) {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		b.InsertTile(c, d, b.getFreeTile());

		boolean Nactual = temp[x][y].isNopen();
		boolean Eactual = temp[x][y].isEopen();
		boolean Sactual = temp[x][y].isSopen();
		boolean Wactual = temp[x][y].isWopen();
		assertTrue("", (Nexpected == Nactual && Eexpected == Eactual && Sexpected == Sactual && Wexpected == Wactual));
	}
	
	
	@Test public void test61() { commonTestCShiftTest(6,1,6,1,false, false, true, true);}
	@Test public void test51() { commonTestCShiftTest(5,1,6,1,true, true, false, false);}
	@Test public void test41() { commonTestCShiftTest(4,1,6,1,false, true, true, true);}
	@Test public void test31() { commonTestCShiftTest(3,1,6,1,true, true, false, false);}
	@Test public void test21() { commonTestCShiftTest(2,1,6,1,true, false, true, false);}
	@Test public void test11() { commonTestCShiftTest(1,1,6,1,false, true, false, true);}
	@Test public void test01() { commonTestCShiftTest(0,1,6,1,false, true, true, true);}
	
	@Test public void test63() { commonTestCShiftTest(6,3,6,3,false, false, true, true);}
	@Test public void test53() { commonTestCShiftTest(5,3,6,3,true, false, false, true);}
	@Test public void test43() { commonTestCShiftTest(4,3,6,3,false, false, true, true);}
	@Test public void test33() { commonTestCShiftTest(3,3,6,3,false, true, false, true);}
	@Test public void test23() { commonTestCShiftTest(2,3,6,3,true, true, false, true);}
	@Test public void test13() { commonTestCShiftTest(1,3,6,3,false, true, false, true);}
	@Test public void test03() { commonTestCShiftTest(0,3,6,3,true, false, true, true);}
	
	@Test public void test65() { commonTestCShiftTest(6,5,6,5,false, false, true, true);}
	@Test public void test55() { commonTestCShiftTest(5,5,6,5,true, false, false, true);}
	@Test public void test45() { commonTestCShiftTest(4,5,6,5,true, false, true, false);}
	@Test public void test35() { commonTestCShiftTest(3,5,6,5,false, false, true, true);}
	@Test public void test25() { commonTestCShiftTest(2,5,6,5,true, true, false, false);}
	@Test public void test15() { commonTestCShiftTest(1,5,6,5,false, true, false, true);}
	@Test public void test05() { commonTestCShiftTest(0,5,6,5,true, false, true, true);}
	
	@Test public void freeTileTest(){
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		Tile[][] temp = b.gameBoard();
		Tile compare = b.InsertTile(0, 5, b.getFreeTile());
		boolean nExpected = compare.isNopen();
		boolean eExpected = compare.isEopen();
		boolean sExpected = compare.isSopen();
		boolean wExpected = compare.isWopen();
		boolean nActual = true;
		boolean eActual = false;
		boolean sActual = false;
		boolean wActual = true;
		
		assertTrue("", (nExpected == nActual&&eExpected==eActual&&sExpected==sActual&&wExpected==wActual));
		
	}

	
}
