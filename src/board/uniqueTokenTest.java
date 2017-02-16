package board;

import static org.junit.Assert.*;

import org.junit.Test;

public class uniqueTokenTest {

	@Test
	/*
	 *Tests the uniqueTokenMethod.
	 *
	 * This will ALWAYS return true, therefore check the values that are printed to verify
	 */
	public void test() {
		Board test = new Board();
		int[] actual = test.uniqueTokens();
		boolean[] table = new boolean[26];
		for (int i = 0; i < actual.length; i++) {
			if(table[actual[i]]){
				assertTrue("Has duplicate num", false);
			}
			else table[actual[i]] = true;
			
		}
		assertTrue("all unique", true);
	}

}
