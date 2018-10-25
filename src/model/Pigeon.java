package model;

import java.awt.Point;
import java.util.List;

import controller.Square;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pigeon implements Runnable {

	private Point point;
	private boolean isAlive;
	private Color color;
	private Square square;
	private Circle circle;

	public Pigeon(int x, int y, Color color, Square square) {
		this.point = new Point(x, y);
		this.isAlive = true;
		this.color = color;
		this.square = square;
	}

	@Override
	public void run() {
		while (isAlive) {
			live();
		}
	}

	private void live() {
		goToFood();

		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void goToFood() {
		List<Food> foods = square.getFoodList();
		Food f = findFood(foods);

		if (f != null) {
			moveTo(f);
		}
	}

	private Food findFood(List<Food> foods) {
		Food f = null;

		if (foods.size() > 0) {
			Double distance = calculateDistance(foods.get(0).getPoint());
			f = foods.get(0);

			for (int i = 1; i < foods.size(); i++) {
				if (calculateDistance(foods.get(i).getPoint()) < distance) {
					f = foods.get(i);
				}
			}
		}

		return f;
	}

	private Double calculateDistance(Point p1) {
		Double sumX = Math.pow(p1.x - point.x, 2);
		Double sumY = Math.pow(p1.y - point.y, 2);

		return Math.sqrt(sumX + sumY);
	}

	private void moveTo(Food f) {
		if (point.x == f.getPoint().x && point.y == f.getPoint().y) {
			if (f.isFresh()) {
				System.out.println("The " + this.color.toString() + " pigeon is eating!");
				this.square.removeFood(f);
			} else {
				// The food is rotten
				this.square.removeRottenFood(f);
				System.out.println("The pigeon doesn't like this food");
			}
		} else {
			if (point.x < f.getPoint().x)
				point.x++;

			if (point.x > f.getPoint().x)
				point.x--;

			if (point.y < f.getPoint().y)
				point.y++;

			if (point.y > f.getPoint().y)
				point.y--;
		}

		update();
	}

	public Point getPoint() {
		return this.point;
	}

	public Color getColor() {
		return this.color;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	private void update() {
		this.circle.setCenterX(this.point.x);
		this.circle.setCenterY(this.point.y);
	}
}
