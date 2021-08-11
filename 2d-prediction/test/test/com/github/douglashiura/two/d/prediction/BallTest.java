package test.com.github.douglashiura.two.d.prediction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.List;

import org.junit.Test;

import com.github.douglashiura.two.d.Ball;
import com.github.douglashiura.two.d.Directions;
import com.github.douglashiura.two.d.GridFactory;
import com.github.douglashiura.two.d.Point;

public class BallTest {

	@Test
	public void ball() throws Exception {
		Point zero = new Point(0, 0);
		Ball ball = new Ball(Directions.ABOVE, zero);
		assertEquals(Directions.ABOVE, ball.getRun());
		assertEquals(Color.YELLOW, zero.getColor());
		assertEquals(Color.YELLOW, zero.getBorder());
	}

	@Test
	public void following() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		List<Point> points = new GridFactory(3).build().getPoints();
		Point four = points.get(3);
		Ball ball = new Ball(Directions.RIGHT, four);
		ball.run();
		List<Point> touched = ball.run();
		assertTrue(Directions.RIGHT.possibilities().contains(ball.getRun()));
		assertEquals(2, touched.size());
		assertEquals(Color.WHITE, touched.get(0).getColor());
		assertEquals(Color.YELLOW, touched.get(1).getColor());
	}

	@Test
	public void adjustinfDirection() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		List<Point> points = new GridFactory(3).build().getPoints();
		Point four = points.get(3);
		Ball ball = new Ball(Directions.RIGHT, four);
		ball.run();
		assertTrue(Directions.RIGHT.possibilities().contains(ball.getRun()));
		assertEquals(Color.WHITE, four.getColor());
	}

	@Test
	public void adjustingDirectionSwap() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		List<Point> points = new GridFactory(3).build().getPoints();
		Point four = points.get(3);
		Ball ball = new Ball(Directions.ABOVE, four);
		ball.run();
		ball.run();
		ball.run();
		assertNotEquals(Directions.ABOVE, ball.getRun());
	}

}
