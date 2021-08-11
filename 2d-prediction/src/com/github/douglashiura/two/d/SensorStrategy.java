package com.github.douglashiura.two.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface SensorStrategy {
	final static SensorStrategy NONE = new SensorStrategy() {

		@Override
		public List<Sensor> createSensors(Point[][] grid, Listener listener) {
			return Collections.emptyList();
		}
	};

	List<Sensor> createSensors(Point[][] grid, Listener listener);

	class ManySensors implements SensorStrategy {

		private Integer[] sensors;
		private Integer size;

		public ManySensors(Integer size, Integer... sensors) {
			this.size = size;
			this.sensors = sensors;
		}

		@Override
		public List<Sensor> createSensors(Point[][] grid, Listener listener) {
			List<Sensor> sensors = new ArrayList<>(this.sensors.length);
			for (int i = 0; i < this.sensors.length - 1; i++) {
				sensors.add(createASensor(this.sensors[i], grid, Listener.EMPTY));
			}
			sensors.add(createASensor(this.sensors[this.sensors.length - 1], grid, listener));
			return sensors;
		}

		private Sensor createASensor(Integer column, Point[][] grid, Listener listener) {
			List<Point> columnPoints = new ArrayList<Point>(size);
			for (int y = 0; y < size; y++) {
				columnPoints.add(grid[column][y]);
			}
			Sensor sensor = new Sensor(columnPoints, listener);
			return sensor;
		}
	}

}
