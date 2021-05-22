package test.com.github.douglashiura.two.d.prediction;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.douglashiura.two.d.Point;

public class PointTest {

	@Test
	public void zero() throws Exception {
		Point zero = new Point(0, 0);
		assertEquals(Integer.valueOf(0), zero.getX());
		assertEquals(Integer.valueOf(0), zero.getY());
	}

	@Test
	public void zeroOne() throws Exception {
		Point zero = new Point(0, 1);
		assertEquals(Integer.valueOf(0), zero.getX());
		assertEquals(Integer.valueOf(1), zero.getY());
	}

}
