package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import properties.Properties;
import properties.PropertiesListener;

public class ColorPalette extends GridPane implements PropertiesListener {

    private ColorPicker foreColorPicker;
    private ColorPicker backColorPicker;

    public ColorPalette() {
	// Create background color picker.
	Label backLabel = new Label("Background");
	backColorPicker = new ColorPicker(Color.WHITE);
	backColorPicker.setPrefWidth(103.0);
	backColorPicker.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		setBackground(backColorPicker.getValue());
	    }
	});

	// Create foreground color picker.
	Label foreLabel = new Label("Foreground");
	foreColorPicker = new ColorPicker(Color.BLACK);
	foreColorPicker.setPrefWidth(103.0);
	foreColorPicker.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		setColor(foreColorPicker.getValue());
	    }
	});

	// Add the components.
	add(backLabel, 0, 0);
	add(backColorPicker, 0, 1);
	add(foreLabel, 1, 0);
	add(foreColorPicker, 1, 1);

	// Center the labels.
	setHalignment(backLabel, HPos.CENTER);
	setHalignment(foreLabel, HPos.CENTER);
    }

    public void setColor(Color color) {
	Properties.setColor(color);
    }

    public void setBackground(Color color) {
	Properties.setBackground(color);
    }

    @Override
    public void onForeColorChng(Color color) {
	// foregroundBtn.setBackground(new Background(new BackgroundFill(color, new CornerRadii(5.0), null)));
    }

    @Override
    public void onBackColorChng(Color color) {
	// backgroundBtn.setBackground(new Background(new BackgroundFill(color, new CornerRadii(5.0), null)));
    }

    @Override
    public void onWidthChng(double width) {}
}