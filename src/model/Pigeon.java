package model;

import java.awt.Point;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Pigeon implements Runnable {

	private Point point;
	private boolean isAlive;
	private Color color;
	private Object square;

	public Pigeon(int x, int y, Color color) {
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
		goToFood();
	}

	private void goToFood() {
		List<Food> foods = square.getFoods();	
		Point p = findFood(foods);
		
		if (p != null) {
			moveTo(p);
		}
	}
	
	private Point findFood(List<Food> foods) {
		Point p = null;
		
		if (foods.size() > 0) {
			Double distance = calculateDistance(foods.get(0));
			p = foods.get(0);
			
			for (int i = 1; i < foods.size(); i++) {	
				if (calculateDistance(foods.get(i)) < distance) {
					p = foods.get(i);
				}
			}
		}
		
		return p;
	}
	
	private Double calculateDistance(Point p1) {
		Double sumX = Math.pow(p1.x - point.x, 2);
		Double sumY = Math.pow(p1.y - point.y, 2);
		
		return Math.sqrt(sumX + sumY);
	}

	private void moveTo(Point p) {
		if (point.x<p.x) point.x++; 
		if (point.x>p.x) point.x--; 
		if (point.y<p.y) point.y++; 
		if (point.y>p.y) point.y--; 
	}
}
