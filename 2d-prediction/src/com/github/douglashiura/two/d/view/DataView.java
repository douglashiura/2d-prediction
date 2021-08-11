package com.github.douglashiura.two.d.view;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.github.douglashiura.two.d.Ball;
import com.github.douglashiura.two.d.Directions;
import com.github.douglashiura.two.d.GridFactory;
import com.github.douglashiura.two.d.Listener;
import com.github.douglashiura.two.d.Point;

public class DataView extends JFrame {

	private static final long serialVersionUID = 7501477593258854262L;
	private List<Point> points;

	public DataView(List<Point> points, Integer height) {
		this.points = points;
		setTitle("Grid");
		setSize(height, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setVisible(true);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Point point : points) {
			g.setColor(point.getColor());
			g.drawLine(point.getX(), point.getY(), point.getX(), point.getY());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		FileSensorData listener = new FileSensorData();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Integer height = 501;
				GridFactory grid = new GridFactory(height, listener, 3, 4, 5, 6, 148, 149, 500).build();
				try {
					listener.setSensors(grid.getSensors());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Ball ball = new Ball(Directions.BELOW, grid.getPoints().get(0));
				DataView view = new DataView(grid.getPoints(), height);
				new Thread() {
					@Override
					public void run() {
						while (true) {

							view.updatePoints(ball.run());
						}
					}
				}.start();
			}
		});

	}

	protected void updatePoints(List<Point> points) {
		Graphics image = getGraphics();
		for (Point point : points) {
			image.setColor(point.getColor());
			image.drawLine(point.getX(), point.getY(), point.getX(), point.getY());
		}
	}

}
