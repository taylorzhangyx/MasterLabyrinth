package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import tile.TwoDirectionTile;


public class TwoDirectionRotationTests {
	
    @Test public void test01() {
    	
		TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		boolean[] expected = {false,true,true,false};
		tdt.rotateClockwise();
		boolean[] actual = tdt.tileOrientation(); tdt.rotateClockwise();
		Assert.assertArrayEquals(expected, actual);
		
	}
	
    @Test public void test02() {
    	
		TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		boolean [] expected = {false,false,true,true} ;
		tdt.rotateClockwiseTwoTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
    @Test public void test03() {
    	
    	TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		boolean [] expected = {true,false,false,true} ;
		tdt.rotateClockwiseThreeTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
    @Test public void test04() {
    	
    	TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		boolean [] expected = {true,false,false,true} ;
		tdt.rotateCounterClockwise();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
    @Test public void test05() {
    	
    	TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		boolean [] expected = {false,false,true,true} ;
		tdt.rotateCounterClockwiseTwoTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
    @Test public void test06() {
    	
    	TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		boolean [] expected = {false,true,true,false} ;
		tdt.rotateCounterClockwiseThreeTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
}
