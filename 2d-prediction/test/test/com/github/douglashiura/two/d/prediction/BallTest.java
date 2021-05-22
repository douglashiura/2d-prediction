package test.com.github.douglashiura.two.d.prediction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

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
	}

	@Test
	public void following() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		List<Point> points = new GridFactory(3).build();
		Point four = points.get(3);
		Ball ball = new Ball(Directions.ABOVE, four);
		ball.run();
		assertEquals(Directions.ABOVE, ball.getRun());
		assertNull(four.getBall());
	}
	
	@Test
	public void adjustinfDirection() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		List<Point> points = new GridFactory(3).build();
		Point four = points.get(3);
		Ball ball = new Ball(Directions.ABOVE, four);
		ball.run();
		ball.run();
		assertNotEquals(Directions.ABOVE, ball.getRun());
		assertNull(four.getBall());
	}
	

	@Test
	public void adjustinfDirectionSwap() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		List<Point> points = new GridFactory(3).build();
		Point four = points.get(3);
		Ball ball = new Ball(Directions.ABOVE, four);
		ball.run();
		ball.run();
		ball.run();
		assertNotEquals(Directions.ABOVE, ball.getRun());
		assertNull(four.getBall());
	}

}
