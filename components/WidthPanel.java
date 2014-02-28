package components;

import java.text.DecimalFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import properties.Properties;

public class WidthPanel extends VBox {

    Label widthLabel;
    Slider widthSlider;

    public WidthPanel() {
	widthLabel = new Label("Width: 5");

	widthSlider = new Slider(0.1, 100.0, 5.0);
	widthSlider.valueProperty().addListener(new ChangeListener<Number>() {

	    @Override
	    public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
		DecimalFormat df = new DecimalFormat("#.#");
		double val = Double.parseDouble(df.format(newVal));
		widthLabel.setText("Width: " + val);
		Properties.setWidth(val);
	    }

	});


	getChildren().add(widthLabel);
	getChildren().add(widthSlider);
    }

}
