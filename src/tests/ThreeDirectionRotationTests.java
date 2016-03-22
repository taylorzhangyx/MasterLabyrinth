package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import tile.ThreeDirectionTile;
import tile.TwoDirectionTile;

public class ThreeDirectionRotationTests {
	
    @Test public void test01() {
    	
    	ThreeDirectionTile tdt = new ThreeDirectionTile(0, 1, 2);
		boolean[] expected = {false,true,true,true};
		tdt.rotateClockwise();
		boolean[] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
	
    @Test public void test02() {
    	
    	ThreeDirectionTile tdt = new ThreeDirectionTile(0, 1, 2);
		boolean [] expected = {true,false,true,true} ;
		tdt.rotateClockwiseTwoTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    @Test public void test03() {
    	
    	ThreeDirectionTile tdt = new ThreeDirectionTile(0, 1, 2);
		boolean [] expected = {true,true,false,true} ;
		tdt.rotateClockwiseThreeTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
    @Test public void test04() {
    	
    	ThreeDirectionTile tdt = new ThreeDirectionTile(0, 1, 2);
		boolean [] expected = {true,true,false,true} ;
		tdt.rotateCounterClockwise();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}

    
    @Test public void test05() {
    	
    	ThreeDirectionTile tdt = new ThreeDirectionTile(0, 1, 2);
		boolean [] expected = {true,false,true,true} ;
		tdt.rotateCounterClockwiseTwoTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
}
