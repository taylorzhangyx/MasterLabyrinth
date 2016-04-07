package board;

import static org.junit.Assert.*;

import org.junit.Test;

import tile.Tile;

public class pickUpTokenTest {

	@Test
	public void test1() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		b.addTokensToBoard();
		boolean expected = false;
		Tile[][] temp = b.gameBoard();
		temp[0][0].setToken(1);
		temp[0][0].pickUpToken(b.getPawn("red"));
		boolean actual = temp[0][0].hasToken();
		assertTrue("I expected " + expected + " but was actually " + actual, expected == actual);
	}
	
	@Test
	public void test2() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		b.addTokensToBoard();
		boolean expected = false;
		Tile[][] temp = b.gameBoard();
		temp[0][0].setToken(1);
		temp[0][0].pickUpToken(b.getPawn("yellow"));
		boolean actual = temp[0][0].hasToken();
		assertTrue("I expected " + expected + " but was actually " + actual, expected == actual);
	}
	
	
	@Test
	public void test3() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		b.addTokensToBoard();
		boolean expected = false;
		Tile[][] temp = b.gameBoard();
		temp[0][0].setToken(1);
		temp[0][0].pickUpToken(b.getPawn("blue"));
		boolean actual = temp[0][0].hasToken();
		assertTrue("I expected " + expected + " but was actually " + actual, expected == actual);
	}
	@Test
	public void test4() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		b.addTokensToBoard();
		boolean expected = false;
		Tile[][] temp = b.gameBoard();
		temp[0][0].setToken(1);
		temp[0][0].pickUpToken(b.getPawn("white"));
		boolean actual = temp[0][0].hasToken();
		assertTrue("I expected " + expected + " but was actually " + actual, expected == actual);
	}
	@Test
	public void test5() {
		Board b = new Board();
		b.createGameBoard();
		b.populateTestBoard();
		b.addTokensToBoard();
		boolean expected = true;
		Tile[][] temp = b.gameBoard();
		temp[0][0].setToken(1);
		boolean actual = temp[0][0].hasToken();
		assertTrue("I expected " + expected + " but was actually " + actual, expected == actual);
	}
}
