package components;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class LocationPanel extends HBox {

    public LocationPanel(final Canvas canvas) {
	super();

	final Label locationLbl = new Label("Location: (X: 0, Y: 0)");

	canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent e) {
		int x = (int) (canvas.getLocationX() - e.getX()) * -1;
		int y = (int) (canvas.getLocationY() - e.getY()) * -1;
		locationLbl.setText("Location: (X: " + x + ", Y: " + y + ")");
	    }

	});

	getChildren().add(locationLbl);
    }

}
