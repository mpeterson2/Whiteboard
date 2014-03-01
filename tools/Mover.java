package tools;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * A tool to pan around the Canvas.
 */
public class Mover extends Tool {

    private double iniX;
    private double iniY;

    /**
     * Create a Mover.
     */
    public Mover(Tool tool) {
	super(tool.getCanvas());

	setTool(tool);
    }

    @Override
    public void onMouseDown(MouseEvent e) {
	// Get an initial X/Y point.
	iniX = e.getX();
	iniY = e.getY();

	// Set the cursor
	getCanvas().setCursor(Cursor.MOVE);
    }

    @Override
    public void onMouseDrag(MouseEvent e) {
	// Change the translation of each Node on the Canvas.
	for (Node c : getCanvas().getChildren()) {
	    c.setTranslateX((c.getTranslateX() + e.getX()) / getCanvas().getZoom() - iniX / getCanvas().getZoom());
	    c.setTranslateY((c.getTranslateY() + e.getY()) / getCanvas().getZoom() - iniY / getCanvas().getZoom());
	}

	// Set the inital X/Y points for the next drag.
	iniX = e.getX();
	iniY = e.getY();
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
	// Return the cursor to the current Tools cursor.
	getCanvas().setCursor(getTool().getCursor());
    }

    @Override
    public void setTool(Tool tool) {
	// Don't do all that super stuff. We just want a basic setter.
	this.tool = tool;
    }

    // These must be implemented so the mover is not called on themselves.
    @Override
    public void onRightMouseDown(MouseEvent e) {}

    @Override
    public void onRightMouseDrag(MouseEvent e) {}

    @Override
    public void onRightMouseReleased(MouseEvent e) {}

}
