package tileTest;

import org.junit.Assert;
import org.junit.Test;

import tile.TwoDirectionTile;


public class TwoDirectionRotationTests {
	
    @Test public void test01() {
    	
		TwoDirectionTile tdt = new TwoDirectionTile(0);
		boolean[] expected = {false,true,true,false};
		tdt.rotateClockwise();
		boolean[] actual = tdt.tileOrientation(); tdt.rotateClockwise();
		Assert.assertArrayEquals(expected, actual);
		
	}
	

    
    @Test public void test02() {
    	
    	TwoDirectionTile tdt = new TwoDirectionTile(0);
		boolean [] expected = {true,false,false,true} ;
		tdt.rotateCounterClockwise();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    

    
}
