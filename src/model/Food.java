package model;

import java.awt.Point;

public class Food implements Runnable {
	private Point point;
	private boolean fresh;
	

	public Food(int x, int y) {
		this.point = new Point(x, y);
	}

	public Point getPoint() {
		return this.point;
	}

	public boolean isFresh() {
		return fresh;
	}

	@Override
	public void run() {
		fresh = true;

		try {
			wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		fresh = false;

	}
}
