package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import tile.OppositeDirectionTile;
import tile.Tile;



public class OppositeDirectionRotationTests {

    @Test public void test01() {
    	
		Tile tdt = new OppositeDirectionTile(0);
		boolean[] expected = {false,true,false,true};
		tdt.rotateClockwise();
		boolean[] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
	

	
    @Test public void test02() {
    	
    	OppositeDirectionTile tdt = new OppositeDirectionTile(0);
		boolean [] expected = {false,true,false,true} ;
		tdt.rotateCounterClockwise();
		boolean [] actual = tdt.tileOrientation();
		Assert.assertArrayEquals(expected, actual);
		
	}
    

}
