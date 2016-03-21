package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import tile.TwoDirectionTile;


public class TwoDirectionRotationTests {
	
    @Test public void test01() {
    	
		TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		int input = ;
		int expected = ;
		int actual = tdt.rotateClockwise();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
		
	}
	
    @Test public void test02() {
    	
		TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		int input = ;
		int expected = ;
		int actual = tdt.rotateClockwiseTwoTimes();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
		
	}
    @Test public void test03() {
    	
		TwoDirectionTile tdt = new TwoDirectionTile(0, 1);
		int input = ;
		int expected = ;
		int actual = tdt.rotateClockwiseThreeTimes();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
		
	}
    
}
