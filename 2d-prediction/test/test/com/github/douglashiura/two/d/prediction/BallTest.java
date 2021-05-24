package test.com.github.douglashiura.two.d.prediction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
		Ball ball = new Ball(Directions.ABOVE, four);
		ball.run();
		assertEquals(Directions.ABOVE, ball.getRun());
		assertEquals(Color.WHITE, four.getColor());
		assertEquals(Color.BLACK, four.getBorder());
		
	}

	@Test
	public void adjustinfDirection() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		List<Point> points = new GridFactory(3).build().getPoints();
		Point four = points.get(3);
		Ball ball = new Ball(Directions.ABOVE, four);
		ball.run();
		ball.run();
		assertNotEquals(Directions.ABOVE, ball.getRun());
		assertEquals(Color.WHITE, four.getColor());
	}

	@Test
	public void adjustinfDirectionSwap() throws Exception {
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
		assertEquals(Color.WHITE, four.getColor());
	}

}
