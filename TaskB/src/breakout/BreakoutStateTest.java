package breakout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.utils.Point;

class BreakoutStateTest {
	Ball[] oneBall;
	BlockState[] oneBlock;
	Point bottomRight;
	PaddleState paddle;
	BreakoutState state1;
	BreakoutState stateWon;
	BreakoutState stateDead;
	BreakoutState stateBeforeBounceBlock;
	BlockState bounceBlock;
	Ball ball;

	public static final String initMap1 = """
#		       
		       
		       
		       
		       
		     o

		     =

		""";
	
	@BeforeEach
	void setUp() throws Exception {
		state1 = GameMap.createStateFromDescription(initMap1);
		oneBall = state1.getBalls();
		ball = oneBall[0];
		oneBlock = state1.getBlocks();
		bottomRight = state1.getBottomRight();
		paddle = state1.getPaddle();
	}
	
	@Test
	void testTossPaddleColor() {
		fail("Not yet implemented");
	}

}
