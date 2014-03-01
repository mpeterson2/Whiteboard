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

/**
 * Canvas allows a user to add various shapes to a Pane.
 * 
 */
public class Canvas extends Pane implements PropertiesListener {

    private List<Shape> erase;

    /**
     * Create a Canvas object.
     */
    public Canvas() {
	erase = new LinkedList<Shape>();
	Properties.addListener(this);
    }

    /**
     * Set the background color of this Canvas.
     */
    void setBackground(Color color) {
	setBackground(new Background(new BackgroundFill(
		color, new CornerRadii(0), new Insets(0))));
    }

    /**
     * Add a Shape to this Canvas.
     */
    public void addShape(Shape s) {
	getChildren().add(s);
    }

    /**
     * Add an eraser Shape to this Canvas.
     * 
     * If the background color is changed, these Shapes will update their color as well.
     */
    public void addErase(Shape s) {
	getChildren().add(s);
	erase.add(s);
    }

    /**
     * Get the zoom of this Canvas.
     */
    public double getZoom() {
	return getScaleX();
    }

    /**
     * Changes the background color and erase Shape color.
     */
    @Override
    public void onBackColorChng(Color color) {
	setBackground(color);

	// Set all the erase shape colors.
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