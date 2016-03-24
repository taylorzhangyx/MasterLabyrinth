package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import tile.OppositeDirectionTile;
import tile.Tile;



public class OppositeDirectionRotationTests {

    @Test public void test01() {
    	
		Tile tdt = new OppositeDirectionTile(0, 2);
		boolean[] expected = {false,true,false,true};
		tdt.rotateClockwise();
		boolean[] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
	
    @Test public void test02() {
    	
    	OppositeDirectionTile tdt = new OppositeDirectionTile(0, 2);
		boolean [] expected = {true,false,true,false} ;
		//tdt.rotateClockwiseTwoTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    @Test public void test03() {
    	
    	OppositeDirectionTile tdt = new OppositeDirectionTile(0, 2);
		boolean [] expected = {false,true,false,true} ;
		//tdt.rotateClockwiseThreeTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
	
    @Test public void test04() {
    	
    	OppositeDirectionTile tdt = new OppositeDirectionTile(0, 2);
		boolean [] expected = {false,true,false,true} ;
		tdt.rotateCounterClockwise();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
    @Test public void test05() {
    	
    	OppositeDirectionTile tdt = new OppositeDirectionTile(0, 2);
		boolean [] expected = {true,false,true,false} ;
		tdt.rotateCounterClockwiseTwoTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    
    @Test public void test06() {
    	
    	OppositeDirectionTile tdt = new OppositeDirectionTile(0, 2);
		boolean [] expected = {false,true,false,true} ;
		tdt.rotateCounterClockwiseThreeTimes();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
}
