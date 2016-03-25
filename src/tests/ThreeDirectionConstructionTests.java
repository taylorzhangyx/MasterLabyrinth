package tests;

import org.junit.Assert;
import org.junit.Test;

import tile.ThreeDirectionTile;
import tile.Tile;

public class ThreeDirectionConstructionTests {
	
	@Test public void test00() {
		 Tile _t = new ThreeDirectionTile(0,1,2);
		 
		 boolean[] expected = {true,true,true,false};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test01() {
		 Tile _t = new ThreeDirectionTile(1,2,3);
		 
		 boolean[] expected = {false,true,true,true};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test02() {
		 Tile _t = new ThreeDirectionTile(0,2,3);
		 
		 boolean[] expected = {true,false,true,true};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test03() {
		 Tile _t = new ThreeDirectionTile(0,1,3);
		 
		 boolean[] expected = {true,true,false,true};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
}
