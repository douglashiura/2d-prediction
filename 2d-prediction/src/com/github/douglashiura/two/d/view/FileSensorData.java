package com.github.douglashiura.two.d.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.github.douglashiura.two.d.Listener;
import com.github.douglashiura.two.d.Sensor;

public class FileSensorData implements Listener {

	private List<Sensor> sensors;
	private FileOutputStream file;

	public FileSensorData() throws FileNotFoundException {
		file = new FileOutputStream("data.txt");
	}

	@Override
	public void detection() {
		try {
			file.write("\n".getBytes());
		} catch (IOException e1) {
		}
		sensors.forEach(sensor -> {
			try {
				file.write(String.format("%s_%s	", sensor.getLastTouch().getX(), sensor.getLastTouch().getY())
						.getBytes());
			} catch (IOException e) {
			}
		});
	}

	public void setSensors(List<Sensor> sensors) throws IOException {
		this.sensors = sensors;
		for (int i = 0; i < sensors.size(); i++) {
			file.write(String.format("sensor_%s	", i).getBytes());
		}

	}

}
