package components;

import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import properties.Defaults;
import tools.Pen;
import tools.Tool;
import drawing.Canvas;

public class Whiteboard extends BorderPane {

    public Whiteboard() {

	// Setup canvas
	Canvas canvas = new Canvas();
	canvas.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, null, null)));

	// Setup top panel
	FlowPane top = new FlowPane();
	top.setBackground(new Background(new BackgroundFill(Defaults.DEFAULT_PANE_COLOR, null, null)));
	ColorPalette cp = new ColorPalette();
	top.setAlignment(Pos.CENTER_RIGHT);
	top.getChildren().add(cp);

	// Set up tools
	new Tool().setTool(new Pen(canvas));
	new Pen(canvas);

	setCenter(canvas);
	setTop(top);
    }

}
