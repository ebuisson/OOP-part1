package breakout.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.utils.Vector;

class VectorTest {
	Vector v34;
	Vector vm18;
	
	@BeforeEach
	void setUp() throws Exception {
		v34 = new Vector(3,4);
		vm18 = new Vector(-1,8);
	}

	@Test
	void testVector() {
		assertEquals(3, v34.getX());
		assertEquals(4, v34.getY());
	}
	
	@Test
	void testHashCode() {
		assertEquals(1058,v34.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(v34.equals(v34));
		assertFalse(v34.equals(null));
		assertFalse(v34.equals(new Point(1,1)));
		assertFalse(v34.equals(new Vector(2,4)));
		assertFalse(v34.equals(new Vector(3,5)));
	}

	@Test
	void testScaled() {
		assertEquals(new Vector(-6,-8), v34.scaled(-2));
	}

	@Test
	void testPlus() {
		assertEquals(new Vector(2,12), v34.plus(vm18));
	}

	@Test
	void testMinus() {
		assertEquals(new Vector(4,-4), v34.minus(vm18));
	}

	@Test
	void testToString() {
		assertEquals("(-1,8)",vm18.toString());
	}

	@Test
	void testProduct() {
		assertEquals(29,v34.product(vm18));
	}

	@Test
	void testGetSquareLength() {
		assertEquals(25, v34.getSquareLength());
	}

	@Test
	void testMirrorOver() {
		assertEquals(new Vector(3,-4),v34.mirrorOver(Vector.DOWN));
	}
	@Test
	void testScaledDiv() {
		assertEquals(new Vector(-1,-2), v34.scaledDiv(-2));
	}

}
