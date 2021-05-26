package com.github.douglashiura.two.d.view;

import java.io.IOException;

import com.github.douglashiura.two.d.Ball;
import com.github.douglashiura.two.d.Directions;
import com.github.douglashiura.two.d.GridFactory;

public class Main {

	public static void main(String[] args) throws IOException {
		Integer height = 20;
		FileSensorData listener = new FileSensorData();
		GridFactory grid = new GridFactory(height, listener,  17,18, 19).build();
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
