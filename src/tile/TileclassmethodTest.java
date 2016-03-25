package tile;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TileclassmethodTest {

	@Test
	public void hasPawnMethodTest() {
		Tile t = new OppositeDirectionTile(0);
		boolean expected = false;
		boolean actual = t.hasPawn();
		assertTrue("i expected " + expected + " but was actually " + actual, expected == actual);
	}

	@Test
	public void hasPawnMethodTest2() {
		Tile t = new TwoDirectionTile(0, 1);
		t.setPawns("red");
		boolean expected = true;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}

	@Test
	public void hasPawnMethodTest3() {
		Tile t = new ThreeDirectionTile(0, 1, 2);
		t.setPawns("red");
		boolean expected = true;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);

	}

	@Test
	public void erasePawnMethodTest() {
		Tile t = new OppositeDirectionTile(0);
		t.setPawns("red");
		t.erasePawn("red");
		boolean expected = false;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);

	}

	@Test
	public void erasePawnMethodTest2() {
		Tile t = new TwoDirectionTile(0, 1);
		t.setPawns("red");
		t.erasePawn("red");
		boolean expected = false;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}

	@Test
	public void erasePawnMethodTest3() {
		Tile t = new TwoDirectionTile(0, 1);
		t.setPawns("red");
		t.erasePawn("red");
		boolean expected = false;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}

	@Test
	public void setPawnMethodTest() {
		Tile t = new OppositeDirectionTile(0);
		t.setPawns("red");
		boolean expected = true;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}

	@Test
	public void setPawnMethodTest2() {
		Tile t = new TwoDirectionTile(0, 1);
		t.setPawns("red");
		boolean expected = true;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}

	@Test
	public void setPawnMethodTest3() {
		Tile t = new ThreeDirectionTile(0, 1, 2);
		t.setPawns("red");
		boolean expected = true;
		boolean actual = t.hasPawn();
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}

	@Test
	public void tileorientationMethodTest() {
		boolean actual = false;
		Tile t = new ThreeDirectionTile(0, 1, 2);
		boolean[] oreintation = new boolean[4];
		boolean n = true;
		oreintation[0] = n;
		boolean e = true;
		oreintation[1] = e;
		boolean s = true;
		oreintation[2] = s;
		boolean w = false;
		oreintation[3] = w;
		boolean[] actrualrientation = t.tileOrientation();

		if (oreintation[0] == actrualrientation[0]) {
			if (oreintation[1] == actrualrientation[1]) {
				if (oreintation[2] == actrualrientation[2]) {
					if (oreintation[3] == actrualrientation[3]) {
						actual = true;
					}
				}
			}
		}

		boolean expected = true;

		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}

	@Test
	public void tileorientationMethodTest2() {
		boolean actual = false;
		Tile t = new OppositeDirectionTile(0);
		boolean[] oreintation = new boolean[4];
		boolean n = true;
		oreintation[0] = n;
		boolean e = false;
		oreintation[1] = e;
		boolean s = true;
		oreintation[2] = s;
		boolean w = false;
		oreintation[3] = w;
		boolean[] actrualrientation = t.tileOrientation();

		if (oreintation[0] == actrualrientation[0]) {
			if (oreintation[1] == actrualrientation[1]) {
				if (oreintation[2] == actrualrientation[2]) {
					if (oreintation[3] == actrualrientation[3]) {
						actual = true;
					}
				}

			}
		}
		boolean expected = true;
		
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}
	@Test
	public void tileOrientationMethodTest3() {
		boolean actual = false;
		Tile t = new TwoDirectionTile(1,2);
		boolean[] oreintation = new boolean[4];
		boolean n = false;
		oreintation[0] = n;
		boolean e = true;
		oreintation[1] = e;
		boolean s = true;
		oreintation[2] = s;
		boolean w = false;
		oreintation[3] = w;
		boolean[] actrualrientation = t.tileOrientation();

		if (oreintation[0] == actrualrientation[0]) {
			if (oreintation[1] == actrualrientation[1]) {
				if (oreintation[2] == actrualrientation[2]) {
					if (oreintation[3] == actrualrientation[3]) {
						actual = true;
					}
				}

			}
		}
		boolean expected = true;
		
		assertTrue(" i expected " + expected + "but actually got " + actual, expected == actual);
	}
}
