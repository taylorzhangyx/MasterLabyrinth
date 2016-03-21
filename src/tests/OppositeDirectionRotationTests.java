package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import tile.OppositeDirectionTile;

public class OppositeDirectionRotationTests {

	@Test public void test01(){
		
		OppositeDirectionTile odt = new OppositeDirectionTile(0,0);
		int input = ;
		int expected = ;
		int actual = odt.rotateClockwise();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
		
	}
	
	@Test public void test02(){
		
		OppositeDirectionTile odt = new OppositeDirectionTile(0,0);
		int input = ;
		int expected = ;
		int actual = odt.rotateClockwiseTwoTimes();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
		
	}
	
	@Test public void test03(){
		
		OppositeDirectionTile odt = new OppositeDirectionTile(0,0);
		int input = ;
		int expected = ;
		int actual = odt.rotateClockwiseThreeTimes();
		assertTrue("I expected the rotation of "+input+" to be "+expected+", but is was "+actual+".", expected == actual);
		
	}
	
}
