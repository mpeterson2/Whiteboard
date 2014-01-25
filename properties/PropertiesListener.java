package properties;

import javafx.scene.paint.Color;

public interface PropertiesListener {

    void onForeColorChng(Color color);

    void onBackColorChng(Color color);

    void onWidthChng(double width);


}
