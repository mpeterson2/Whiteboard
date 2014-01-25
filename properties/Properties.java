package properties;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;


public class Properties {
    public static Properties PROPERTIES;

    private static Color color = Color.BLACK;
    private static Color background = Color.WHITE;
    private static double width = 5.0;
    private static List<PropertiesListener> listeners = new ArrayList<>();

    public static Color getColor() {
	return color;
    }

    public static void setColor(Color color) {
	Properties.color = color;
	for (PropertiesListener listener : listeners) {
	    listener.onForColorChng(color);
	}
    }

    public static void setColor(double r, double g, double b) {
	setColor(new Color(r, g, b, 1.0));
    }

    public static Color getBackground() {
	return background;
    }

    public static void setBackground(Color color) {
	background = color;

	for (PropertiesListener listener : listeners) {
	    listener.onBackColorChng(color);
	}
    }

    public static void setBackground(double r, double g, double b) {
	setBackground(new Color(r, g, b, 1.0));
    }

    public static void setWidth(double width) {
	Properties.width = width;

	for (PropertiesListener listener : listeners) {
	    listener.onWidthChng(width);
	}
    }

    public static double getWidth() {
	return width;
    }

    public static void updateListeners() {}

    public static void addListener(PropertiesListener listener) {
	listeners.add(listener);
    }

    public static void removeListener(PropertiesListener listener) {
	listeners.remove(listener);
    }

}
