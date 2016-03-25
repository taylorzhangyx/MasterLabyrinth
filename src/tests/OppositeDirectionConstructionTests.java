package tests;

import org.junit.Assert;
import org.junit.Test;

import tile.*;

public class OppositeDirectionConstructionTests {
	@Test public void test00() {
		 Tile _t = new OppositeDirectionTile(0);
		 
		 boolean[] expected = {true,false,true,false};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test01() {
		 Tile _t = new OppositeDirectionTile(1);
		 
		 boolean[] expected = {false,true,false,true};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test02() {
		 Tile _t = new OppositeDirectionTile(2);
		 
		 boolean[] expected = {true,false,true,false};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}
	
	@Test public void test03() {
		 Tile _t = new OppositeDirectionTile(3);
		 
		 boolean[] expected = {false,true,false,true};
		 boolean[] actual = _t.tileOrientation();
		 Assert.assertArrayEquals(expected, actual);
		}

}
