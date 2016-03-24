package board;

import tile.*;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

public class boardTest {
	
	@Test
	/*
	 * Test for the populateBoard(), makes sure that the method populateBoard
	 * returns a tile that is a subclass of type tile.
	 * 
	 */
	public void populateBoardTest() {

		Board test = new Board();
		test.createGameBoard();
		assertThat(test.populateBoard(), instanceOf(Tile.class));

	}
	/*
	@Test
	public void insertTileTest(){
		Board test = new Board();
		
		test.boardToBeUsedForTesting();
		
	}*/

	
	
	
	

}
