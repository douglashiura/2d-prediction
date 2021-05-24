package com.github.douglashiura.two.d;

public interface Listener {

	public final static Listener EMPTY = new Listener() {
		@Override
		public void detection() {

		}
	};

	public void detection();

}
