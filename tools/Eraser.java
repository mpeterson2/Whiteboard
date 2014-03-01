package tools;

import properties.Properties;

import components.Canvas;

public class Eraser extends Pen {

    public Eraser(Canvas canvas) {
	super(canvas);
    }

    @Override
    protected void startLine(double x, double y) {
	super.startLine(x, y);
	line.setStroke(Properties.getBackground());
    }

    @Override
    protected void endLine(double x, double y) {
	line.setEndX(x);
	line.setEndY(y);
	getCanvas().addErase(line);
    }

}
