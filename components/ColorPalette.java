package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import properties.Properties;

public class ColorPalette extends FlowPane {

    public static final double BTN_SIZE = 25;
    public static final double BTN_GAP = 2;
    public static final int BTN_PER_ROW = 8;
    public static final double WIDTH = BTN_SIZE * BTN_PER_ROW + BTN_GAP * BTN_PER_ROW;

    public ColorPalette() {
	setPrefWidth(WIDTH);
	setHgap(BTN_GAP);

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
    }

    private void addColor(final Color color, boolean enabled) {
	Button b = new Button();
	b.setPrefSize(BTN_SIZE, BTN_SIZE);
	b.setMaxSize(BTN_SIZE, BTN_SIZE);
	b.setMinSize(BTN_SIZE, BTN_SIZE);
	b.setBackground(new Background(new BackgroundFill(color,
		new CornerRadii(5.0), new Insets(0))));
	b.setBorder(new Border(new BorderStroke(Color.BLACK,
		BorderStrokeStyle.SOLID, new CornerRadii(5.0),
		BorderWidths.DEFAULT, new Insets(0))));

	b.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		Properties.setColor(color);
	    }
	});

	getChildren().add(b);

	if (!enabled)
	    b.setDisable(true);
    }

    public void enableButton(Button b) {
	b.setDisable(false);
    }
}