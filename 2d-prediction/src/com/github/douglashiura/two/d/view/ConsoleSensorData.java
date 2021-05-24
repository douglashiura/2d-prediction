package com.github.douglashiura.two.d.view;

import java.util.List;

import com.github.douglashiura.two.d.Listener;
import com.github.douglashiura.two.d.Sensor;

public class ConsoleSensorData implements Listener {

	private List<Sensor> sensors;

	@Override
	public void detection() {
		System.out.println();
		sensors.forEach(
				sensor -> System.out.printf("%s_%s	", sensor.getLastTouch().getX(), sensor.getLastTouch().getY()));
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
		for (int i = 0; i < sensors.size(); i++) {
			System.out.printf("sensor_%s	", i);
		}

	}

}
