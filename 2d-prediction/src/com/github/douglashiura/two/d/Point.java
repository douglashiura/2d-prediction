package com.github.douglashiura.two.d;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Point implements Colorable {

	private Integer x;
	private Integer y;
	private Map<Directions, Point> neighbors;
	private List<Directions> borders;
	private List<Colorable> colors;

	// sun | above | kun
	// left | this | right
	// ken | below | chien

	public Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		neighbors = new HashMap<Directions, Point>(8);
		borders = new LinkedList<Directions>();
		colors = new LinkedList<Colorable>();
		colors.add(new DefaultColor());
	}

	public Point getNeighbor(Directions run) {
		return neighbors.get(run);
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public void setAbove(Point above) {
		this.neighbors.put(Directions.ABOVE, above);
	}

	public void setBelow(Point below) {
		this.neighbors.put(Directions.BELOW, below);
	}

	public void setLeft(Point left) {
		this.neighbors.put(Directions.LEFT, left);
	}

	public void setRight(Point right) {
		this.neighbors.put(Directions.RIGHT, right);
	}

	public void setSun(Point sun) {
		this.neighbors.put(Directions.SUN, sun);
	}

	public void setKun(Point kun) {
		this.neighbors.put(Directions.KUN, kun);
	}

	public void setChien(Point chien) {
		this.neighbors.put(Directions.CHIEN, chien);
	}

	public void setKen(Point ken) {
		this.neighbors.put(Directions.KEN, ken);
	}

	public Point getAbove() {
		return neighbors.get(Directions.ABOVE);
	}

	public Point getBelow() {
		return neighbors.get(Directions.BELOW);
	}

	public Point getChien() {
		return neighbors.get(Directions.CHIEN);
	}

	public Point getKen() {
		return neighbors.get(Directions.KEN);
	}

	public Point getKun() {
		return neighbors.get(Directions.KUN);
	}

	public Point getLeft() {
		return neighbors.get(Directions.LEFT);
	}

	public Point getRight() {
		return neighbors.get(Directions.RIGHT);
	}

	public Point getSun() {
		return neighbors.get(Directions.SUN);
	}

	public void addBorder(Directions border) {
		borders.add(border);
	}

	public List<Directions> getBorders() {
		return borders;
	}

	public void addBall(Ball ball) {
		colors.add(ball);
	}

	public void removeBall(Ball ball) {
		colors.remove(ball);
	}

	@Override
	public Color getColor() {
		return colors.get(colors.size() - 1).getColor();
	}

	@Override
	public Color getBorder() {
		return colors.get(colors.size() - 1).getBorder();
	}

	public void addSensor(Sensor sensor) {
		colors.add(sensor);
	}
}
