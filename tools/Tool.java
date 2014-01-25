package tools;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import drawing.Canvas;

public class Tool implements EventHandler<MouseEvent> {

    private Canvas canvas;
    private Tool tool;

    public Tool() {
    }

    protected Tool(Canvas canvas) {
	this.canvas = canvas;
    }

    public void onMouseDown(MouseEvent e) {
    }

    public void onMouseDrag(MouseEvent e) {

    }

    public void onMouseReleased(MouseEvent e) {

    }

    public Canvas getCanvas() {
	return canvas;
    }

    public void setTool(Tool tool) {
	if (this.tool != null)
	    this.tool.getCanvas().removeEventHandler(MouseEvent.ANY, tool);
	this.tool = tool;
	tool.getCanvas().addEventHandler(MouseEvent.ANY, tool);
    }

    public Tool getTool() {
	return tool;
    }

    @Override
    public void handle(MouseEvent e) {
	if (e.isPrimaryButtonDown()) {
	    if (e.getEventType().equals(MouseEvent.MOUSE_DRAGGED))
		onMouseDrag(e);
	    else if (e.getEventType().equals(MouseEvent.MOUSE_PRESSED))
		onMouseDown(e);
	    else if (e.getEventType().equals(MouseEvent.MOUSE_RELEASED))
		onMouseReleased(e);
	}
    }
}
