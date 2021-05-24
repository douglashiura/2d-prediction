package com.github.douglashiura.two.d.view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.github.douglashiura.two.d.Ball;
import com.github.douglashiura.two.d.Directions;
import com.github.douglashiura.two.d.GridFactory;
import com.github.douglashiura.two.d.Point;

public class GridView extends JFrame {

	private static final long serialVersionUID = 7501477593258854262L;
	private List<HomeView> homes;

	public GridView(List<Point> points, Integer height) {
		homes = new ArrayList<HomeView>(height * height);
		setTitle("Grid");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(height, height));
		for (Point home : points) {
			HomeView homeView = new HomeView(home);
			add(homeView);
			homes.add(homeView);
		}
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Integer height = 15;
				ConsoleSensorData listener = new ConsoleSensorData();
				GridFactory grid = new GridFactory(height, listener, 3, 6, 14).build();
				listener.setSensors(grid.getSensors());
				Ball ball = new Ball(Directions.BELOW, grid.getPoints().get(0));
				GridView view = new GridView(grid.getPoints(), height);
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
		for (HomeView home : homes) {
			home.update(home.getGraphics());
		}
	}

}
