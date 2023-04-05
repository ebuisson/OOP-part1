package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.utils.*;

class BallTest {

	//Point p11;
	Point p05;
	Point p38;
	//Point pm14;
	
	//Rect r1138;
	//Rect rm1438;
	
	Vector v1010;
	Vector v2020;
	
	Circle c052;
	Circle c389;
	Ball b1;
	
	@BeforeEach
	void setUp() throws Exception {
		//p11 = new Point(1,1);
		p05 = new Point(0,5);
		p38 = new Point(3,8);
		//pm14 = new Point(-1,4);
		//r1138 = new Rect(p11,p38);
		//rm1438 = new Rect(pm14,p38);
		c052 = new Circle(p05,2);
		c389 = new Circle(p38,9);
		v1010 = new Vector(10,10);
		v2020 = new Vector (20,20);
		b1 = new Ball(c052, v1010);
	}

	@Test
	void testBall() {
		b1.setLocation(c389);
		assertEquals(c389, b1.getLocation());
		b1.setVelocity(v2020);
		assertEquals(v2020, b1.getVelocity());
	}

	@Test
	void testMove() {
		b1.move(v1010);
		assertEquals(b1.getLocation(), new Circle(new Point (10,15),b1.getLocation().getDiameter()));
	}


}
