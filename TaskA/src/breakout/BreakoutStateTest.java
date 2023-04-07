package breakout;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import breakout.utils.Circle;
import breakout.utils.Point;
import breakout.utils.Rect;
import breakout.utils.Vector;

class BreakoutStateTest {
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
	
	@BeforeEach
	void setUp() throws Exception {
		BR = new Point(Constants.WIDTH, Constants.HEIGHT);
		ablock = new BlockState(
				new Rect( Constants.ORIGIN, new Point(Constants.BLOCK_WIDTH,Constants.BLOCK_HEIGHT)) );
		bblock = new BlockState(
				new Rect( new Point(10000,0), new Point(15000,3750)) );
		someblocks = new BlockState[] { ablock };
		apad = new PaddleState(
				new Point( Constants.WIDTH / 2, (3 * Constants.HEIGHT) / 4),
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
						new Point( 25000, 21000)
						, Constants.INIT_BALL_DIAMETER)
					, new Vector(0,100));
		someballs = new Ball[] { aball, bball, cball, dball };
		state = new BreakoutState(someballs, someblocks, BR, apad);
		
	}
	
	@Test
	void testTossPaddleColor() {
		state.tossPaddleColor();
		assertEquals(Color.pink, state.getCurPaddleColor());
	}

	
	@Test
	void testMovePaddleLeft() {
		state.movePaddleLeft(20);
		assertEquals(state.getPaddle().getCenter(), new Point(24850,apad.getCenter().getY()));
	}
	
	@Test
	void testMovePaddleRight() {
		state.movePaddleRight(20);
		assertEquals(state.getPaddle().getCenter(), new Point(apad.getCenter().getX()+300,apad.getCenter().getY()));
	}
	

}
