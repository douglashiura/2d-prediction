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
				Integer height = 10;

				List<Point> points = new GridFactory(height).build();
				Ball ball = new Ball(Directions.BELOW, points.get(0));

				GridView view = new GridView(points, height);
				new Thread() {
					@Override
					public void run() {
						while (true) {
							view.updatePoints(ball.run());
							try {
								sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
				}.start();
			}
		});

	}

	protected void updatePoints(List<Point> points) {
		for (HomeView home : homes) {
			home.update(getGraphics());
		}
	}

}
