package model;

import java.awt.Point;
import java.util.List;

import controller.Square;
import javafx.scene.paint.Color;

public class Pigeon implements Runnable {

	private Point point;
	private boolean isAlive;
	private Color color;
	private Square square;

	public Pigeon(int x, int y, Color color) {
		this.color = color;
		this.point = new Point(x, y);
		this.isAlive = true;
	}

	@Override
	public void run() {
		while (isAlive) {
			live();
		}
	}

	private void live() {
		List<Food> foods = square.getFoodList();
		findFood();
	}

	private void findFood() {
		// TODO Auto-generated method stub
		
	}


}
