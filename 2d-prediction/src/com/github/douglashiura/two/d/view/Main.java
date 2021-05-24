package com.github.douglashiura.two.d.view;

import java.io.IOException;

import com.github.douglashiura.two.d.Ball;
import com.github.douglashiura.two.d.Directions;
import com.github.douglashiura.two.d.GridFactory;

public class Main {

	public static void main(String[] args) throws IOException {
		Integer height = 15;
		FileSensorData listener = new FileSensorData();
		GridFactory grid = new GridFactory(height, listener, 3, 6, 14).build();
		listener.setSensors(grid.getSensors());
		Ball ball = new Ball(Directions.BELOW, grid.getPoints().get(0));
		new Thread() {
			@Override
			public void run() {
				while (true) {
					ball.run();
				}
			}
		}.start();
	}
}
