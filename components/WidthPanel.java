package components;

import java.text.DecimalFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import properties.Properties;

/**
 * This allows a user to change the width of a Shape.
 */
public class WidthPanel extends VBox {

    Label widthLabel;
    Slider widthSlider;

    /**
     * Create a WidthPanel object.
     */
    public WidthPanel() {
	// Create the GUI.
	setAlignment(Pos.CENTER);
	widthSlider = new Slider(0.1, 100.0, Properties.getWidth());
	widthLabel = new Label("Width: " + widthSlider.getValue());

	// Setup what happens when the slider changes.
	widthSlider.valueProperty().addListener(new ChangeListener<Number>() {
	    @Override
	    public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
		// Make it look good with a format.
		DecimalFormat df = new DecimalFormat("#.#");
		double val = Double.parseDouble(df.format(newVal));
		widthLabel.setText("Width: " + val);
		Properties.setWidth(val);
	    }

	});

	// Add the Nodes.
	getChildren().add(widthLabel);
	getChildren().add(widthSlider);
    }

}
