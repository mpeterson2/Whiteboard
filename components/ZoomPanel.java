package components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

/**
 * A panel that controls the zoom of a Canvas.
 */
public class ZoomPanel extends HBox {

    /**
     * Create a ZoomPanel object.
     */
    public ZoomPanel(final Canvas canvas) {
	super();

	// Create the slider/label.
	Slider zoomSlider = new Slider(1, 1000, 100);
	final Label zoomLabel = new Label("Zoom: 100%");

	// Setup the listener for the slider.
	zoomSlider.valueProperty().addListener(new ChangeListener<Number>() {
	    @Override
	    public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
		double zoom = newVal.doubleValue();
		canvas.setZoom(zoom / 100.0);

		// Display zoom as an int because it looks nicer.
		zoomLabel.setText("Zoom: " + (int) zoom + "%");
	    }

	});

	// Add the slider/label.
	getChildren().add(zoomSlider);
	getChildren().add(zoomLabel);
    }

}
