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

/**
 * Allows a user to select a foreground and background color.
 */
public class ColorPalette extends GridPane implements PropertiesListener {

    private ColorPicker foreColorPicker;
    private ColorPicker backColorPicker;

    /**
     * Create a ColorPalette object.
     */
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
	Properties.addListener(this);
    }

    /**
     * Tells the Properties that a color has been changed.
     */
    public void setColor(Color color) {
	Properties.setForeColor(color);
    }

    /**
     * Tells the properties that the background color has been changed.
     */
    public void setBackground(Color color) {
	Properties.setBackColor(color);
    }

    /**
     * If the foreground is changed, this will tell the foreground color picker to change colors.
     */
    @Override
    public void onForeColorChng(Color color) {
	System.out.println(color);
	foreColorPicker.setValue(color);
    }

    /**
     * If the background is changed, this will tell the background color picker to change colors.
     */
    @Override
    public void onBackColorChng(Color color) {
	backColorPicker.setValue(color);
    }

    @Override
    public void onWidthChng(double width) {}
}