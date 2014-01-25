package tools;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import properties.Properties;
import drawing.Canvas;

public class Pen extends Tool {

    private Line line;

    public Pen(Canvas canvas) {
	super(canvas);
    }

    private void startLine(double x, double y) {
	line = new Line();
	line.setStartX(x);
	line.setStartY(y);
	line.setStroke(Properties.getColor());
	line.setStrokeWidth(Properties.getWidth());
	line.setStrokeLineCap(StrokeLineCap.ROUND);
	line.setStrokeLineJoin(StrokeLineJoin.BEVEL);
    }

    private void endLine(double x, double y) {
	line.setEndX(x);
	line.setEndY(y);
	getCanvas().addShape(line);
    }

    @Override
    public void onMouseDown(MouseEvent e) {
	super.onMouseDown(e);
	startLine(e.getX(), e.getY());
    }

    @Override
    public void onMouseDrag(MouseEvent e) {
	super.onMouseDrag(e);
	endLine(e.getX(), e.getY());
	startLine(e.getX(), e.getY());
    }

}
