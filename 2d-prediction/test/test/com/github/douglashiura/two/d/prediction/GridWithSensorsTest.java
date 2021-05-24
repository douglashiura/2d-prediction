package test.com.github.douglashiura.two.d.prediction;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.List;

import org.junit.Test;

import com.github.douglashiura.two.d.GridFactory;
import com.github.douglashiura.two.d.Point;
import com.github.douglashiura.two.d.Sensor;

public class GridWithSensorsTest {

	@Test
	public void four() throws Exception {
		Integer[] sensorsColumns = { 0, 2 };
		GridFactory build = new GridFactory(3, sensorsColumns).build();
		List<Point> points = build.getPoints();
		List<Sensor> sensors = build.getSensors();
		Point zero = points.get(0);
		Point one = points.get(1);
		Point two = points.get(2);
		Point three = points.get(3);
		Point four = points.get(4);
		Point five = points.get(5);
		Point six = points.get(6);
		Point seven = points.get(7);
		Point eight = points.get(8);
		assertEquals(2, sensors.size());
		assertEquals(3, sensors.get(0).getPoints().size());
		assertEquals(zero, sensors.get(0).getPoints().get(0));
		assertEquals(three, sensors.get(0).getPoints().get(1));
		assertEquals(six, sensors.get(0).getPoints().get(2));
		assertEquals(3, sensors.get(1).getPoints().size());
		assertEquals(two, sensors.get(1).getPoints().get(0));
		assertEquals(five, sensors.get(1).getPoints().get(1));
		assertEquals(eight, sensors.get(1).getPoints().get(2));
		assertEquals(Color.WHITE, one.getColor());
		assertEquals(Color.WHITE, one.getColor());
		assertEquals(Color.WHITE, four.getColor());
		assertEquals(Color.WHITE, seven.getColor());
		assertEquals(Color.BLUE, zero.getColor());
		assertEquals(Color.BLUE, two.getColor());
		assertEquals(Color.BLUE, three.getColor());
		assertEquals(Color.BLUE, five.getColor());
		assertEquals(Color.BLUE, six.getColor());
		assertEquals(Color.BLUE, eight.getColor());
	}

}
