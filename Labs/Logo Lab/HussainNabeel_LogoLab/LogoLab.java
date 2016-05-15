/**
 * This program will calculate the square of a number that the user enters.
 * 
 * Name: Nabeel Hussain
 * Class: CMSC203
 * Professor: Jeannette Myers Kartchner
 * Logo Lab 
 * Date: 10/04/2015
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LogoLab extends Application {

	public void start (Stage primaryStage) {
		
		 
		Group root = new Group();
		// Set the canvas size to 500 px width and 330 px height.
		final Canvas canvas = new Canvas(600, 430);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		// Set the color of the canvas to black
		gc.setFill(Color.BLACK);
		gc.fillRect(gc.getCanvas().getLayoutX(),
					gc.getCanvas().getLayoutY(),
					gc.getCanvas().getWidth(),
					gc.getCanvas().getHeight());
		
		// Create the outer half circle arc of the logo.
		// Make the width 5px, and make the color whitesmoke. 
		gc.setLineWidth(5);
		gc.setStroke(Color.WHITESMOKE);
		// The arc size is 200 by 200 px, but with the left side of the circle open. 
		gc.strokeArc(200, 100, 200, 200, 250, 220, ArcType.OPEN);
		
		// Create a quarter circle arc that will be placed on the top half, inside the outer most half circle.
		// Make the width 8 px and the color gray. 
		gc.setLineWidth(8);
		gc.setStroke(Color.GRAY);
		// The inner arc at the top section is 180 by 180 px, with the left side of the circle open.
		gc.strokeArc(210, 110, 180, 180, 10, 90, ArcType.OPEN);
		
		// Create a quarter circle arc that will be placed on the bottom half, inside the outer half circle.
		// Make the width 2 px and the color yellowgreen.
		gc.setLineWidth(2);
		gc.setStroke(Color.YELLOWGREEN);
		// The inner arc at the bottom section is 180 by 180 px, with the left side of the circle open.
		gc.strokeArc(210, 110, 180, 180, 260, 100, ArcType.OPEN);
		
		// Create another quarter circle arc, that will be placed in the third row inside of the outer half circle, but in the middle position. 
		// Make the width 4 px and the color whitesmoke. 
		gc.setLineWidth(4);
		gc.setStroke(Color.WHITESMOKE);
		// The inner most third row arc at the middle section is 160 by 160 px, with the left side of the circle open.
		gc.strokeArc(220, 120, 160, 160, 300, 120, ArcType.OPEN);
		
		// Create the first part of the logo text
		// Make the width of the text 1px and the color whitesmoke.
		gc.setLineWidth(1);
		gc.setStroke(Color.WHITESMOKE);
		gc.setFont(Font.font(null, 30));
		gc.strokeText("Nabeel Hussain", 155, 190);
		
		// Create the second part of the logo text, and place it under the first part. 
		// Make the width of the text 2px and the color yellowgreen.
		gc.setLineWidth(2);
		gc.setStroke(Color.YELLOWGREEN);
		gc.setFont(Font.font(null,FontWeight.BOLD, 30));
		gc.strokeText("Photography", 164, 225);
		
		// add the contents of the logo that are in the canvas to the children of the Group named root. 
		root.getChildren().addAll(canvas);
		//Set the root onto the scene of the stage. 
		primaryStage.setScene(new Scene(root));
		primaryStage.getScene().setFill(Color.BLACK);
		primaryStage.show();
	}
	
		public static void main (String[] args)
	{
		launch(args);
	}

}
