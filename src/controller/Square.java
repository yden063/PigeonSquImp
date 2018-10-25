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
import model.Food;
import model.Pigeon;

public class Square implements Initializable {
	@FXML
	private AnchorPane anchorPane;
	
	private Circle circle;
    private List<Pigeon> pigeonList;
    private List<Food> foodList;


    public Square(){

        this.pigeonList = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Initialize the frame
		circle = new Circle(200, 150, 50, Color.BLUEVIOLET);

		anchorPane.getChildren().addAll(circle);
		

		
	}

	public void run(){


    }

    public void addPigeon(Pigeon p) {
        this.pigeonList.add(p);
    }

    public void addFood(Food f) {
        /*for (Food food : foodList) {
            if (food.canEat()) {
                food.rot();
                rottenFood.add(food);
            }
        }*/
        this.foodList.add(f);
    }

    public void removeFood(Food f) {

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
			
		});
	}
	
}
