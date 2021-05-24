package com.github.douglashiura.two.d.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import com.github.douglashiura.two.d.Point;

public class HomeView extends JLabel {

	private static final long serialVersionUID = 1L;
	private Point home;

	public HomeView(Point home) {
		this.home = home;
		setFont(new Font("Arial", Font.PLAIN, 10));

		setBorder(BorderFactory.createLineBorder(Color.black));

	}

	@Override
	public void update(Graphics g) {
		setBorder(BorderFactory.createLineBorder(home.getBorder()));
		setForeground(home.getColor());
		setBackground(home.getColor());
		setOpaque(true);
		super.update(g);
	}

	public Point getPoint() {
		return home;
	}

}
