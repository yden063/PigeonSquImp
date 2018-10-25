package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FrameController implements Initializable {
	@FXML
	private AnchorPane anchorPane;
	
	private Circle circle;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initialize the frame
		circle = new Circle(200, 150, 50, Color.BLUEVIOLET);

		anchorPane.getChildren().addAll(circle);
		

		
	}
	
	private void handleSetOnMouseClicked() {
		anchorPane.setOnMouseClicked(e -> {
			
		});
	}
	
}
