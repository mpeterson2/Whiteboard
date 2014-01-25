package run;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MyDriver extends Driver {

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	super.start(primaryStage);

	// Center it on my primary monitor.
	Rectangle2D screen = Screen.getScreens().get(Screen.getScreens().size() - 1).getBounds();
	primaryStage.setX(screen.getMaxX() / 2.0 - primaryStage.getScene().getWidth() / 2.0);
	primaryStage.setY(screen.getHeight() / 2.0 - primaryStage.getScene().getHeight() / 2.0);
	primaryStage.centerOnScreen();
    }

}
