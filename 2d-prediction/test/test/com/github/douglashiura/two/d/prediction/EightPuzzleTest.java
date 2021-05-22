package test.com.github.douglashiura.two.d.prediction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.github.douglashiura.two.d.Directions;
import com.github.douglashiura.two.d.GridFactory;
import com.github.douglashiura.two.d.Point;

public class EightPuzzleTest {
	@Test
	public void eightPuzzle() throws Exception {
//		012
//		345
//		678
		Point zero = new Point(0, 0);
		Point one = new Point(1, 0);
		Point two = new Point(2, 0);
		Point three = new Point(0, 1);
		Point four = new Point(1, 1);
		Point five = new Point(2, 1);
		Point six = new Point(0, 0);
		Point seven = new Point(1, 1);
		Point eight = new Point(2, 2);

		four.setAbove(one);
		four.setBelow(seven);
		four.setLeft(three);
		four.setRight(five);
		four.setSun(zero);
		four.setKun(two);
		four.setChien(eight);
		four.setKen(six);

		assertEquals(zero, four.getSun());
		assertEquals(one, four.getAbove());
		assertEquals(two, four.getKun());
		assertEquals(three, four.getLeft());
		assertEquals(five, four.getRight());
		assertEquals(six, four.getKen());
		assertEquals(seven, four.getBelow());
		assertEquals(eight, four.getChien());

	}

	@Test
	public void factory() throws Exception {
		List<Point> points = new GridFactory(1).build();
		Point zero = points.get(0);
		assertEquals(1, points.size());
		assertNull(zero.getSun());
		assertNull(zero.getAbove());
		assertNull(zero.getKun());
		assertNull(zero.getLeft());
		assertNull(zero.getRight());
		assertNull(zero.getKen());
		assertNull(zero.getBelow());
		assertNull(zero.getChien());
		assertEquals(Integer.valueOf(0), zero.getX());
		assertEquals(Integer.valueOf(0), zero.getY());
	}

	@Test
	public void four() throws Exception {
		List<Point> points = new GridFactory(3).build();
		Point zero = points.get(0);
		Point one = points.get(1);
		Point two = points.get(2);
		Point three = points.get(3);
		Point four = points.get(4);
		Point five = points.get(5);
		Point six = points.get(6);
		Point seven = points.get(7);
		Point eight = points.get(8);
		assertEquals(zero, four.getSun());
		assertEquals(one, four.getAbove());
		assertEquals(two, four.getKun());
		assertEquals(three, four.getLeft());
		assertEquals(five, four.getRight());
		assertEquals(six, four.getKen());
		assertEquals(seven, four.getBelow());
		assertEquals(eight, four.getChien());
		assertEquals(Integer.valueOf(1), four.getX());
		assertEquals(Integer.valueOf(1), four.getY());

		assertEquals(2, zero.getBorders().size());
		assertEquals(Directions.ABOVE, zero.getBorders().get(0));
		assertEquals(Directions.LEFT, zero.getBorders().get(1));
	
		assertEquals(1, one.getBorders().size());
		assertEquals(Directions.ABOVE, one.getBorders().get(0));
	
		assertEquals(2, two.getBorders().size());
		assertEquals(Directions.ABOVE, two.getBorders().get(0));
		assertEquals(Directions.RIGHT, two.getBorders().get(1));
		
		
		assertEquals(1, three.getBorders().size());
		assertEquals(Directions.LEFT, three.getBorders().get(0));
	
		assertEquals(0, four.getBorders().size());
	
		assertEquals(1, five.getBorders().size());
		assertEquals(Directions.RIGHT, five.getBorders().get(0));
		
		assertEquals(2, six.getBorders().size());
		assertEquals(Directions.LEFT, six.getBorders().get(0));
		assertEquals(Directions.BELOW, six.getBorders().get(1));
	
		assertEquals(1, one.getBorders().size());
		assertEquals(Directions.BELOW, seven.getBorders().get(0));
	
		assertEquals(2, eight.getBorders().size());
		assertEquals(Directions.RIGHT, eight.getBorders().get(0));
		assertEquals(Directions.BELOW, eight.getBorders().get(1));
			
		
		
		
	
	
	
	}

}
