package com.github.douglashiura.two.d;

import java.util.ArrayList;
import java.util.List;

public class GridFactory {

	private List<Point> points;
	private Integer size;
	private List<Sensor> sensors;

	public GridFactory(Integer size, Listener listener, Integer... sensors) {
		this.size = size;
		points = new ArrayList<Point>(size * size);
		this.sensors = new ArrayList<>(sensors.length);
		Point[][] grid = new Point[size][size];
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				grid[x][y] = new Point(x, y);
				points.add(grid[x][y]);
			}
		}
		setSun(grid);
		setAbove(grid);
		setKun(grid);
		setLeft(grid);
		setRight(grid);
		setKen(grid);
		setBelow(grid);
		setChien(grid);
		setBorderAbove(grid);
		setBorderLeft(grid);
		setBorderRight(grid);
		setBorderBelow(grid);
		createSensors(grid, sensors, listener);
		removeBordersContinuationDirection(grid);
	}

	private void removeBordersContinuationDirection(Point[][] grid) {
		removeContinuationLeftAndRight(grid);
		removeUnContiuationOfTopAndFooter(grid);

	}

	private void removeUnContiuationOfTopAndFooter(Point[][] grid) {
		for (int x = 0; x < size; x++) {
			Point left = grid[x][0];
			left.removeOpositesDirection(Directions.ABOVE);
			left.removeOpositesDirection(Directions.BELOW);
			Point right = grid[x][size - 1];
			right.removeOpositesDirection(Directions.ABOVE);
			right.removeOpositesDirection(Directions.BELOW);
		}
		
	}

	private void removeContinuationLeftAndRight(Point[][] grid) {
		for (int y = 0; y < size; y++) {
			Point left = grid[0][y];
			left.removeOpositesDirection(Directions.ABOVE);
			left.removeOpositesDirection(Directions.BELOW);
			Point right = grid[size - 1][y];
			right.removeOpositesDirection(Directions.ABOVE);
			right.removeOpositesDirection(Directions.BELOW);
		}
	}

	public GridFactory(Integer size, Integer... sensors) {
		this(size, Listener.EMPTY, sensors);
	}

	private void createSensors(Point[][] grid, Integer[] sensors, Listener listener) {
		for (int i = 0; i < sensors.length - 1; i++) {
			this.sensors.add(createASensor(sensors[i], grid, Listener.EMPTY));
		}
		this.sensors.add(createASensor(sensors[sensors.length - 1], grid, listener));

	}

	private Sensor createASensor(Integer column, Point[][] grid, Listener listener) {
		List<Point> columnPoints = new ArrayList<Point>(size);
		for (int y = 0; y < size; y++) {
			columnPoints.add(grid[column][y]);
		}
		Sensor sensor = new Sensor(columnPoints, listener);
		return sensor;
	}

	private void setBorderBelow(Point[][] grid) {
		for (int x = 0; x < size; x++) {
			grid[x][size - 1].addBorder(Directions.BELOW);
		}
	}

	private void setBorderRight(Point[][] grid) {
		for (int y = 0; y < size; y++) {
			grid[size - 1][y].addBorder(Directions.RIGHT);
		}
	}

	private void setBorderLeft(Point[][] grid) {
		for (int y = 0; y < size; y++) {
			grid[0][y].addBorder(Directions.LEFT);
		}
	}

	private void setBorderAbove(Point[][] grid) {
		for (int x = 0; x < size; x++) {
			grid[x][0].addBorder(Directions.ABOVE);
		}
	}

	private void setChien(Point[][] grid) {
		for (int y = 0; y < size - 1; y++) {
			for (int x = 0; x < size - 1; x++) {
				Point chien = grid[x + 1][y + 1];
				grid[x][y].setChien(chien);
			}
		}
	}

	private void setBelow(Point[][] grid) {
		for (int y = 0; y < size - 1; y++) {
			for (int x = 0; x < size; x++) {
				Point below = grid[x][y + 1];
				grid[x][y].setBelow(below);
			}
		}
	}

	private void setKen(Point[][] grid) {
		for (int y = 0; y < size - 1; y++) {
			for (int x = 1; x < size; x++) {
				Point ken = grid[x - 1][y + 1];
				grid[x][y].setKen(ken);
			}
		}
	}

	private void setRight(Point[][] grid) {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size - 1; x++) {
				Point right = grid[x + 1][y];
				grid[x][y].setRight(right);
			}
		}
	}

	private void setLeft(Point[][] grid) {
		for (int y = 0; y < size; y++) {
			for (int x = 1; x < size; x++) {
				Point letf = grid[x - 1][y];
				grid[x][y].setLeft(letf);
			}
		}
	}

	private void setKun(Point[][] grid) {
		for (int y = 1; y < size; y++) {
			for (int x = 0; x < size - 1; x++) {
				Point kun = grid[x + 1][y - 1];
				grid[x][y].setKun(kun);
			}
		}
	}

	private void setAbove(Point[][] grid) {
		for (int y = 1; y < size; y++) {
			for (int x = 0; x < size; x++) {
				Point above = grid[x][y - 1];
				grid[x][y].setAbove(above);
			}
		}
	}

	private void setSun(Point[][] grid) {
		for (int y = 1; y < size; y++) {
			for (int x = 1; x < size; x++) {
				Point sun = grid[x - 1][y - 1];
				grid[x][y].setSun(sun);
			}
		}
	}

	public GridFactory build() {
		return this;
	}

	public List<Point> getPoints() {
		return points;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

}
