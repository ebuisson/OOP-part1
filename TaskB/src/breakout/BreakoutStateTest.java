package breakout;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.utils.*;

class BreakoutStateTest {
	
	Point BR;
	BlockState ablock;
	BlockState bblock;
	BlockState[] someblocks;
	Ball aball;
	Ball bball;
	Ball cball;
	Ball dball;
	Ball[] someballs;
	PaddleState apad;
	BreakoutState state;
	BreakoutState hitState;
	
	@BeforeEach
	void setUp() throws Exception {
		BR = new Point(Constants.WIDTH, Constants.HEIGHT);
		ablock = new BlockState(
				new Rect( Constants.ORIGIN, new Point(Constants.BLOCK_WIDTH,Constants.BLOCK_HEIGHT)) );
		bblock = new BlockState(
				new Rect( new Point(10000,0), new Point(15000,3750)) );
		someblocks = new BlockState[] { ablock };
		apad = new PaddleState(
				new Point( 28000, 28000),
				Constants.TYPICAL_PADDLE_COLORS());
		aball = new Ball(
					new Circle(
						new Point(BR.getX() / 2 , Constants.HEIGHT / 2)
						, Constants.INIT_BALL_DIAMETER)
					, Constants.INIT_BALL_VELOCITY);
		bball = new Ball(
					new Circle(
						new Point(20000 , 700)
						, Constants.INIT_BALL_DIAMETER)
					, new Vector(0,-350));
		cball = new Ball(
					new Circle(
						new Point(2500 , 4500)
						, Constants.INIT_BALL_DIAMETER)
					, new Vector(0,-100));
		dball = new Ball(
					new Circle(
						new Point( 28000, 27100)
						, 100)
					, new Vector(30,30));
		someballs = new Ball[] { aball};
		state = new BreakoutState(someballs, someblocks, BR, apad);
		hitState = new BreakoutState(new Ball[] {dball}, someblocks, BR, apad);
		
	}
	
	
	@Test
	void testTossPaddleColor() {
		state.tossPaddleColor();
		assertTrue(Arrays.stream(Constants.TYPICAL_PADDLE_COLORS()).anyMatch(c -> state.getCurPaddleColor().equals(c)));
	}

	
	@Test
	void testMovePaddleLeft() {
		state.movePaddleLeft(20);
		assertEquals(state.getPaddle().getCenter(), new Point(apad.getCenter().getX()-300,apad.getCenter().getY()));
	}
	
	@Test
	void testMovePaddleRight() {
		state.movePaddleRight(20);
		assertEquals(state.getPaddle().getCenter(), new Point(apad.getCenter().getX()+300,apad.getCenter().getY()));
	}
	

}
