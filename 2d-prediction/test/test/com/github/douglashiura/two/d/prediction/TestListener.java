package test.com.github.douglashiura.two.d.prediction;

import com.github.douglashiura.two.d.Listener;

public class TestListener implements Listener {
	private Boolean touched;

	public Boolean isTouched() {
		return touched;
	}

	@Override
	public void detection() {
		touched = true;
	}

}
