package breakout.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.utils.Vector;
import breakout.utils.Circle;
import breakout.utils.Point;

class CircleTest {
	
	Point p11;
	Point p25;
	Point p38;
	Point pm14;
	
	Circle c252;
	Circle c389;
	
	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p25 = new Point(2,5);
		p38 = new Point(3,8);
		pm14 = new Point(-1,4);
		c252 = new Circle(p25,2);
		c389 = new Circle(p38,9);
	}

	@Test
	void testCircle() {
		assertEquals(p25,c252.getCenter());
		assertEquals(2, c252.getDiameter());
	}

	@Test
	void testGetRadius() {
		assertEquals(1,c252.getRadius());
	}

	@Test
	void testGetRightmostPoint() {
		assertEquals(new Point(3,5), c252.getRightmostPoint());
	}

	@Test
	void testGetLeftmostPoint() {
		assertEquals(new Point(1,5), c252.getLeftmostPoint());
	}

	@Test
	void testGetTopmostPoint() {
		assertEquals(new Point(2,4), c252.getTopmostPoint());
	}

	@Test
	void testGetBottommostPoint() {
		assertEquals(new Point(2,6), c252.getBottommostPoint());
	}

	@Test
	void testGetTopLeftPoint() {
		assertEquals(new Point(1,4), c252.getTopLeftPoint());
	}

	@Test
	void testGetBottomRightPoint() {
		assertEquals(new Point(3,6), c252.getBottomRightPoint());
	}

	@Test
	void testGetOutermostPoint() {
		assertEquals(new Point(3,5), c252.getOutermostPoint(Vector.RIGHT));
	}

	@Test
	void testWithCenter() {
		Circle c = c252.withCenter(p11);
		assertEquals(p11,c.getCenter());
		assertEquals(c252.getDiameter(),c.getDiameter());
	}
	
	@Test
	void testEquals() {
		assertTrue(c252.equals(c252));
		assertFalse(c252.equals(null));
		assertFalse(c252.equals(p11));
		assertFalse(c252.equals(new Circle(new Point(2,5), 4)));
		assertFalse(c252.equals(new Circle(new Point(2,6), 2)));
		assertTrue(c252.equals(new Circle(new Point(2,5), 2)));
	}
	


}
