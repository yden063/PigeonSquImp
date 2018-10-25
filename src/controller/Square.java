package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import model.Food;
import model.Pigeon;

public class Square implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	private List<Pigeon> pigeonList;
	private List<Food> foodList;
	private List<Food> rottenFoodList;

	public Square() {
		this.pigeonList = new ArrayList<>();
		this.foodList = new ArrayList<>();
		this.rottenFoodList = new ArrayList<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initialize the frame
		addPigeon(new Pigeon(100, 250, Color.BLUEVIOLET, this, "blueviolet"));
		addPigeon(new Pigeon(400, 100, Color.BEIGE, this, "beige"));
		addPigeon(new Pigeon(90, 400, Color.DARKSEAGREEN, this, "darkseagreen"));

		for (Pigeon pigeon : pigeonList) {
			new Thread(pigeon).start();
		}
		// anchorPane.getChildren().addAll(circle);
		

		handleSetOnMouseClicked();
	}

	public void addPigeon(Pigeon p) {
		anchorPane.getChildren().add(p);
		this.pigeonList.add(p);

	}

	public void addFood(Food f) {
		anchorPane.getChildren().add(f);
		this.foodList.add(f);
	}

	public void removeFood(Food f) {
		// f.notify();
		Platform.runLater(() -> {
			anchorPane.getChildren().remove(f);
			this.foodList.remove(f);	
		});
	}

	public List<Pigeon> getPigeonList() {
		return pigeonList;
	}

	public void addRottenFood(Food f) {

		this.rottenFoodList.add(f);
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

			//new Thread(food).start();
		});
	}

	public void removeRottenFood(Food f) {

		this.addRottenFood(f);
		this.foodList.remove(f);

	}
}
