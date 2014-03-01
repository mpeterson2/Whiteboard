package tools;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import properties.Properties;

import components.Canvas;

/**
 * A Pen tool to draw on a Canvas.
 */
public class Pen extends Tool {

    protected Line line;

    /**
     * Create a Pen tool.
     */
    public Pen(Canvas canvas) {
	super(canvas);
    }

    protected void startLine(double x, double y) {
	// Create the new line and set it's properties.
	line = new Line();
	line.setStartX(x);
	line.setStartY(y);
	line.setStroke(Properties.getForeColor());
	line.setStrokeWidth(Properties.getWidth());
	line.setStrokeLineCap(StrokeLineCap.ROUND);
	line.setStrokeLineJoin(StrokeLineJoin.BEVEL);
    }

    protected void endLine(double x, double y) {
	// End the line and add it to the Canvas.
	line.setEndX(x);
	line.setEndY(y);
	getCanvas().addShape(line);
    }

    @Override
    public void onMouseDown(MouseEvent e) {
	super.onMouseDown(e);
	// This is the start of our line.
	startLine(e.getX(), e.getY());
    }

    @Override
    public void onMouseDrag(MouseEvent e) {
	super.onMouseDrag(e);
	// End the line and start a new one.
	endLine(e.getX(), e.getY());
	startLine(e.getX(), e.getY());
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
	// End the line (usually this makes a dot if there is no drag).
	endLine(e.getX(), e.getY());
    }
}
