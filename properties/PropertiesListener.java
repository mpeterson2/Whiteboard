package properties;

import javafx.scene.paint.Color;

/**
 * An interface to listen to Properties.
 */
public interface PropertiesListener {

    /**
     * Called when the foreground color is changed.
     */
    void onForeColorChng(Color color);

    /**
     * Called when the background color is changed.
     */
    void onBackColorChng(Color color);

    /**
     * Called when the width is changed.
     */
    void onWidthChng(double width);


}
