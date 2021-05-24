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
		file = new FileOutputStream("data.csv");
	}

	@Override
	public void detection() {
		try {
			file.write("\n".getBytes());
			for (int i = 0; i < sensors.size(); i++) {
				Sensor sensor = sensors.get(i);
				if (i == 0) {
					file.write(String.format("%s", sensor.getLastTouch().getY()).getBytes());

				} else {
					file.write(String.format(", %s", sensor.getLastTouch().getY()).getBytes());

				}
			}

		} catch (IOException e1) {
		}

	}

	public void setSensors(List<Sensor> sensors) throws IOException {
		this.sensors = sensors;
		for (int i = 0; i < sensors.size(); i++) {
			if (i == 0) {
				file.write(String.format("sensor_%s", i).getBytes());

			} else {
				file.write(String.format(", sensor_%s", i).getBytes());

			}
		}

	}

}
