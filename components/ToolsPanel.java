package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import tools.Eraser;
import tools.Pen;
import tools.Tool;

public class ToolsPanel extends HBox {

    public static String PEN_ICON = "../images/pen.png";
    public static String ERASER_ICON = "../images/eraser.png";
    public static int BTN_SIZE = 25;

    private Button penBtn;
    private Button eraserBtn;
    private Tool tools;
    private Canvas canvas;

    public ToolsPanel(Tool tools, Canvas canvas) {
	super();

	this.tools = tools;
	this.canvas = canvas;
	penBtn = new Button();
	eraserBtn = new Button();

	createBtn(penBtn, PEN_ICON);
	createBtn(eraserBtn, ERASER_ICON);
	setupButtons();
    }

    private void createBtn(Button btn, String imgLocation) {
	Image img = new Image(getClass().getResourceAsStream(imgLocation), BTN_SIZE, BTN_SIZE, true, true);
	ImageView imgView = new ImageView(img);
	btn.setGraphic(imgView);
	btn.setPrefSize(BTN_SIZE, BTN_SIZE);

	getChildren().add(btn);
    }

    private void setupButtons() {
	penBtn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		tools.setTool(new Pen(canvas));
	    }

	});

	eraserBtn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		tools.setTool(new Eraser(canvas));
	    }

	});
    }

}
