package tools;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

import components.Canvas;

public class Tool implements EventHandler<MouseEvent> {

    private Canvas canvas;
    protected Tool tool;
    private Mover mover;
    private boolean primaryClick;

    public Tool() {}

    protected Tool(Canvas canvas) {
	this.canvas = canvas;
    }

    public void onMouseDown(MouseEvent e) {}
    public void onMouseDrag(MouseEvent e) {}
    public void onMouseReleased(MouseEvent e) {}

    public void onRightMouseDown(MouseEvent e) {
	mover.onMouseDown(e);
    }

    public void onRightMouseDrag(MouseEvent e) {
	mover.onMouseDrag(e);
    }

    public void onRightMouseReleased(MouseEvent e) {
	mover.onMouseReleased(e);
    }

    public Canvas getCanvas() {
	return canvas;
    }

    public void setTool(Tool tool) {
	if (this.tool != null) {
	    this.tool.getCanvas().removeEventHandler(MouseEvent.ANY, tool);
	    tool.setMover(this.tool.getMover());
	}
	else {
	    tool.setMover(new Mover(tool));
	}

	this.tool = tool;
	tool.getCanvas().addEventHandler(MouseEvent.ANY, tool);
    }

    public Tool getTool() {
	return tool;
    }

    public void setMover(Mover mover) {
	this.mover = mover;
    }

    public Mover getMover() {
	return mover;
    }

    public Cursor getCursor() {
	return Cursor.DEFAULT;
    }

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
