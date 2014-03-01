package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import tools.ColorPicker;
import tools.Eraser;
import tools.Pen;
import tools.Tool;

/**
 * Allows a user to change their tool.
 */
public class ToolsPanel extends HBox {

    public static String PEN_ICON = "../images/pen.png";
    public static String ERASER_ICON = "../images/eraser.png";
    public static String COLOR_PICKER_ICON = "../images/color-picker.png";
    public static int BTN_SIZE = 25;

    private Button penBtn;
    private Button eraserBtn;
    private Button colorPickerBtn;
    private Tool tools;
    private Canvas canvas;

    /**
     * Create a ToolsPanel.
     */
    public ToolsPanel(Tool tools, Canvas canvas) {
	super();

	// Setup variables.
	this.tools = tools;
	this.canvas = canvas;

	// Create the buttons.
	penBtn = new Button();
	eraserBtn = new Button();
	colorPickerBtn = new Button();
	createBtn(penBtn, PEN_ICON);
	createBtn(eraserBtn, ERASER_ICON);
	createBtn(colorPickerBtn, COLOR_PICKER_ICON);
	setupButtons();

	// The pen is the initial button.
	setActive(penBtn);
    }

    /**
     * Creates a uniform styled button.
     */
    private void createBtn(Button btn, String imgLocation) {
	// Create the button
	Image img = new Image(getClass().getResourceAsStream(imgLocation), BTN_SIZE, BTN_SIZE, true, true);
	ImageView imgView = new ImageView(img);
	btn.setGraphic(imgView);
	btn.setPrefSize(BTN_SIZE, BTN_SIZE);

	// Add it to the HBox.
	getChildren().add(btn);
    }

    /**
     * Setup the button actions.
     */
    private void setupButtons() {
	// Change the tool to the pen when clicked.
	penBtn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		tools.setTool(new Pen(canvas));
		setActive(penBtn);
	    }
	});

	// Change the tool to the eraser when clicked.
	eraserBtn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		tools.setTool(new Eraser(canvas));
		setActive(eraserBtn);
	    }
	});

	colorPickerBtn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		tools.setTool(new ColorPicker(canvas));
		setActive(colorPickerBtn);
	    }
	});
    }

    /**
     * Set a button to look active. Also sets the other buttons inactive.
     */
    private void setActive(Button btn) {
	// Show the active button.
	btn.setBorder(new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.SOLID, null, null)));

	// Deactivate the rest of the buttons.
	for (Node n : getChildren()) {
	    if (!n.equals(btn)) {
		((Button) n).setBorder(null);
	    }
	}
    }

}
