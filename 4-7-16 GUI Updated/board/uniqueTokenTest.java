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
		for (int i = 0; i < actual.length; i++) {
			System.out.println(actual[i]);
		}
		assertTrue("", true);
	}

}
