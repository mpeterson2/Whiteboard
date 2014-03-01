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

/**
 * A whiteboard object.
 * 
 * This allows users to draw on a center panel. They can change colors/sizes and pan around the whiteboard.
 */
public class Whiteboard extends BorderPane {

    /**
     * Create a Whiteboard object.
     */
    public Whiteboard() {

	// Setup canvas
	Canvas canvas = new Canvas();
	canvas.setBorder(new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, null, null)));

	// Set up tools
	Tool tools = new Tool();
	tools.setTool(new Pen(canvas));

	// Setup top panel
	HBox top = new HBox();
	top.setBackground(new Background(new BackgroundFill(Defaults.DEFAULT_PANE_COLOR, null, null)));
	ToolsPanel tp = new ToolsPanel(tools, canvas);
	WidthPanel wp = new WidthPanel();
	ColorPalette cp = new ColorPalette();

	// Setup some styling.
	top.setAlignment(Pos.CENTER_RIGHT);
	top.setSpacing(10);
	top.setPadding(new Insets(5));

	// Add children to top.
	top.getChildren().add(tp);
	top.getChildren().add(wp);
	top.getChildren().add(cp);
	top.autosize();

	// Setup the border layout.
	setCenter(canvas);
	setTop(top);
    }

}
