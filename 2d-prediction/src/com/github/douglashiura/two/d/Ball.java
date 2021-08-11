package com.github.douglashiura.two.d;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ball implements Colorable {

	private Directions run;
	private Point point;
	private List<Directions> curves;

	public Ball(Directions run, Point point) {
		this.run = run;
		this.point = point;
		this.point.addBall(this);
		adjustCurve(run, point);
	}

	private void adjustCurve(Directions run, Point point) {
		curves = new ArrayList<>(run.possibilities());
		curves.add(run);
		curves.add(run);
		curves.add(run);
		curves.removeAll(point.getUnMoves());
	}

	public Directions getRun() {
		return run;
	}

	public List<Point> run() {
		Collections.shuffle(curves);
		Directions curve = curves.get(0);
		curves.clear();
		curves.add(run);
		Point newPoint = point.getNeighbor(curve);
		try {
			newPoint.hashCode();
			point.removeBall(this);
			newPoint.addBall(this);
			Point oldPoint = point;
			point = newPoint;
			return Arrays.asList( oldPoint, newPoint);
		} catch (Exception border) {
			run = newDirection();
			adjustCurve(run, point);
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

	@Override
	public Color getColor() {
		return Color.YELLOW;
	}

	@Override
	public Color getBorder() {
		return Color.YELLOW;
	}
}
