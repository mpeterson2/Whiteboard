package tools;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

import components.Canvas;

/**
 * Use Tools to draw/edit/do whatever on a Canvas.
 * 
 * This class should be extended to create new tools.
 */
public class Tool implements EventHandler<MouseEvent> {

    private Canvas canvas;
    protected Tool tool;
    private Mover mover;
    private boolean primaryClick;

    /**
     * Create a fake Tool. This tool will hold the real tool and should be the only tool used on a Canvas.
     */
    public Tool() {}

    /**
     * Create a Tool. This should be implemented further by subclasses.
     */
    protected Tool(Canvas canvas) {
	this.canvas = canvas;
    }

    /**
     * Called when the left mouse is clicked down.
     */
    public void onMouseDown(MouseEvent e) {}

    /**
     * Called when the left mouse has been dragged.
     */
    public void onMouseDrag(MouseEvent e) {}

    /**
     * Called when the left mouse has been released.
     */
    public void onMouseReleased(MouseEvent e) {}

    /**
     * Called when the right mouse is clicked down.
     * 
     * By default, this will activate the Mover tool.
     */
    public void onRightMouseDown(MouseEvent e) {
	mover.onMouseDown(e);
    }

    /**
     * Called when the right mouse has been dragged.
     * 
     * By default, this will activate the Mover tool.
     */
    public void onRightMouseDrag(MouseEvent e) {
	mover.onMouseDrag(e);
    }

    /**
     * Called when the right mouse has been released.
     * 
     * By default, this will activate the Mover tool.
     */
    public void onRightMouseReleased(MouseEvent e) {
	mover.onMouseReleased(e);
    }

    /**
     * Get the Canvas this tool is editing.
     */
    public Canvas getCanvas() {
	return canvas;
    }

    /**
     * Set the current Tool. This will disable the current Tool and enable a new Tool.
     */
    public void setTool(Tool tool) {
	if (this.tool != null) {
	    // If the tool existed before, remove it's event handler
	    this.tool.getCanvas().removeEventHandler(MouseEvent.ANY, this.tool);
	    // Also reuse it's mover tool.
	    tool.setMover(this.tool.getMover());
	}
	else {
	    // Set the mover to a new mover if it didn't already exist.
	    tool.setMover(new Mover(tool));
	}

	// Setup the tool.
	this.tool = tool;
	tool.getCanvas().setCursor(tool.getCursor());
	tool.getCanvas().addEventHandler(MouseEvent.ANY, tool);
    }

    /**
     * Get the current Tool.
     */
    public Tool getTool() {
	return tool;
    }

    /**
     * Set this Tool's Mover tool for right clicking.
     */
    public void setMover(Mover mover) {
	this.mover = mover;
    }

    /**
     * Get this Tool's Mover tool for right clicking.
     */
    public Mover getMover() {
	return mover;
    }

    /**
     * Get this Tool's cursor.
     */
    public Cursor getCursor() {
	return Cursor.DEFAULT;
    }

    /**
     * Handle mouse events on the Canvas.
     * 
     * This will pass relevant events on to methods for subclasses to override.
     */
    @Override
    public void handle(MouseEvent e) {
	// If left click.
	if (e.isPrimaryButtonDown()) {
	    primaryClick = true;
	    if (e.getEventType().equals(MouseEvent.MOUSE_DRAGGED))
		onMouseDrag(e);
	    else if (e.getEventType().equals(MouseEvent.MOUSE_PRESSED))
		onMouseDown(e);
	}
	// If right click.
	else if (e.isSecondaryButtonDown()) {
	    primaryClick = false;
	    if (e.getEventType().equals(MouseEvent.MOUSE_DRAGGED))
		onRightMouseDrag(e);
	    else if (e.getEventType().equals(MouseEvent.MOUSE_PRESSED))
		onRightMouseDown(e);
	}

	// If releasing and was left click.
	else if (primaryClick) {
	    if (e.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
		onMouseReleased(e);
	    }
	}
	// If releasing and was right click.
	else {
	    if (e.getEventType().equals(MouseEvent.MOUSE_RELEASED))
		onRightMouseReleased(e);
	}
    }
}
