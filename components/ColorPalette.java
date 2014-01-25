package components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import properties.Properties;
import properties.PropertiesListener;

public class ColorPalette extends FlowPane implements PropertiesListener {

    public static final double BTN_SIZE = 25;
    public static final double BTN_GAP = 2;
    public static final int BTN_PER_ROW = 8;
    public static final double WIDTH = BTN_SIZE * BTN_PER_ROW + BTN_GAP * BTN_PER_ROW;
    public static final Border BTN_BORDER = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5.0), null, null));

    private FlowPane buttonPane;
    private boolean isForGround;

    VBox foregroundInfo;
    VBox backgroundInfo;
    Button foregroundBtn;
    Button backgroundBtn;

    public ColorPalette() {
	isForGround = true;
	setHgap(2.0);

	foregroundInfo = new VBox();
	foregroundBtn = new Button();
	foregroundBtn.setBorder(BTN_BORDER);
	createBigButton(foregroundBtn, foregroundInfo, true);

	backgroundInfo = new VBox();
	backgroundBtn = new Button();
	createBigButton(backgroundBtn, backgroundInfo, false);

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

	getChildren().add(foregroundInfo);
	getChildren().add(backgroundInfo);
	getChildren().add(buttonPane);
	Properties.addListener(this);
    }

    private void addColor(final Color color, boolean enabled) {
	Button b = new Button();
	b.setPrefSize(BTN_SIZE, BTN_SIZE);
	b.setMaxSize(BTN_SIZE, BTN_SIZE);
	b.setMinSize(BTN_SIZE, BTN_SIZE);
	b.setBackground(new Background(new BackgroundFill(color,
		new CornerRadii(5.0), null)));
	b.setBorder(BTN_BORDER);

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

    private void createBigButton(Button btn, VBox pane, final boolean forground) {
	Color color;
	if (forground)
	    color = Properties.getColor();
	else
	    color = Properties.getBackground();

	btn.setBackground(new Background(new BackgroundFill(color, new CornerRadii(5.0), null)));
	btn.setPrefSize(75, 50);

	btn.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		isForGround = forground;
		if (forground) {
		    foregroundBtn.setBorder(BTN_BORDER);
		    backgroundBtn.setBorder(null);
		}
		else {
		    foregroundBtn.setBorder(null);
		    backgroundBtn.setBorder(BTN_BORDER);
		}
	    }
	});

	pane.setAlignment(Pos.CENTER);
	pane.getChildren().add(btn);
	if (forground)
	    pane.getChildren().add(new Label("Foreground"));
	else
	    pane.getChildren().add(new Label("Background"));

    }

    @Override
    public void onForColorChng(Color color) {
	foregroundBtn.setBackground(new Background(new BackgroundFill(color, new CornerRadii(5.0), null)));
    }

    @Override
    public void onBackColorChng(Color color) {
	backgroundBtn.setBackground(new Background(new BackgroundFill(color, new CornerRadii(5.0), null)));
    }

    @Override
    public void onWidthChng(double width) {}
}