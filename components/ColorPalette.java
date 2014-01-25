package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import properties.Properties;

public class ColorPalette extends FlowPane {

    public static final double BTN_SIZE = 25;
    public static final double BTN_GAP = 2;
    public static final int BTN_PER_ROW = 8;
    public static final double WIDTH = BTN_SIZE * BTN_PER_ROW + BTN_GAP * BTN_PER_ROW;

    private FlowPane buttonPane;
    private boolean isForGround;

    public ColorPalette() {
	isForGround = true;

	Button forColor = new Button();
	forColor.setBackground(new Background(new BackgroundFill(Properties.getColor(), new CornerRadii(5.0), null)));
	Button backColor = new Button();
	backColor.setBackground(new Background(new BackgroundFill(Properties.getBackground(), new CornerRadii(5.0), null)));

	forColor.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		isForGround = true;
	    }

	});

	backColor.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		isForGround = false;
	    }
	});

	buttonPane = new FlowPane();
	buttonPane.setPrefWidth(WIDTH);
	buttonPane.setHgap(BTN_GAP);

	addColor(Color.WHITE, true);
	addColor(Color.LIGHTGRAY, true);
	addColor(Color.DARKGRAY, true);
	addColor(Color.BLACK, true);

	addColor(Color.RED, true);
	addColor(Color.rgb(255, 127, 0), true);
	addColor(Color.YELLOW, true);
	addColor(Color.rgb(127, 255, 0), true);

	addColor(Color.GREEN, true);
	addColor(Color.rgb(0, 255, 127), true);
	addColor(Color.CYAN, true);
	addColor(Color.rgb(0, 127, 255), true);

	addColor(Color.BLUE, true);
	addColor(Color.rgb(127, 0, 255), true);
	addColor(Color.MAGENTA, true);
	addColor(Color.rgb(255, 0, 127), true);

	for (int i = 0; i < BTN_PER_ROW; i++)
	    addColor(Color.WHITE, false);

	getChildren().add(forColor);
	getChildren().add(backColor);
	getChildren().add(buttonPane);
    }

    private void addColor(final Color color, boolean enabled) {
	Button b = new Button();
	b.setPrefSize(BTN_SIZE, BTN_SIZE);
	b.setMaxSize(BTN_SIZE, BTN_SIZE);
	b.setMinSize(BTN_SIZE, BTN_SIZE);
	b.setBackground(new Background(new BackgroundFill(color,
		new CornerRadii(5.0), null)));
	b.setBorder(new Border(new BorderStroke(Color.BLACK,
		BorderStrokeStyle.SOLID, new CornerRadii(5.0),
		null, null)));

	b.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		if (isForGround)
		    Properties.setColor(color);
		else
		    Properties.setBackground(color);
	    }
	});

	buttonPane.getChildren().add(b);

	if (!enabled)
	    b.setDisable(true);
    }

    public void enableButton(Button b) {
	b.setDisable(false);
    }
}