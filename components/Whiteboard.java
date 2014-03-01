package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import properties.Defaults;
import tools.Pen;
import tools.Tool;

public class Whiteboard extends BorderPane {

    public Whiteboard() {

	// Setup canvas
	Canvas canvas = new Canvas();
	canvas.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, null, null)));

	// Setup top panel
	HBox top = new HBox();
	top.setBackground(new Background(new BackgroundFill(Defaults.DEFAULT_PANE_COLOR, null, null)));
	WidthPanel wp = new WidthPanel();
	ColorPalette cp = new ColorPalette();

	top.setAlignment(Pos.CENTER_RIGHT);
	top.setSpacing(10);
	top.setPadding(new Insets(5));
	top.getChildren().add(wp);
	top.getChildren().add(cp);
	top.autosize();

	// Set up tools
	new Tool().setTool(new Pen(canvas));

	setCenter(canvas);
	setTop(top);
    }

}
