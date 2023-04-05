package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.utils.Point;
import breakout.utils.Rect;

class BlockStateTest {
	Point p11;
	Point p38;
	
	Rect r1138;
		
	BlockState b1;

	@BeforeEach
	void setUp() throws Exception {
		p11 = new Point(1,1);
		p38 = new Point(3,8);
		r1138 = new Rect(p11,p38);
		b1 = new BlockState(r1138);
	}

	@Test
	void testBlockState() {
		assertEquals(r1138,b1.getLocation());
	}

}
