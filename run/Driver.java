package run;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import tools.Pen;
import tools.Tool;

import components.ColorPalette;

import drawing.Canvas;

public class Driver extends Application {

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("Collaborative Whiteboard");


	Canvas canvas = new Canvas();
	new Tool().setTool(new Pen(canvas));
	new Pen(canvas);

	BorderPane root = new BorderPane();
	root.setCenter(canvas);

	FlowPane top = new FlowPane();
	ColorPalette cp = new ColorPalette();
	top.getChildren().add(cp);
	root.setTop(top);


	primaryStage.setScene(new Scene(root, 500, 500));

	// Center it on my primary monitor.
	Rectangle2D screen = Screen.getScreens().get(Screen.getScreens().size() - 1).getBounds();
	primaryStage.setX(screen.getMaxX() / 2.0 - primaryStage.getScene().getWidth() / 2.0);
	primaryStage.setY(screen.getHeight() / 2.0 - primaryStage.getScene().getHeight() / 2.0);
	primaryStage.centerOnScreen();
	primaryStage.show();
    }
}
