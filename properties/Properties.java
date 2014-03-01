package properties;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;


/**
 * This is a class that will hold information about a Whiteboard and tell listeners all about it.
 * 
 * All of the setters will notify it's listeners for anyone who cares.
 */
public class Properties {
    public static Properties PROPERTIES;

    private static Color color = Defaults.PEN_COLOR;
    private static Color background = Defaults.BG_COLOR;
    private static double width = Defaults.WIDTH;
    private static List<PropertiesListener> listeners = new ArrayList<>();

    /**
     * Get the foreground color.
     */
    public static Color getForeColor() {
	return color;
    }

    /**
     * Set the foreground Color.
     */
    public static void setForeColor(Color color) {
	Properties.color = color;
	for (PropertiesListener listener : listeners) {
	    listener.onForeColorChng(color);
	}
    }

    /**
     * Sets the foreground color in a rgb format.
     */
    public static void setForeColor(double r, double g, double b) {
	setForeColor(new Color(r, g, b, 1.0));
    }

    /**
     * Get the background color.
     */
    public static Color getBackColor() {
	return background;
    }

    /**
     * Set the background color.
     */
    public static void setBackColor(Color color) {
	background = color;

	for (PropertiesListener listener : listeners) {
	    listener.onBackColorChng(color);
	}
    }

    /**
     * Set the background color in a rgb format.
     */
    public static void setBackground(double r, double g, double b) {
	setBackColor(new Color(r, g, b, 1.0));
    }

    /**
     * Get the width.
     */
    public static double getWidth() {
	return width;
    }

    /**
     * Set the width.
     */
    public static void setWidth(double width) {
	Properties.width = width;

	for (PropertiesListener listener : listeners) {
	    listener.onWidthChng(width);
	}
    }

    /**
     * Add a listener. Will initially tell the listener that it has been updated.
     */
    public static void addListener(PropertiesListener listener) {
	listeners.add(listener);

	// Be sure the listener has the correct values initially.
	listener.onForeColorChng(getForeColor());
	listener.onBackColorChng(getBackColor());
	listener.onWidthChng(getWidth());
    }

    /**
     * Remove a listener
     */
    public static void removeListener(PropertiesListener listener) {
	listeners.remove(listener);
    }

}
