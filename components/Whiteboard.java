package components;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import properties.Defaults;
import tools.Pen;
import tools.Tool;

/**
 * A whiteboard object.
 * 
 * This allows users to draw on a center panel. They can change colors/sizes and pan around the whiteboard.
 */
public class Whiteboard extends BorderPane {

    Canvas canvas;
    Tool tools;
    VBox top;
    HBox bottom;

    /**
     * Create a Whiteboard object.
     * 
     * @param scene
     */
    public Whiteboard() {
	// Setup canvas
	canvas = new Canvas();

	// Setup tools
	tools = new Tool();
	tools.setTool(new Pen(canvas));

	// Setup top/bottom panels.
	setupTop();
	setupBottom();

	// Setup the border layout.
	setCenter(canvas);
	setTop(top);
	setBottom(bottom);
    }

    private void setupTop() {
	// Create the components.
	top = new VBox();
	HBox topControls = new HBox();
	ToolsPanel toolsPanel = new ToolsPanel(tools, canvas);
	WidthPanel widthPanel = new WidthPanel();
	ColorPalette colorPalette = new ColorPalette();

	// Setup some styling.
	top.setBackground(new Background(new BackgroundFill(Defaults.DEFAULT_PANE_COLOR, null, null)));
	topControls.setSpacing(10);
	topControls.setPadding(new Insets(5));
	HBox.setHgrow(toolsPanel, Priority.ALWAYS);

	// Add children to top controls panel.
	topControls.getChildren().add(toolsPanel);
	topControls.getChildren().add(widthPanel);
	topControls.getChildren().add(colorPalette);

	top.getChildren().add(new WhiteboardMenu(canvas));
	top.getChildren().add(topControls);
    }

    private void setupBottom() {
	bottom = new HBox();

	// Create a spacer.
	Region spacer = new Region();
	HBox.setHgrow(spacer, Priority.ALWAYS);

	// Add the components.
	bottom.setBackground(new Background(new BackgroundFill(Defaults.DEFAULT_PANE_COLOR, null, null)));
	bottom.getChildren().add(new ZoomPanel(canvas));
	bottom.getChildren().add(spacer);
	bottom.getChildren().add(new LocationPanel(canvas));
    }
}
