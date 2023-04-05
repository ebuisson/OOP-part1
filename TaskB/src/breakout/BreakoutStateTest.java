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
//	Ball[] oneBall;
//	BlockState[] oneBlock;
//	Point bottomRight;
//	PaddleState paddle;
//	BreakoutState state1;
//	BreakoutState stateWon;
//	BreakoutState stateDead;
//	BreakoutState stateBeforeBounceBlock;
//	BlockState bounceBlock;
//	Ball ball;
	Ball b1;
	Ball bm1;
	Point p55;
	Point pm55;
	Point p58;
	Point p00;
	Point p1010;
	Circle c552;
	Circle cm552;
	Vector v1010;
	PaddleState pad;
	BreakoutState state;
	Point p11;
	Point p33;
	
	Rect r1133;
		
	BlockState bl1;

//	public static final String initMap1 = """
//#		       
//		       
//		       
//		       
//		       
//		     o
//
//		     =
//
//		""";
	
	@BeforeEach
	void setUp() throws Exception {
//		state1 = GameMap.createStateFromDescription(initMap1);
//		oneBall = state1.getBalls();
//		ball = oneBall[0];
//		oneBlock = state1.getBlocks();
//		bottomRight = state1.getBottomRight();
//		paddle = state1.getPaddle();
		p55 = new Point(5,5);
		p58 = new Point(5,8);
		p00 = new Point(0,0);
		p1010 = new Point(10,10);
		pm55 = new Point(-5,5);
		v1010 = new Vector(0,0);
		c552 = new Circle(p55,2);
		//cm552 = new Circle(pm55,2);
		b1 = new Ball(c552, v1010);
		bm1 = new Ball(cm552, v1010);
		pad = new PaddleState(p58, new Color[] {Color.green});
		state = new BreakoutState(new Ball[] {b1}, new BlockState[] {bl1}, p1010, pad);
		p11 = new Point(1,1);
		p33 = new Point(3,3);
		r1133 = new Rect(p11,p33);
		bl1 = new BlockState(r1133);
	}
	
//	@Test
//	void testTossPaddleColor() {
//		assertEquals(state.getCurPaddleColor(), pad.getPossibleColors()[0]);
//	}

//	@Test
//	void testRemoveDead() {
//		assertEquals(null, state1.removeDead(bm1));
//		
//	}
	
	@Test
	void testMovePaddleRight() {
		//state.movePaddleRight(1); .plus(Constants.PADDLE_VEL.scaled(1))
		assertEquals(p58, pad.getCenter().getX());
	}
	
	@Test
	void testMovePaddleLeft() {
		//state.movePaddleRight(1); .plus(Constants.PADDLE_VEL.scaled(1))
		assertEquals(p58, pad.getCenter().getX());
	}
	

}
