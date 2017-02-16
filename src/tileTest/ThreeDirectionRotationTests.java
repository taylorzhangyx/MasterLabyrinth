package tileTest;

import org.junit.Assert;
import org.junit.Test;

import tile.ThreeDirectionTile;

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
		boolean [] expected = {true,true,false,true} ;
		tdt.rotateCounterClockwise();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}

}
