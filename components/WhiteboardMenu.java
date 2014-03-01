package components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;

/**
 * A Menu for a Whiteboard.
 */
public class WhiteboardMenu extends MenuBar {

    private Canvas canvas;
    private FileChooser fileChooser;

    /**
     * Create a WhiteboardMenu object.
     */
    public WhiteboardMenu(Canvas canvas) {
	this.canvas = canvas;

	// Setup the FileChooser.
	fileChooser = new FileChooser();
	fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
	fileChooser.setTitle("Save Screen Shot");

	// Setup the File Menu.
	Menu file = new Menu("file");

	// Create the screenshot menu item.
	MenuItem screenShot = new MenuItem("Save Screen Shot");
	screenShot.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent arg0) {
		saveScreenShot();
	    }
	});

	// Fill the file Menu.
	file.getItems().add(screenShot);

	// Fill the MenuBar.
	getMenus().add(file);
    }

    /**
     * Save a screenshot in a user-specified location.
     */
    public void saveScreenShot() {
	// Save the image in memory.
	WritableImage img = canvas.snapshot(new SnapshotParameters(), null);
	BufferedImage buffImg = SwingFXUtils.fromFXImage(img, null);

	// Open the file Chooser.
	File file = fileChooser.showSaveDialog(null);

	if (file != null) {
	    try {
		String extension = file.getPath().substring(file.getPath().lastIndexOf('.') + 1);
		System.out.println(extension);
		ImageIO.write(buffImg, extension, file);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
