package com.github.douglashiura.two.d;

import java.awt.Color;
import java.util.List;

public class Sensor implements Colorable {

	private List<Point> points;

	public Sensor(List<Point> points) {
		this.points = points;
		installSensor();

	}

	private void installSensor() {
		for (Point point : points) {
			point.addSensor(this);
		}
	}

	public List<Point> getPoints() {
		return points;
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}

	@Override
	public Color getBorder() {
		return Color.BLACK;
	}

}
