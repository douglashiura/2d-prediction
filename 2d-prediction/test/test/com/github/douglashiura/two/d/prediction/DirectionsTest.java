package test.com.github.douglashiura.two.d.prediction;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.douglashiura.two.d.Directions;

public class DirectionsTest {

	@Test
	public void flowPossibilities() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		assertEquals(3, Directions.LEFT.possibilities().size());
		assertEquals(3, Directions.RIGHT.possibilities().size());
		assertEquals(3, Directions.ABOVE.possibilities().size());
		assertEquals(3, Directions.BELOW.possibilities().size());
		assertEquals(3, Directions.KUN.possibilities().size());
		assertEquals(3, Directions.CHIEN.possibilities().size());
		assertEquals(3, Directions.KEN.possibilities().size());
		assertEquals(3, Directions.SUN.possibilities().size());

		assertEquals(Directions.KUN, Directions.RIGHT.possibilities().get(0));
		assertEquals(Directions.RIGHT, Directions.RIGHT.possibilities().get(1));
		assertEquals(Directions.CHIEN, Directions.RIGHT.possibilities().get(2));

		assertEquals(Directions.SUN, Directions.LEFT.possibilities().get(0));
		assertEquals(Directions.LEFT, Directions.LEFT.possibilities().get(1));
		assertEquals(Directions.KEN, Directions.LEFT.possibilities().get(2));

		assertEquals(Directions.CHIEN, Directions.BELOW.possibilities().get(0));
		assertEquals(Directions.BELOW, Directions.BELOW.possibilities().get(1));
		assertEquals(Directions.KEN, Directions.BELOW.possibilities().get(2));

		assertEquals(Directions.SUN, Directions.ABOVE.possibilities().get(0));
		assertEquals(Directions.ABOVE, Directions.ABOVE.possibilities().get(1));
		assertEquals(Directions.KUN, Directions.ABOVE.possibilities().get(2));

		assertEquals(Directions.ABOVE, Directions.KUN.possibilities().get(0));
		assertEquals(Directions.KUN, Directions.KUN.possibilities().get(1));
		assertEquals(Directions.RIGHT, Directions.KUN.possibilities().get(2));

		assertEquals(Directions.LEFT, Directions.KEN.possibilities().get(0));
		assertEquals(Directions.KEN, Directions.KEN.possibilities().get(1));
		assertEquals(Directions.BELOW, Directions.KEN.possibilities().get(2));

		assertEquals(Directions.ABOVE, Directions.SUN.possibilities().get(0));
		assertEquals(Directions.SUN, Directions.SUN.possibilities().get(1));
		assertEquals(Directions.LEFT, Directions.SUN.possibilities().get(2));

		assertEquals(Directions.RIGHT, Directions.CHIEN.possibilities().get(0));
		assertEquals(Directions.CHIEN, Directions.CHIEN.possibilities().get(1));
		assertEquals(Directions.BELOW, Directions.CHIEN.possibilities().get(2));

	}

	@Test
	public void directions() throws Exception {
		assertEquals(8, Directions.values().length);
		assertEquals(Directions.SUN, Directions.values()[0]);
		assertEquals(Directions.ABOVE, Directions.values()[1]);
		assertEquals(Directions.KUN, Directions.values()[2]);
		assertEquals(Directions.RIGHT, Directions.values()[3]);
		assertEquals(Directions.CHIEN, Directions.values()[4]);
		assertEquals(Directions.BELOW, Directions.values()[5]);
		assertEquals(Directions.KEN, Directions.values()[6]);
		assertEquals(Directions.LEFT, Directions.values()[7]);
	}

	@Test
	public void repels() throws Exception {
		// sun | above | kun
		// left | this | right
		// ken | below | chien
		assertEquals(3, Directions.LEFT.oposities().size());
		assertEquals(3, Directions.RIGHT.oposities().size());
		assertEquals(3, Directions.ABOVE.oposities().size());
		assertEquals(3, Directions.BELOW.oposities().size());

		assertEquals(Directions.KUN, Directions.LEFT.oposities().get(0));
		assertEquals(Directions.RIGHT, Directions.LEFT.oposities().get(1));
		assertEquals(Directions.CHIEN, Directions.LEFT.oposities().get(2));

		assertEquals(Directions.SUN, Directions.RIGHT.oposities().get(0));
		assertEquals(Directions.LEFT, Directions.RIGHT.oposities().get(1));
		assertEquals(Directions.KEN, Directions.RIGHT.oposities().get(2));

		assertEquals(Directions.CHIEN, Directions.ABOVE.oposities().get(0));
		assertEquals(Directions.BELOW, Directions.ABOVE.oposities().get(1));
		assertEquals(Directions.KEN, Directions.ABOVE.oposities().get(2));

		assertEquals(Directions.SUN, Directions.BELOW.oposities().get(0));
		assertEquals(Directions.ABOVE, Directions.BELOW.oposities().get(1));
		assertEquals(Directions.KUN, Directions.BELOW.oposities().get(2));

	}

	@Test(expected = RuntimeException.class)
	public void opositeSun() throws Exception {
		Directions.SUN.oposities();
	}

	@Test(expected = RuntimeException.class)
	public void opositeKun() throws Exception {
		Directions.KUN.oposities();
	}

	@Test(expected = RuntimeException.class)
	public void opositeChien() throws Exception {
		Directions.CHIEN.oposities();
	}

	@Test(expected = RuntimeException.class)
	public void opositeKen() throws Exception {
		Directions.KEN.oposities();
	}

}
