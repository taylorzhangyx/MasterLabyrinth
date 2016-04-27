package tests.token;

import static org.junit.Assert.*;

import org.junit.Test;

import code.model.AbstractTile;
import code.model.FixedTile;
import code.model.Token;

public class SetTileTests {

	@Test
	public void test01() {
		Token token = new Token(5, "Four-leaf Clover");
		AbstractTile tile = new FixedTile();
		token.setTile(tile);
		AbstractTile expected = tile;
		AbstractTile actual = token.getTile();
		assertTrue("", expected == actual);
		
	}

	@Test
	public void test02() {
		Token token = new Token(5, "Four-leaf Clover");
		token.setTile(null);
		AbstractTile expected = null;
		AbstractTile actual = token.getTile();
		assertTrue("", expected == actual);
		
	}
}
