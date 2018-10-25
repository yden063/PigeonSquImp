package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Food;
import model.Pigeon;

public class Square implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	private Circle circle;
	private List<Pigeon> pigeonList;
	private List<Food> foodList;

	public Square() {

		this.pigeonList = new ArrayList<>();
		this.foodList = new ArrayList<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Initialize the frame
		addPigeon(new Pigeon(100, 250, Color.BLUEVIOLET));
		addPigeon(new Pigeon(400, 100, Color.BEIGE));
		addPigeon(new Pigeon(90, 400, Color.DARKSEAGREEN));

		// anchorPane.getChildren().addAll(circle);

		handleSetOnMouseClicked();
	}

	public void run() {
		
	}

	public void addPigeon(Pigeon p) {
		Circle circle = new Circle(p.getPoint().x, p.getPoint().y, 10, p.getColor());
		anchorPane.getChildren().add(circle);

		this.pigeonList.add(p);
	}

	public void addFood(Food f) {
		Rectangle rectangle = new Rectangle(f.getPoint().x, f.getPoint().y, 10, 10);
		anchorPane.getChildren().add(rectangle);

		this.foodList.add(f);
	}

	public void removeFood(Food f) {
		f.notify();
		this.foodList.remove(f);
	}

	public List<Pigeon> getPigeonList() {
		return pigeonList;
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	private void handleSetOnMouseClicked() {
		anchorPane.setOnMouseClicked(e -> {
			Double dx = e.getSceneX();
			Double dy = e.getSceneY();

			Food food = new Food(dx.intValue(), dy.intValue());
			addFood(food);
			
		});
	}

}
