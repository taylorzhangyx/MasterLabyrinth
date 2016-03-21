package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import tile.ThreeDirectionTile;

public class ThreeDirectionRotationTests {
	
	@Test public void test01(){
		
		ThreeDirectionTile tdt = new ThreeDirectionTile(0,0,1);
		int input = ;
		int expected = ;
		int actual = tdt.rotateClockwise();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
	}
	
	@Test public void test02(){
		
		ThreeDirectionTile tdt = new ThreeDirectionTile(0,0,1);
		int input = ;
		int expected = ;
		int actual = tdt.rotateClockwiseTwoTimes();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
	}
	
	@Test public void test03(){
		
		ThreeDirectionTile tdt = new ThreeDirectionTile(0,0,1);
		int input = ;
		int expected = ;
		int actual = tdt.rotateClockwiseThreeTimes();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
	}

}
