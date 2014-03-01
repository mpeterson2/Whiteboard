package tools;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class Mover extends Tool {

    private double iniX;
    private double iniY;

    public Mover(Tool tool) {
	super(tool.getCanvas());

	setTool(tool);
    }

    @Override
    public void onMouseDown(MouseEvent e) {
	iniX = e.getX();
	iniY = e.getY();
	getCanvas().setCursor(Cursor.MOVE);
    }

    @Override
    public void onMouseDrag(MouseEvent e) {

	// getCanvas().setTranslateX(getCanvas().getTranslateX() + iniX - e.getX());
	// getCanvas().setTranslateX(getCanvas().getTranslateY() + iniY - e.getY());
	// getCanvas().setTranslateX(iniX - e.getX());
	// getCanvas().setTranslateY(iniY - e.getY());
	// getCanvas().setLayoutX(e.getSceneX() - iniX);

	for (Node c : getCanvas().getChildren()) {
	    /*
	     * getCanvas().getTranslateY() + clickPoint.y/getCanvas().getZoom() - p.y/getCanvas().getZoom()
	     */
	    // c.setTranslateX(c.getTranslateX() + iniX - e.getX());
	    // c.setTranslateY(c.getTranslateY() + iniY - e.getY());
	    // c.setTranslateX(e.getX() - c.getTranslateX());
	    // c.setTranslateY(e.getY() - c.getTranslateY());

	    c.setTranslateX((c.getTranslateX() + e.getX()) / getCanvas().getZoom() - iniX / getCanvas().getZoom());
	    c.setTranslateY((c.getTranslateY() + e.getY()) / getCanvas().getZoom() - iniY / getCanvas().getZoom());
	}

	iniX = e.getX();
	iniY = e.getY();
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
	getCanvas().setCursor(getTool().getCursor());
    }

    @Override
    public void setTool(Tool tool) {
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
