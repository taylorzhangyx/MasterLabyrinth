package tileTest;

import org.junit.Assert;
import org.junit.Test;

import tile.Tile;
import tile.TwoDirectionTile;

public class TwoDirectionConstructionTest {
	@Test public void test00() {
		 Tile _t = new TwoDirectionTile(0);
		 
		 boolean[] expected = {true,true,false,false};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test01() {
		 Tile _t = new TwoDirectionTile(1);
		 
		 boolean[] expected = {false,true,true,false};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test02() {
		 Tile _t = new TwoDirectionTile(2);
		 
		 boolean[] expected = {false,false,true,true};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test03() {
		 Tile _t = new TwoDirectionTile(3);
		 
		 boolean[] expected = {true,false,false,true};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
}
