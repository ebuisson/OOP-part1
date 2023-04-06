package breakout;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import breakout.BlockState;
import breakout.BreakoutState;
import breakout.GameMap;
import breakout.PaddleState;
import breakout.utils.*;

/**
 * Those tests should fail on the provided bad implementaiton, succeed on the model solution.
 */
class TaskBTestSuite {
	

	private Point BR;
	private BlockState ablock;
	private BlockState bblock;
	private BlockState[] someblocks;
	private Ball aball;
	private Ball bball;
	private Ball cball;
	private Ball dball;
	private Ball[] someballs;
	private PaddleState apad;
	private BreakoutState state;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	/**
	 * some basic values to help us write tests
	 */
	void setUp() {
		BR = new Point(Constants.WIDTH, Constants.HEIGHT);
		
		ablock = new BlockState(
				new Rect( Constants.ORIGIN, new Point(Constants.BLOCK_WIDTH,Constants.BLOCK_HEIGHT)) );
		bblock = new BlockState(
				new Rect( new Point(10000,0), new Point(Constants.BLOCK_WIDTH+1000,Constants.BLOCK_HEIGHT)) );
		someblocks = new BlockState[] { ablock };
		
		apad = new PaddleState(
				new Point( Constants.WIDTH / 2, (3 * Constants.HEIGHT) / 4),
				Constants.TYPICAL_PADDLE_COLORS());
		
		aball =
				new Ball(
					new Circle(
						new Point(BR.getX() / 2 , Constants.HEIGHT / 2)
						, Constants.INIT_BALL_DIAMETER)
					, Constants.INIT_BALL_VELOCITY);
		bball = new Ball(
					new Circle(
						new Point(6000 , 700)
						, Constants.INIT_BALL_DIAMETER)
					, new Vector(0,-350));
		cball = new Ball(
				new Circle(
					new Point(2500 , 4500)
					, Constants.INIT_BALL_DIAMETER)
				, new Vector(0,-100));
		dball = new Ball(
				new Circle(
						new Point( Constants.WIDTH / 2, 21000)
						, Constants.INIT_BALL_DIAMETER)
					, new Vector(0,100));
		someballs = new Ball[] { aball, bball, cball, dball };
		state = new BreakoutState(someballs, someblocks, BR, apad);
		
	}

//	@Test
//	void exampleTest1() {
//		assertThrows( IllegalArgumentException.class,
//				() -> insertcodehere );
//      assertTrue ( 1 == 1 );
//      assertEquals( expected, actual );
//      assertNotEquals( unexpected, actual );
//      assertNotSame( unexpected, actual );
//      abreakoutState.tickDuring( 200 );
//	}

	
	@Test
	void testMove() {
		assertFalse(aball.move(null) == ;
	}
	
	@Test
	void testGetBlocks() {
		assertNotSame(someblocks, state.getBlocks());
	}
	
	@Test
	void testPaddleColor() {
		state.tossPaddleColor();
		assertTrue(Arrays.stream(Constants.TYPICAL_PADDLE_COLORS()).anyMatch(c -> state.getCurPaddleColor().equals(c)));
		assertFalse(state.getCurPaddleColor() == Color.pink);
	}
	
	@Test
	void testTossPaddleColor() {
		state.tossPaddleColor();
		Color old = state.getCurPaddleColor();
		state.tossPaddleColor();
		assertNotSame(old, state.getCurPaddleColor());
	}
	
	@Test
	void testBounceWalls() {
		Vector oldVelocity = bball.getVelocity();
		Circle oldLocation = bball.getLocation();
		state.tickDuring(1);
		assertEquals(oldLocation.getCenter().plus(oldVelocity),bball.getLocation().getCenter());
		
	}
	
	@Test
	void testCollideBallBlocks() {
		Point oldLocation = apad.getCenter();
		state.tickDuring(10);
		assertEquals(oldLocation, state.getPaddle().getCenter());
	}
	
	@Test //not needed?
	void testCollideBallPaddle() {
		Color old = state.getCurPaddleColor();
		state.tickDuring(10);
		assertNotSame(old, state.getCurPaddleColor());
	}
	
	
	
	@Test
	void dummyTest() {
		assertEquals( 35, aball.dummy() );
	}
	


	
}

