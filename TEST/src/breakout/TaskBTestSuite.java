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
	private PaddleState bpad;
	private BreakoutState state;
	private BreakoutState hitpaddle;
	private BreakoutState hitwall;
	private BreakoutState hitblock;
	
	private Rect topWall;
	private Rect rightWall;
	private Rect leftWall;
	private Rect[] walls;

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
		bpad = new PaddleState(new Point(28000,28000),new Color[] {Color.pink});
		aball = new Ball(
					new Circle(
						new Point(BR.getX() / 2 , Constants.HEIGHT / 2)
						, Constants.INIT_BALL_DIAMETER)
					, Constants.INIT_BALL_VELOCITY);
		bball = new Ball(
					new Circle(
						new Point(40000 , 3000)
						, 100)
					, new Vector(30,-30));
		cball = new Ball(
					new Circle(
						new Point(2500 , 4500)
						, Constants.INIT_BALL_DIAMETER)
					, new Vector(0,-100));
		dball = new Ball(
					new Circle(
						new Point( 28000, 27100)
						, Constants.INIT_BALL_DIAMETER)
					, new Vector(30,30));
		someballs = new Ball[] { aball};
		state = new BreakoutState(someballs, someblocks, BR, apad);
		hitpaddle = new BreakoutState(new Ball[] { dball}, someblocks, BR, bpad);
		hitwall = new BreakoutState(new Ball[] { bball}, someblocks, BR, bpad);
		hitblock = new BreakoutState(new Ball[] { cball}, new BlockState[] { ablock, bblock }, BR, bpad);
		
		topWall = new Rect( new Point(0,-1000), new Point(BR.getX(),0));
		rightWall = new Rect( new Point(BR.getX(),0), new Point(BR.getX()+1000,BR.getY()));
		leftWall = new Rect( new Point(-1000,0), new Point(0,BR.getY()));
		walls = new Rect[] {topWall,rightWall, leftWall };
		
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
	void testMovePaddleLeft() {
		state.movePaddleLeft(20);
		assertEquals(state.getPaddle().getCenter(), new Point(apad.getCenter().getX()-300,apad.getCenter().getY()));
	}
	
	@Test
	void testCollideBallBlocks() {
		Point oldLocation = bpad.getCenter();
		hitblock.tickDuring(10);
		assertEquals(oldLocation, state.getPaddle().getCenter());
	}
	
	
	
	@Test
	void dummyTest() {
		assertEquals( 35, aball.dummy() );
	}
	


	
}

