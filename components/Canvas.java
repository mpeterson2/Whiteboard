package components;

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import properties.Properties;
import properties.PropertiesListener;

public class Canvas extends Pane implements PropertiesListener {

    private List<Shape> erase;

    public Canvas() {
	erase = new LinkedList<Shape>();
	Properties.addListener(this);
    }

    void setBackground(Color color) {
	setBackground(new Background(new BackgroundFill(
		color, new CornerRadii(0), new Insets(0))));
    }

    public void addShape(Shape s) {
	getChildren().add(s);
    }

    public void addErase(Shape s) {
	getChildren().add(s);
	erase.add(s);
    }

    public double getZoom() {
	return getScaleX();
    }

    @Override
    public void onBackColorChng(Color color) {
	setBackground(color);
	for (Shape n : erase) {
	    n.setStroke(color);
	}
    }

    // Do not care.
    @Override
    public void onWidthChng(double width) {}
    @Override
    public void onForeColorChng(Color color) {}
}