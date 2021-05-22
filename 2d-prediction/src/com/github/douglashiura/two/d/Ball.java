package com.github.douglashiura.two.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ball {

	private Directions run;
	private Point point;
	private List<Directions> curves;

	public Ball(Directions run, Point point) {
		this.run = run;
		this.point = point;
		this.point.setBall(this);
		adjustCurve(run);
	}

	private void adjustCurve(Directions run) {
		curves = new ArrayList<>(run.possibilities());
		curves.add(run);
		curves.add(run);
		curves.add(run);
	}

	public Directions getRun() {
		return run;
	}

	public List<Point> run() {
		Collections.shuffle(curves);
		Directions curve=curves.get(0);
		curves.clear();
		curves.add(run);
		Point newPoint = point.getNeighbor(curve);
		try {
			newPoint.hashCode();
			point.setEmpty();
			point = newPoint;
			point.setBall(this);
			return Arrays.asList(newPoint, point);
		} catch (Exception border) {
			run = newDirection();
			adjustCurve(run);
			return Collections.emptyList();
		}
	}

	private Directions newDirection() {
		List<Directions> borders = point.getBorders();
		List<Directions> oposites = new LinkedList<Directions>();
		for (Directions direction : borders) {
			oposites.addAll(direction.oposities());
		}
		Collections.shuffle(oposites);
		return oposites.get(0);
	}

}
