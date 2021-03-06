package com.github.douglashiura.two.d;

import java.awt.Color;
import java.util.List;

public class Sensor implements Colorable {

	private List<Point> points;
	private Point lastTouch;
	private Listener listener;

	public Sensor(List<Point> points, Listener listener) {
		this.points = points;
		this.listener = listener;
		lastTouch = new DefaultPoint();
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

	public void touch(Point point, Ball ball) {
		lastTouch = point;
		listener.detection();
	}

	public Point getLastTouch() {
		return lastTouch;
	}

}
