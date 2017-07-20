package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author Alec Waddelow, Drew Rife, Marty Sease, and Chris Roadcap
 *
 * The main login screen launcher 
 */
public class GUI extends Application 
{

	/**
	 * Launches the GUI and starts the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}

	/**
	 * Overridden start method to load the fxml document and set the scene
	 */
	@Override
	public void start(Stage stage) throws IOException {
		 	Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
	        Scene scene = new Scene(root, 500, 500);
	        
	        stage.setTitle("Please log in");
	        stage.setScene(scene);
	        stage.show();
	}
}
